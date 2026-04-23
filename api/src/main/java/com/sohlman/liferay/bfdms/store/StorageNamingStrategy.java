package com.sohlman.liferay.bfdms.store;

import com.sohlman.liferay.bfdms.model.FileInfo;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface StorageNamingStrategy {

    FolderFile generate(FileInfo fileInfo, String fingerPrint);

    /**
     * Reconstructs the full storage path from what was persisted in FileData.
     * Called on every retrieve — must be deterministic given storedName and fingerPrint.
     */
    String resolvePath(String storedName, String fingerPrint);

    String getType();

}
