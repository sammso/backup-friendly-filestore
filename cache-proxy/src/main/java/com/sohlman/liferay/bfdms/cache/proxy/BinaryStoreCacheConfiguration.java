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

    @Meta.AD(
        deflt = "false",
        name = "stats-enabled-name",
        description = "stats-enabled-description",
        required = false
    )
    boolean statsEnabled();

    @Meta.AD(
        deflt = "60",
        name = "stats-report-interval-minutes-name",
        description = "stats-report-interval-minutes-description",
        required = false
    )
    int reportIntervalMinutes();

    @Meta.AD(
        deflt = "10",
        name = "stats-popular-files-max-count-name",
        description = "stats-popular-files-max-count-description",
        required = false
    )
    int popularFilesMaxCount();

    @Meta.AD(
        deflt = "10",
        name = "stats-slowest-files-max-count-name",
        description = "stats-slowest-files-max-count-description",
        required = false
    )
    int slowestFilesMaxCount();

}
