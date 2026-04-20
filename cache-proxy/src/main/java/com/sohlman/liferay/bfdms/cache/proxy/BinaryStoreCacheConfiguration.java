package com.sohlman.liferay.bfdms.cache.proxy;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
    id = "com.sohlman.liferay.bfdms.cache.proxy.BinaryStoreCacheConfiguration",
    localization = "content/Language",
    name = "binary-store-cache-configuration-name",
    description = "binary-store-cache-configuration-description"
)
public interface BinaryStoreCacheConfiguration {

    @Meta.AD(
        deflt = "noop",
        name = "binary-store-cache-type-name",
        description = "binary-store-cache-type-description",
        required = false
    )
    String cacheType();

}
