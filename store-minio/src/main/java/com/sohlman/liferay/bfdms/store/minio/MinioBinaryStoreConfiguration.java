package com.sohlman.liferay.bfdms.store.minio;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
	id = "com.sohlman.liferay.bfdms.store.minio.MinioBinaryStoreConfiguration",
	localization = "content/Language",
	name = "minio-binary-store-configuration-name",
	description = "minio-binary-store-configuration-description"
)
public interface MinioBinaryStoreConfiguration {

	@Meta.AD(
		deflt = "http://localhost:9000",
		description = "minio-endpoint-description",
		name = "minio-endpoint-name",
		required = false
	)
	public String endpoint();

	@Meta.AD(
		deflt = "minioadmin",
		description = "minio-access-key-description",
		name = "minio-access-key-name",
		required = false
	)
	public String accessKey();

	@Meta.AD(
		deflt = "minioadmin",
		description = "minio-secret-key-description",
		name = "minio-secret-key-name",
		required = false,
		type = Meta.Type.Password
	)
	public String secretKey();

	@Meta.AD(
		deflt = "",
		description = "minio-region-description",
		name = "minio-region-name",
		required = false
	)
	public String region();

	@Meta.AD(
		deflt = "bfdms",
		description = "minio-bucket-description",
		name = "minio-bucket-name",
		required = false
	)
	public String bucket();

	@Meta.AD(
		deflt = "",
		description = "minio-namespace-folder-description",
		name = "minio-namespace-folder-name",
		required = false
	)
	public String namespaceFolder();

	@Meta.AD(
		deflt = "true",
		description = "minio-create-bucket-if-missing-description",
		name = "minio-create-bucket-if-missing-name",
		required = false
	)
	public boolean createBucketIfMissing();

	@Meta.AD(
		deflt = "5000",
		description = "minio-connect-timeout-millis-description",
		name = "minio-connect-timeout-millis-name",
		required = false
	)
	public long connectTimeoutMillis();

	@Meta.AD(
		deflt = "60000",
		description = "minio-write-timeout-millis-description",
		name = "minio-write-timeout-millis-name",
		required = false
	)
	public long writeTimeoutMillis();

	@Meta.AD(
		deflt = "60000",
		description = "minio-read-timeout-millis-description",
		name = "minio-read-timeout-millis-name",
		required = false
	)
	public long readTimeoutMillis();

}
