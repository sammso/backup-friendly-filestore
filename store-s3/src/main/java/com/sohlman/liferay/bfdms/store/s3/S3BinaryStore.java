package com.sohlman.liferay.bfdms.store.s3;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sohlman.liferay.bfdms.store.BinaryStore;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.URI;

import java.time.Duration;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.http.SdkHttpClient;
import software.amazon.awssdk.http.urlconnection.UrlConnectionHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3ClientBuilder;
import software.amazon.awssdk.services.s3.S3Configuration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Object;
import software.amazon.awssdk.services.s3.model.StorageClass;

@Component(
	configurationPid = "com.sohlman.liferay.bfdms.store.s3.S3BinaryStoreConfiguration",
	immediate = true,
	property = "binary.store.type=s3",
	service = BinaryStore.class
)
public class S3BinaryStore implements BinaryStore {

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		S3BinaryStoreConfiguration configuration =
			ConfigurableUtil.createConfigurable(
				S3BinaryStoreConfiguration.class, properties);

		String accessKey = configuration.accessKey();
		String secretKey = configuration.secretKey();
		String region = configuration.region();
		String endpoint = configuration.endpoint();

		AwsCredentialsProvider credentialsProvider;

		if (!accessKey.isEmpty() && !secretKey.isEmpty()) {
			credentialsProvider = StaticCredentialsProvider.create(
				AwsBasicCredentials.create(accessKey, secretKey));
		}
		else {
			credentialsProvider = DefaultCredentialsProvider.create();
		}

		SdkHttpClient httpClient = UrlConnectionHttpClient.builder(
		).connectionTimeout(
			Duration.ofMillis(configuration.connectTimeoutMillis())
		).socketTimeout(
			Duration.ofMillis(configuration.socketTimeoutMillis())
		).build();

		S3ClientBuilder clientBuilder = S3Client.builder(
		).credentialsProvider(
			credentialsProvider
		).httpClient(
			httpClient
		).region(
			Region.of(region)
		);

		if (!endpoint.isEmpty()) {
			clientBuilder = clientBuilder.endpointOverride(URI.create(endpoint));
		}

		if (configuration.pathStyleAccess()) {
			clientBuilder = clientBuilder.serviceConfiguration(
				S3Configuration.builder().pathStyleAccessEnabled(
					true
				).build());
		}

		_client = clientBuilder.build();
		_bucket = configuration.bucket();
		_region = region;
		_namespacePrefix = _normalize(configuration.namespaceFolder());
		_createBucketIfMissing = configuration.createBucketIfMissing();
		_storageClass = StorageClass.fromValue(configuration.storageClass());
		_bucketEnsured = false;

		if (_log.isInfoEnabled()) {
			_log.info(
				StringBundler.concat(
					"S3BinaryStore activated: region=", _region, " endpoint=",
					endpoint.isEmpty() ? "<aws-default>" : endpoint, " bucket=",
					_bucket, " namespaceFolder=",
					_namespacePrefix.isEmpty() ? "<root>" : _namespacePrefix,
					" storageClass=", _storageClass.toString()));
		}
	}

	@Override
	public void store(long companyId, String path, InputStream inputStream)
		throws IOException {

		_ensureBucket();

		String key = _toKey(path);

		PutObjectRequest request = PutObjectRequest.builder(
		).bucket(
			_bucket
		).key(
			key
		).storageClass(
			_storageClass
		).build();

		try {
			_client.putObject(
				request,
				RequestBody.fromInputStream(
					inputStream, _contentLength(inputStream)));
		}
		catch (S3Exception s3Exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to store object ", key, " in bucket ", _bucket),
				s3Exception);
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
			ResponseInputStream<GetObjectResponse> response =
				_client.getObject(
					GetObjectRequest.builder().bucket(
						_bucket
					).key(
						key
					).build());

			return response;
		}
		catch (S3Exception s3Exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to retrieve object ", key, " from bucket ", _bucket),
				s3Exception);
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
			_client.deleteObject(
				DeleteObjectRequest.builder().bucket(
					_bucket
				).key(
					key
				).build());
		}
		catch (S3Exception s3Exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to delete object ", key, " from bucket ", _bucket),
				s3Exception);
		}
	}

	@Override
	public boolean exists(long companyId, String path) throws IOException {
		String key = _toKey(path);

		try {
			_client.headObject(
				HeadObjectRequest.builder().bucket(
					_bucket
				).key(
					key
				).build());

			return true;
		}
		catch (NoSuchKeyException noSuchKeyException) {
			return false;
		}
		catch (S3Exception s3Exception) {
			if (s3Exception.statusCode() == 404) {
				return false;
			}

			throw new IOException(
				StringBundler.concat(
					"Failed to stat object ", key, " in bucket ", _bucket),
				s3Exception);
		}
	}

	@Override
	public void forEach(long companyId, PathConsumer consumer)
		throws IOException {

		String prefix = _namespacePrefix.isEmpty() ? null :
			StringBundler.concat(_namespacePrefix, "/");

		ListObjectsV2Request.Builder requestBuilder =
			ListObjectsV2Request.builder().bucket(_bucket);

		if (prefix != null) {
			requestBuilder = requestBuilder.prefix(prefix);
		}

		try {
			for (ListObjectsV2Response page :
					_client.listObjectsV2Paginator(requestBuilder.build())) {

				for (S3Object s3Object : page.contents()) {
					String key = s3Object.key();
					String path = (prefix == null) ? key :
						key.substring(prefix.length());

					consumer.accept(path);
				}
			}
		}
		catch (S3Exception s3Exception) {
			throw new IOException(
				StringBundler.concat(
					"Failed to list objects in bucket ", _bucket),
				s3Exception);
		}
	}

	@Override
	public String getType() {
		return "s3";
	}

	private long _contentLength(InputStream inputStream) throws IOException {
		if (inputStream instanceof FileInputStream) {
			return ((FileInputStream)inputStream).getChannel().size();
		}

		return -1;
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
				_client.headBucket(
					HeadBucketRequest.builder().bucket(_bucket).build());
			}
			catch (NoSuchBucketException noSuchBucketException) {
				try {
					_client.createBucket(
						CreateBucketRequest.builder().bucket(_bucket).build());

					if (_log.isInfoEnabled()) {
						_log.info(
							StringBundler.concat(
								"Created S3 bucket: ", _bucket));
					}
				}
				catch (S3Exception createException) {
					throw new IOException(
						StringBundler.concat(
							"Failed to create bucket ", _bucket),
						createException);
				}
			}
			catch (S3Exception s3Exception) {
				throw new IOException(
					StringBundler.concat(
						"Failed to verify bucket ", _bucket),
					s3Exception);
			}

			_bucketEnsured = true;
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

		return StringBundler.concat(_namespacePrefix, "/", path);
	}

	private static final Log _log = LogFactoryUtil.getLog(S3BinaryStore.class);

	private volatile String _bucket;
	private volatile boolean _bucketEnsured;
	private final Object _bucketLock = new Object();
	private volatile S3Client _client;
	private volatile boolean _createBucketIfMissing;
	private volatile String _namespacePrefix = "";
	private volatile String _region;
	private volatile StorageClass _storageClass = StorageClass.STANDARD;

}
