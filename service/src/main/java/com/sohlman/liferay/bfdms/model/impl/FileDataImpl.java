package com.sohlman.liferay.bfdms.model.impl;

import com.liferay.petra.string.StringBundler;
import com.sohlman.liferay.bfdms.store.FolderFile;

/**
 * The extended model implementation for the FileData service. Represents a row in the &quot;bffss_FileData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sohlman.liferay.bfdms.model.FileData} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class FileDataImpl extends FileDataBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a file data model instance should use the {@link com.sohlman.liferay.bfdms.model.FileData} interface instead.
     */
    public FileDataImpl() {
    }

    public FolderFile getFolderFile() {
        return new FolderFile(getDataFolder(), getDataName());
    }

    public void setFolderFile(FolderFile folderFile) {
        setDataFolder(folderFile.getFolder());
        setDataName(folderFile.getName());
    }
}
