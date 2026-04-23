package com.sohlman.liferay.bfdms.store.impl;

import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.store.FolderFile;
import com.sohlman.liferay.bfdms.store.StorageNamingStrategy;
import com.sohlman.liferay.bfdms.util.Util;

import org.osgi.service.component.annotations.Component;

@Component(
    property = "naming.strategy.type=default",
    service = StorageNamingStrategy.class
)
public class DefaultStorageNamingStrategy implements StorageNamingStrategy {

    @Override
    public FolderFile generate(FileInfo fileInfo, String fingerPrint) {
        String name = Util.generateUniqName();
        String folder = name.substring(0, 2) + "/" + name.substring(2, 4);
        return new FolderFile(folder, name);
    }

    @Override
    public String resolvePath(String storedName, String fingerPrint) {
        return storedName.substring(0, 2) + "/" + storedName.substring(2, 4) + "/" + storedName;
    }

    @Override
    public String getType() {
        return "default";
    }

}
