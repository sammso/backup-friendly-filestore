package com.sohlman.liferay.bfdms.store.filesystem;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
	id = "com.sohlman.liferay.bfdms.store.filesystem.FileSystemBinaryStoreConfiguration",
	localization = "content/Language",
	name = "filesystem-binary-store-configuration-name",
	description = "filesystem-binary-store-configuration-description"
)
public interface FileSystemBinaryStoreConfiguration {
	@Meta.AD(
		deflt = "data/document_library",
		description = "filesystem-binary-store-root-dir-description",
		name = "filesystem-binary-store-root-dir-name",
		required = false
	)
	public String rootDir();
}
