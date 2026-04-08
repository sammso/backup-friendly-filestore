package com.sohlman.liferay.bfdms.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
/**
 * @author Sampsa Sohlman
 */
@ExtendedObjectClassDefinition(category = "foundation")
@Meta.OCD(
	id = "com.sohlman.liferay.bfdms.configuration.BackupFriendlyFileSystemStoreConfiguration",
	localization = "content/Language",
	name = "com.sohlman.liferay.bfdms.configuration.name"
)
public interface BackupFriendlyFileSystemStoreConfiguration {

	@Meta.AD(
		deflt = "data/document_library",
		description = 
			"com.sohlman.liferay.bfdms.configuration.root.dir.description", 
		required = false
	)
	public String rootDir();
}