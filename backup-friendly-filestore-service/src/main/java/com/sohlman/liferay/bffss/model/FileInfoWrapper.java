package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FileInfo}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfo
 * @generated
 */
public class FileInfoWrapper implements FileInfo, ModelWrapper<FileInfo> {
    private FileInfo _fileInfo;

    public FileInfoWrapper(FileInfo fileInfo) {
        _fileInfo = fileInfo;
    }

    @Override
    public Class<?> getModelClass() {
        return FileInfo.class;
    }

    @Override
    public String getModelClassName() {
        return FileInfo.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fileInfoId", getFileInfoId());
        attributes.put("companyId", getCompanyId());
        attributes.put("repositoryId", getRepositoryId());
        attributes.put("path", getPath());
        attributes.put("version", getVersion());
        attributes.put("fileDataId", getFileDataId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long fileInfoId = (Long) attributes.get("fileInfoId");

        if (fileInfoId != null) {
            setFileInfoId(fileInfoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long repositoryId = (Long) attributes.get("repositoryId");

        if (repositoryId != null) {
            setRepositoryId(repositoryId);
        }

        String path = (String) attributes.get("path");

        if (path != null) {
            setPath(path);
        }

        String version = (String) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        Long fileDataId = (Long) attributes.get("fileDataId");

        if (fileDataId != null) {
            setFileDataId(fileDataId);
        }
    }

    /**
    * Returns the primary key of this file info.
    *
    * @return the primary key of this file info
    */
    @Override
    public long getPrimaryKey() {
        return _fileInfo.getPrimaryKey();
    }

    /**
    * Sets the primary key of this file info.
    *
    * @param primaryKey the primary key of this file info
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _fileInfo.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the file info ID of this file info.
    *
    * @return the file info ID of this file info
    */
    @Override
    public long getFileInfoId() {
        return _fileInfo.getFileInfoId();
    }

    /**
    * Sets the file info ID of this file info.
    *
    * @param fileInfoId the file info ID of this file info
    */
    @Override
    public void setFileInfoId(long fileInfoId) {
        _fileInfo.setFileInfoId(fileInfoId);
    }

    /**
    * Returns the company ID of this file info.
    *
    * @return the company ID of this file info
    */
    @Override
    public long getCompanyId() {
        return _fileInfo.getCompanyId();
    }

    /**
    * Sets the company ID of this file info.
    *
    * @param companyId the company ID of this file info
    */
    @Override
    public void setCompanyId(long companyId) {
        _fileInfo.setCompanyId(companyId);
    }

    /**
    * Returns the repository ID of this file info.
    *
    * @return the repository ID of this file info
    */
    @Override
    public long getRepositoryId() {
        return _fileInfo.getRepositoryId();
    }

    /**
    * Sets the repository ID of this file info.
    *
    * @param repositoryId the repository ID of this file info
    */
    @Override
    public void setRepositoryId(long repositoryId) {
        _fileInfo.setRepositoryId(repositoryId);
    }

    /**
    * Returns the path of this file info.
    *
    * @return the path of this file info
    */
    @Override
    public java.lang.String getPath() {
        return _fileInfo.getPath();
    }

    /**
    * Sets the path of this file info.
    *
    * @param path the path of this file info
    */
    @Override
    public void setPath(java.lang.String path) {
        _fileInfo.setPath(path);
    }

    /**
    * Returns the version of this file info.
    *
    * @return the version of this file info
    */
    @Override
    public java.lang.String getVersion() {
        return _fileInfo.getVersion();
    }

    /**
    * Sets the version of this file info.
    *
    * @param version the version of this file info
    */
    @Override
    public void setVersion(java.lang.String version) {
        _fileInfo.setVersion(version);
    }

    /**
    * Returns the file data ID of this file info.
    *
    * @return the file data ID of this file info
    */
    @Override
    public long getFileDataId() {
        return _fileInfo.getFileDataId();
    }

    /**
    * Sets the file data ID of this file info.
    *
    * @param fileDataId the file data ID of this file info
    */
    @Override
    public void setFileDataId(long fileDataId) {
        _fileInfo.setFileDataId(fileDataId);
    }

    @Override
    public boolean isNew() {
        return _fileInfo.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _fileInfo.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _fileInfo.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _fileInfo.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _fileInfo.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _fileInfo.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _fileInfo.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _fileInfo.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _fileInfo.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _fileInfo.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _fileInfo.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FileInfoWrapper((FileInfo) _fileInfo.clone());
    }

    @Override
    public int compareTo(com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
        return _fileInfo.compareTo(fileInfo);
    }

    @Override
    public int hashCode() {
        return _fileInfo.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sohlman.liferay.bffss.model.FileInfo> toCacheModel() {
        return _fileInfo.toCacheModel();
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo toEscapedModel() {
        return new FileInfoWrapper(_fileInfo.toEscapedModel());
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo toUnescapedModel() {
        return new FileInfoWrapper(_fileInfo.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _fileInfo.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _fileInfo.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _fileInfo.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FileInfoWrapper)) {
            return false;
        }

        FileInfoWrapper fileInfoWrapper = (FileInfoWrapper) obj;

        if (Validator.equals(_fileInfo, fileInfoWrapper._fileInfo)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public FileInfo getWrappedFileInfo() {
        return _fileInfo;
    }

    @Override
    public FileInfo getWrappedModel() {
        return _fileInfo;
    }

    @Override
    public void resetOriginalValues() {
        _fileInfo.resetOriginalValues();
    }
}
