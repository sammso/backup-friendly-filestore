package com.sohlman.liferay.bfdms.store.s3;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
	id = "com.sohlman.liferay.bfdms.store.s3.S3BinaryStoreConfiguration",
	localization = "content/Language",
	name = "s3-binary-store-configuration-name",
	description = "s3-binary-store-configuration-description"
)
public interface S3BinaryStoreConfiguration {

	@Meta.AD(
		deflt = "",
		description = "s3-access-key-description",
		name = "s3-access-key-name",
		required = false
	)
	public String accessKey();

	@Meta.AD(
		deflt = "",
		description = "s3-secret-key-description",
		name = "s3-secret-key-name",
		required = false,
		type = Meta.Type.Password
	)
	public String secretKey();

	@Meta.AD(
		deflt = "us-east-1",
		description = "s3-region-description",
		name = "s3-region-name",
		required = false
	)
	public String region();

	@Meta.AD(
		deflt = "",
		description = "s3-endpoint-description",
		name = "s3-endpoint-name",
		required = false
	)
	public String endpoint();

	@Meta.AD(
		deflt = "false",
		description = "s3-path-style-access-description",
		name = "s3-path-style-access-name",
		required = false
	)
	public boolean pathStyleAccess();

	@Meta.AD(
		deflt = "bfdms",
		description = "s3-bucket-description",
		name = "s3-bucket-name",
		required = false
	)
	public String bucket();

	@Meta.AD(
		deflt = "",
		description = "s3-namespace-folder-description",
		name = "s3-namespace-folder-name",
		required = false
	)
	public String namespaceFolder();

	@Meta.AD(
		deflt = "STANDARD",
		description = "s3-storage-class-description",
		name = "s3-storage-class-name",
		required = false
	)
	public String storageClass();

	@Meta.AD(
		deflt = "true",
		description = "s3-create-bucket-if-missing-description",
		name = "s3-create-bucket-if-missing-name",
		required = false
	)
	public boolean createBucketIfMissing();

	@Meta.AD(
		deflt = "5000",
		description = "s3-connect-timeout-millis-description",
		name = "s3-connect-timeout-millis-name",
		required = false
	)
	public long connectTimeoutMillis();

	@Meta.AD(
		deflt = "60000",
		description = "s3-socket-timeout-millis-description",
		name = "s3-socket-timeout-millis-name",
		required = false
	)
	public long socketTimeoutMillis();

}
