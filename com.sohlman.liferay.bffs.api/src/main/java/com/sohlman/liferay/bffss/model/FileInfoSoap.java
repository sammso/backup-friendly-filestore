package com.sohlman.liferay.bffss.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileInfoSoap implements Serializable {
    private long _fileInfoId;
    private long _companyId;
    private long _repositoryId;
    private String _path;
    private String _version;
    private long _fileDataId;

    public FileInfoSoap() {
    }

    public static FileInfoSoap toSoapModel(FileInfo model) {
        FileInfoSoap soapModel = new FileInfoSoap();

        soapModel.setFileInfoId(model.getFileInfoId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setRepositoryId(model.getRepositoryId());
        soapModel.setPath(model.getPath());
        soapModel.setVersion(model.getVersion());
        soapModel.setFileDataId(model.getFileDataId());

        return soapModel;
    }

    public static FileInfoSoap[] toSoapModels(FileInfo[] models) {
        FileInfoSoap[] soapModels = new FileInfoSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static FileInfoSoap[][] toSoapModels(FileInfo[][] models) {
        FileInfoSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new FileInfoSoap[models.length][models[0].length];
        } else {
            soapModels = new FileInfoSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static FileInfoSoap[] toSoapModels(List<FileInfo> models) {
        List<FileInfoSoap> soapModels = new ArrayList<FileInfoSoap>(models.size());

        for (FileInfo model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new FileInfoSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _fileInfoId;
    }

    public void setPrimaryKey(long pk) {
        setFileInfoId(pk);
    }

    public long getFileInfoId() {
        return _fileInfoId;
    }

    public void setFileInfoId(long fileInfoId) {
        _fileInfoId = fileInfoId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getRepositoryId() {
        return _repositoryId;
    }

    public void setRepositoryId(long repositoryId) {
        _repositoryId = repositoryId;
    }

    public String getPath() {
        return _path;
    }

    public void setPath(String path) {
        _path = path;
    }

    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        _version = version;
    }

    public long getFileDataId() {
        return _fileDataId;
    }

    public void setFileDataId(long fileDataId) {
        _fileDataId = fileDataId;
    }
}
