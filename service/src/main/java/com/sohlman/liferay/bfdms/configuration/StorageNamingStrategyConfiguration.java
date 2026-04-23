package com.sohlman.liferay.bfdms.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
    id = "com.sohlman.liferay.bfdms.configuration.StorageNamingStrategyConfiguration",
    localization = "content/Language",
    name = "storage-naming-strategy-configuration-name",
    description = "storage-naming-strategy-configuration-description"
)
public interface StorageNamingStrategyConfiguration {

    @Meta.AD(
        deflt = "default",
        name = "storage-naming-strategy-type-name",
        description = "storage-naming-strategy-type-description",
        required = false
    )
    String namingStrategyType();

}
