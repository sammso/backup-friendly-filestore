package com.sohlman.liferay.bfdms.store;

public final class FolderFile {

    public FolderFile(String folder, String name) {
        _folder = folder;
        _name = name;
    }

    public String getFolder() {
        return _folder;
    }

    public String getName() {
        return _name;
    }

    public String getPath() {
        return _folder + "/" + _name;
    }

    private final String _folder;
    private final String _name;

}
