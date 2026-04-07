/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

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
public class FileInfoWrapper
	extends BaseModelWrapper<FileInfo>
	implements FileInfo, ModelWrapper<FileInfo> {

	public FileInfoWrapper(FileInfo fileInfo) {
		super(fileInfo);
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
	public FileInfo cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this file info.
	 *
	 * @return the company ID of this file info
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the file data ID of this file info.
	 *
	 * @return the file data ID of this file info
	 */
	@Override
	public long getFileDataId() {
		return model.getFileDataId();
	}

	/**
	 * Returns the file info ID of this file info.
	 *
	 * @return the file info ID of this file info
	 */
	@Override
	public long getFileInfoId() {
		return model.getFileInfoId();
	}

	/**
	 * Returns the path of this file info.
	 *
	 * @return the path of this file info
	 */
	@Override
	public String getPath() {
		return model.getPath();
	}

	/**
	 * Returns the primary key of this file info.
	 *
	 * @return the primary key of this file info
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the repository ID of this file info.
	 *
	 * @return the repository ID of this file info
	 */
	@Override
	public long getRepositoryId() {
		return model.getRepositoryId();
	}

	/**
	 * Returns the version of this file info.
	 *
	 * @return the version of this file info
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this file info.
	 *
	 * @param companyId the company ID of this file info
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the file data ID of this file info.
	 *
	 * @param fileDataId the file data ID of this file info
	 */
	@Override
	public void setFileDataId(long fileDataId) {
		model.setFileDataId(fileDataId);
	}

	/**
	 * Sets the file info ID of this file info.
	 *
	 * @param fileInfoId the file info ID of this file info
	 */
	@Override
	public void setFileInfoId(long fileInfoId) {
		model.setFileInfoId(fileInfoId);
	}

	/**
	 * Sets the path of this file info.
	 *
	 * @param path the path of this file info
	 */
	@Override
	public void setPath(String path) {
		model.setPath(path);
	}

	/**
	 * Sets the primary key of this file info.
	 *
	 * @param primaryKey the primary key of this file info
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the repository ID of this file info.
	 *
	 * @param repositoryId the repository ID of this file info
	 */
	@Override
	public void setRepositoryId(long repositoryId) {
		model.setRepositoryId(repositoryId);
	}

	/**
	 * Sets the version of this file info.
	 *
	 * @param version the version of this file info
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FileInfoWrapper wrap(FileInfo fileInfo) {
		return new FileInfoWrapper(fileInfo);
	}

}