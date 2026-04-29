package com.sohlman.liferay.bfdms.store.proxy;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
	id = "com.sohlman.liferay.bfdms.store.proxy.BinaryStoreConfiguration",
	localization = "content/Language",
	name = "binary-store-configuration-name",
	description = "binary-store-configuration-description"
)
public interface BinaryStoreConfiguration {

	@Meta.AD(
		deflt = "filesystem",
		description = "binary-store-type-description",
		name = "binary-store-type-name",
		required = false
	)
	public String binaryStoreType();

}
