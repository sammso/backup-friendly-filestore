/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sohlman.liferay.bffss.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

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
@ProviderType
public class FileDataWrapper implements FileData, ModelWrapper<FileData> {
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
		attributes.put("fingerprint", getFingerprint());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long fileDataId = (Long)attributes.get("fileDataId");

		if (fileDataId != null) {
			setFileDataId(fileDataId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long size = (Long)attributes.get("size");

		if (size != null) {
			setSize(size);
		}

		String fingerprint = (String)attributes.get("fingerprint");

		if (fingerprint != null) {
			setFingerprint(fingerprint);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new FileDataWrapper((FileData)_fileData.clone());
	}

	@Override
	public int compareTo(com.sohlman.liferay.bffss.model.FileData fileData) {
		return _fileData.compareTo(fileData);
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
	* Returns the create date of this file data.
	*
	* @return the create date of this file data
	*/
	@Override
	public Date getCreateDate() {
		return _fileData.getCreateDate();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fileData.getExpandoBridge();
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
	* Returns the fingerprint of this file data.
	*
	* @return the fingerprint of this file data
	*/
	@Override
	public java.lang.String getFingerprint() {
		return _fileData.getFingerprint();
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
	* Returns the primary key of this file data.
	*
	* @return the primary key of this file data
	*/
	@Override
	public long getPrimaryKey() {
		return _fileData.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileData.getPrimaryKeyObj();
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

	@Override
	public int hashCode() {
		return _fileData.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fileData.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fileData.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fileData.isNew();
	}

	@Override
	public void persist() {
		_fileData.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fileData.setCachedModel(cachedModel);
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
	* Sets the create date of this file data.
	*
	* @param createDate the create date of this file data
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_fileData.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fileData.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fileData.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fileData.setExpandoBridgeAttributes(serviceContext);
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
	* Sets the fingerprint of this file data.
	*
	* @param fingerprint the fingerprint of this file data
	*/
	@Override
	public void setFingerprint(java.lang.String fingerprint) {
		_fileData.setFingerprint(fingerprint);
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

	@Override
	public void setNew(boolean n) {
		_fileData.setNew(n);
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

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fileData.setPrimaryKeyObj(primaryKeyObj);
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

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.sohlman.liferay.bffss.model.FileData> toCacheModel() {
		return _fileData.toCacheModel();
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileData toEscapedModel() {
		return new FileDataWrapper(_fileData.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileData.toString();
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileData toUnescapedModel() {
		return new FileDataWrapper(_fileData.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _fileData.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileDataWrapper)) {
			return false;
		}

		FileDataWrapper fileDataWrapper = (FileDataWrapper)obj;

		if (Validator.equals(_fileData, fileDataWrapper._fileData)) {
			return true;
		}

		return false;
	}

	@Override
	public FileData getWrappedModel() {
		return _fileData;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fileData.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fileData.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fileData.resetOriginalValues();
	}

	private final FileData _fileData;
}