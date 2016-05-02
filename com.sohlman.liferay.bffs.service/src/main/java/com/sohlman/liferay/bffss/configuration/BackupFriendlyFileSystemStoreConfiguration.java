package com.sohlman.liferay.bffss.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;
/**
 * @author Sampsa Sohlman
 */
@ExtendedObjectClassDefinition(category = "foundation")
@Meta.OCD(
	id = "com.sohlman.liferay.bffss.configuration.BackupFriendlyFileSystemStoreConfiguration",
	localization = "content/Language",
	name = "com.sohlman.liferay.bffss.configuration.name"
)
public interface BackupFriendlyFileSystemStoreConfiguration {

	@Meta.AD(
		deflt = "data/document_library",
		description = 
			"com.sohlman.liferay.bffss.configuration.root.dir.description", 
		required = false
	)
	public String rootDir();
}