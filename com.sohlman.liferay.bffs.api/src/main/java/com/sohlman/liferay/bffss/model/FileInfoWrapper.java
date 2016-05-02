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
@ProviderType
public class FileInfoWrapper implements FileInfo, ModelWrapper<FileInfo> {
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
		Long fileInfoId = (Long)attributes.get("fileInfoId");

		if (fileInfoId != null) {
			setFileInfoId(fileInfoId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long repositoryId = (Long)attributes.get("repositoryId");

		if (repositoryId != null) {
			setRepositoryId(repositoryId);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		Long fileDataId = (Long)attributes.get("fileDataId");

		if (fileDataId != null) {
			setFileDataId(fileDataId);
		}
	}

	@Override
	public java.lang.Object clone() {
		return new FileInfoWrapper((FileInfo)_fileInfo.clone());
	}

	@Override
	public int compareTo(com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
		return _fileInfo.compareTo(fileInfo);
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

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _fileInfo.getExpandoBridge();
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
	* Returns the file info ID of this file info.
	*
	* @return the file info ID of this file info
	*/
	@Override
	public long getFileInfoId() {
		return _fileInfo.getFileInfoId();
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
	* Returns the primary key of this file info.
	*
	* @return the primary key of this file info
	*/
	@Override
	public long getPrimaryKey() {
		return _fileInfo.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _fileInfo.getPrimaryKeyObj();
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
	* Returns the version of this file info.
	*
	* @return the version of this file info
	*/
	@Override
	public java.lang.String getVersion() {
		return _fileInfo.getVersion();
	}

	@Override
	public int hashCode() {
		return _fileInfo.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _fileInfo.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _fileInfo.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _fileInfo.isNew();
	}

	@Override
	public void persist() {
		_fileInfo.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fileInfo.setCachedModel(cachedModel);
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

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_fileInfo.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_fileInfo.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_fileInfo.setExpandoBridgeAttributes(serviceContext);
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

	/**
	* Sets the file info ID of this file info.
	*
	* @param fileInfoId the file info ID of this file info
	*/
	@Override
	public void setFileInfoId(long fileInfoId) {
		_fileInfo.setFileInfoId(fileInfoId);
	}

	@Override
	public void setNew(boolean n) {
		_fileInfo.setNew(n);
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
	* Sets the primary key of this file info.
	*
	* @param primaryKey the primary key of this file info
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fileInfo.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_fileInfo.setPrimaryKeyObj(primaryKeyObj);
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
	* Sets the version of this file info.
	*
	* @param version the version of this file info
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_fileInfo.setVersion(version);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.sohlman.liferay.bffss.model.FileInfo> toCacheModel() {
		return _fileInfo.toCacheModel();
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileInfo toEscapedModel() {
		return new FileInfoWrapper(_fileInfo.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fileInfo.toString();
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileInfo toUnescapedModel() {
		return new FileInfoWrapper(_fileInfo.toUnescapedModel());
	}

	@Override
	public java.lang.String toXmlString() {
		return _fileInfo.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileInfoWrapper)) {
			return false;
		}

		FileInfoWrapper fileInfoWrapper = (FileInfoWrapper)obj;

		if (Validator.equals(_fileInfo, fileInfoWrapper._fileInfo)) {
			return true;
		}

		return false;
	}

	@Override
	public FileInfo getWrappedModel() {
		return _fileInfo;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _fileInfo.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _fileInfo.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_fileInfo.resetOriginalValues();
	}

	private final FileInfo _fileInfo;
}