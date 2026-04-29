package com.sohlman.liferay.bfdms.store.minio;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sohlman.liferay.bfdms.store.BinaryStore;

import io.minio.BucketExistsArgs;
import io.minio.GetObjectArgs;
import io.minio.ListObjectsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.RemoveObjectArgs;
import io.minio.Result;
import io.minio.StatObjectArgs;
import io.minio.errors.ErrorResponseException;
import io.minio.messages.Item;

import java.io.IOException;
import java.io.InputStream;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

@Component(
	configurationPid = "com.sohlman.liferay.bfdms.store.minio.MinioBinaryStoreConfiguration",
	immediate = true,
	property = "binary.store.type=minio",
	service = BinaryStore.class
)
public class MinioBinaryStore implements BinaryStore {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		MinioBinaryStoreConfiguration configuration =
			ConfigurableUtil.createConfigurable(
				MinioBinaryStoreConfiguration.class, properties);

		String endpoint = configuration.endpoint();
		String accessKey = configuration.accessKey();
		String secretKey = configuration.secretKey();
		String region = configuration.region();
		String bucket = configuration.bucket();

		MinioClient.Builder clientBuilder = MinioClient.builder(
		).endpoint(
			endpoint
		).credentials(
			accessKey, secretKey
		);

		if ((region != null) && !region.isEmpty()) {
			clientBuilder = clientBuilder.region(region);
		}

		MinioClient client = clientBuilder.build();

		client.setTimeout(
			configuration.connectTimeoutMillis(),
			configuration.writeTimeoutMillis(),
			configuration.readTimeoutMillis());

		_client = client;
		_bucket = bucket;
		_region = region;
		_namespacePrefix = _normalize(configuration.namespaceFolder());
		_createBucketIfMissing = configuration.createBucketIfMissing();
		_bucketEnsured = false;

		if (_log.isInfoEnabled()) {
			_log.info(
				StringBundler.concat(
					"MinioBinaryStore activated: endpoint=", endpoint,
					" bucket=", bucket, " namespaceFolder=",
					_namespacePrefix.isEmpty() ? "<root>" : _namespacePrefix));
		}
	}

	@Override
	public void store(long companyId, String path, InputStream inputStream)
		throws IOException {

		_ensureBucket();

		String key = _toKey(path);

		try {
			_client.putObject(
				PutObjectArgs.builder().bucket(
					_bucket
				).object(
					key
				).stream(
					inputStream, -1, _PART_SIZE
				).build());
		}
		catch (Exception exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to store object ", key, " in bucket ", _bucket),
				exception);
		}

		if (_log.isInfoEnabled()) {
			_log.info(
				StringBundler.concat(
					"Stored binary: companyId=", String.valueOf(companyId),
					" bucket=", _bucket, " key=", key));
		}
	}

	@Override
	public InputStream retrieve(long companyId, String path)
		throws IOException {

		String key = _toKey(path);

		try {
			return _client.getObject(
				GetObjectArgs.builder().bucket(
					_bucket
				).object(
					key
				).build());
		}
		catch (Exception exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to retrieve object ", key, " from bucket ", _bucket),
				exception);
		}
	}

	@Override
	public void delete(long companyId, String path) throws IOException {
		String key = _toKey(path);

		if (_log.isInfoEnabled()) {
			_log.info(
				StringBundler.concat(
					"Deleting binary: companyId=", String.valueOf(companyId),
					" bucket=", _bucket, " key=", key));
		}

		try {
			_client.removeObject(
				RemoveObjectArgs.builder().bucket(
					_bucket
				).object(
					key
				).build());
		}
		catch (Exception exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to delete object ", key, " from bucket ", _bucket),
				exception);
		}
	}

	@Override
	public boolean exists(long companyId, String path) throws IOException {
		String key = _toKey(path);

		try {
			_client.statObject(
				StatObjectArgs.builder().bucket(
					_bucket
				).object(
					key
				).build());

			return true;
		}
		catch (ErrorResponseException errorResponseException) {
			String code = errorResponseException.errorResponse().code();

			if ("NoSuchKey".equals(code) || "NoSuchObject".equals(code)) {
				return false;
			}

			throw new IOException(
				StringBundler.concat(
					"Failed to stat object ", key, " in bucket ", _bucket),
				errorResponseException);
		}
		catch (Exception exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to stat object ", key, " in bucket ", _bucket),
				exception);
		}
	}

	@Override
	public void forEach(long companyId, PathConsumer consumer)
		throws IOException {

		String prefix = _namespacePrefix.isEmpty() ? "" :
			StringBundler.concat(_namespacePrefix, "/");

		ListObjectsArgs.Builder listBuilder = ListObjectsArgs.builder().bucket(
			_bucket
		).recursive(
			true
		);

		if (!prefix.isEmpty()) {
			listBuilder = listBuilder.prefix(prefix);
		}

		Iterable<Result<Item>> results = _client.listObjects(listBuilder.build());

		for (Result<Item> result : results) {
			String key;

			try {
				key = result.get().objectName();
			}
			catch (Exception exception) {
				throw new IOException(
					StringBundler.concat(
						"Failed to list objects in bucket ", _bucket),
					exception);
			}

			String path = prefix.isEmpty() ? key : key.substring(prefix.length());

			consumer.accept(path);
		}
	}

	@Override
	public String getType() {
		return "minio";
	}

	private void _ensureBucket() throws IOException {
		if (_bucketEnsured || !_createBucketIfMissing) {
			return;
		}

		synchronized (_bucketLock) {
			if (_bucketEnsured) {
				return;
			}

			try {
				boolean exists = _client.bucketExists(
					BucketExistsArgs.builder().bucket(_bucket).build());

				if (!exists) {
					MakeBucketArgs.Builder makeBucketBuilder =
						MakeBucketArgs.builder().bucket(_bucket);

					if ((_region != null) && !_region.isEmpty()) {
						makeBucketBuilder = makeBucketBuilder.region(_region);
					}

					_client.makeBucket(makeBucketBuilder.build());

					if (_log.isInfoEnabled()) {
						_log.info(
							StringBundler.concat(
								"Created MinIO bucket: ", _bucket));
					}
				}

				_bucketEnsured = true;
			}
			catch (Exception exception) {
				throw new IOException(
					StringBundler.concat(
						"Failed to verify or create bucket ", _bucket),
					exception);
			}
		}
	}

	private String _normalize(String namespaceFolder) {
		if ((namespaceFolder == null) || namespaceFolder.isEmpty()) {
			return "";
		}

		String trimmed = namespaceFolder.trim();

		while (trimmed.startsWith("/")) {
			trimmed = trimmed.substring(1);
		}

		while (trimmed.endsWith("/")) {
			trimmed = trimmed.substring(0, trimmed.length() - 1);
		}

		return trimmed;
	}

	private String _toKey(String path) {
		if (_namespacePrefix.isEmpty()) {
			return path;
		}

		return StringBundler.concat(_namespacePrefix,"/",path);
	}

	private static final long _PART_SIZE = 10L * 1024L * 1024L;

	private static final Log _log = LogFactoryUtil.getLog(
		MinioBinaryStore.class);

	private volatile String _bucket;
	private volatile boolean _bucketEnsured;
	private final Object _bucketLock = new Object();
	private volatile MinioClient _client;
	private volatile boolean _createBucketIfMissing;
	private volatile String _namespacePrefix = "";
	private volatile String _region;

}
