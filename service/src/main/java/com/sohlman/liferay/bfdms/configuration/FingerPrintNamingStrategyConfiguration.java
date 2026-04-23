package com.sohlman.liferay.bfdms.configuration;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

@ExtendedObjectClassDefinition(category = "file-storage")
@Meta.OCD(
    id = "com.sohlman.liferay.bfdms.configuration.FingerPrintNamingStrategyConfiguration",
    localization = "content/Language",
    name = "fingerprint-naming-strategy-configuration-name",
    description = "fingerprint-naming-strategy-configuration-description"
)
public interface FingerPrintNamingStrategyConfiguration {

    @Meta.AD(
        deflt = "2",
        min = "1",
        name = "fingerprint-naming-folder-chars-per-level-name",
        description = "fingerprint-naming-folder-chars-per-level-description",
        required = false
    )
    int folderCharsPerLevel();

    @Meta.AD(
        deflt = "2",
        min = "1",
        max = "9",
        name = "fingerprint-naming-folder-depth-name",
        description = "fingerprint-naming-folder-depth-description",
        required = false
    )
    int folderDepth();

    @Meta.AD(
        deflt = "false",
        name = "fingerprint-naming-strip-folder-prefix-name",
        description = "fingerprint-naming-strip-folder-prefix-description",
        required = false
    )
    boolean stripFolderPrefixFromName();

}
