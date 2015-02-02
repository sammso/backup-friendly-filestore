package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FileData}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileData
 * @generated
 */
public class FileDataWrapper implements FileData, ModelWrapper<FileData> {
    private FileData _fileData;

    public FileDataWrapper(FileData fileData) {
        _fileData = fileData;
    }

    @Override
    public Class<?> getModelClass() {
        return FileData.class;
    }

    @Override
    public String getModelClassName() {
        return FileData.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fileDataId", getFileDataId());
        attributes.put("companyId", getCompanyId());
        attributes.put("createDate", getCreateDate());
        attributes.put("name", getName());
        attributes.put("size", getSize());
        attributes.put("deletedTimestamp", getDeletedTimestamp());
        attributes.put("fingerprint", getFingerprint());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long fileDataId = (Long) attributes.get("fileDataId");

        if (fileDataId != null) {
            setFileDataId(fileDataId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long size = (Long) attributes.get("size");

        if (size != null) {
            setSize(size);
        }

        Long deletedTimestamp = (Long) attributes.get("deletedTimestamp");

        if (deletedTimestamp != null) {
            setDeletedTimestamp(deletedTimestamp);
        }

        String fingerprint = (String) attributes.get("fingerprint");

        if (fingerprint != null) {
            setFingerprint(fingerprint);
        }
    }

    /**
    * Returns the primary key of this file data.
    *
    * @return the primary key of this file data
    */
    @Override
    public long getPrimaryKey() {
        return _fileData.getPrimaryKey();
    }

    /**
    * Sets the primary key of this file data.
    *
    * @param primaryKey the primary key of this file data
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _fileData.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the file data ID of this file data.
    *
    * @return the file data ID of this file data
    */
    @Override
    public long getFileDataId() {
        return _fileData.getFileDataId();
    }

    /**
    * Sets the file data ID of this file data.
    *
    * @param fileDataId the file data ID of this file data
    */
    @Override
    public void setFileDataId(long fileDataId) {
        _fileData.setFileDataId(fileDataId);
    }

    /**
    * Returns the company ID of this file data.
    *
    * @return the company ID of this file data
    */
    @Override
    public long getCompanyId() {
        return _fileData.getCompanyId();
    }

    /**
    * Sets the company ID of this file data.
    *
    * @param companyId the company ID of this file data
    */
    @Override
    public void setCompanyId(long companyId) {
        _fileData.setCompanyId(companyId);
    }

    /**
    * Returns the create date of this file data.
    *
    * @return the create date of this file data
    */
    @Override
    public java.util.Date getCreateDate() {
        return _fileData.getCreateDate();
    }

    /**
    * Sets the create date of this file data.
    *
    * @param createDate the create date of this file data
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _fileData.setCreateDate(createDate);
    }

    /**
    * Returns the name of this file data.
    *
    * @return the name of this file data
    */
    @Override
    public java.lang.String getName() {
        return _fileData.getName();
    }

    /**
    * Sets the name of this file data.
    *
    * @param name the name of this file data
    */
    @Override
    public void setName(java.lang.String name) {
        _fileData.setName(name);
    }

    /**
    * Returns the size of this file data.
    *
    * @return the size of this file data
    */
    @Override
    public long getSize() {
        return _fileData.getSize();
    }

    /**
    * Sets the size of this file data.
    *
    * @param size the size of this file data
    */
    @Override
    public void setSize(long size) {
        _fileData.setSize(size);
    }

    /**
    * Returns the deleted timestamp of this file data.
    *
    * @return the deleted timestamp of this file data
    */
    @Override
    public long getDeletedTimestamp() {
        return _fileData.getDeletedTimestamp();
    }

    /**
    * Sets the deleted timestamp of this file data.
    *
    * @param deletedTimestamp the deleted timestamp of this file data
    */
    @Override
    public void setDeletedTimestamp(long deletedTimestamp) {
        _fileData.setDeletedTimestamp(deletedTimestamp);
    }

    /**
    * Returns the fingerprint of this file data.
    *
    * @return the fingerprint of this file data
    */
    @Override
    public java.lang.String getFingerprint() {
        return _fileData.getFingerprint();
    }

    /**
    * Sets the fingerprint of this file data.
    *
    * @param fingerprint the fingerprint of this file data
    */
    @Override
    public void setFingerprint(java.lang.String fingerprint) {
        _fileData.setFingerprint(fingerprint);
    }

    @Override
    public boolean isNew() {
        return _fileData.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _fileData.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _fileData.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _fileData.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _fileData.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _fileData.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _fileData.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _fileData.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _fileData.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _fileData.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _fileData.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new FileDataWrapper((FileData) _fileData.clone());
    }

    @Override
    public int compareTo(FileData fileData) {
        return _fileData.compareTo(fileData);
    }

    @Override
    public int hashCode() {
        return _fileData.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<FileData> toCacheModel() {
        return _fileData.toCacheModel();
    }

    @Override
    public FileData toEscapedModel() {
        return new FileDataWrapper(_fileData.toEscapedModel());
    }

    @Override
    public FileData toUnescapedModel() {
        return new FileDataWrapper(_fileData.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _fileData.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _fileData.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _fileData.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FileDataWrapper)) {
            return false;
        }

        FileDataWrapper fileDataWrapper = (FileDataWrapper) obj;

        if (Validator.equals(_fileData, fileDataWrapper._fileData)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public FileData getWrappedFileData() {
        return _fileData;
    }

    @Override
    public FileData getWrappedModel() {
        return _fileData;
    }

    @Override
    public void resetOriginalValues() {
        _fileData.resetOriginalValues();
    }
}
