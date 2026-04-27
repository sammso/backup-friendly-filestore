/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

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
public class FileDataWrapper
	extends BaseModelWrapper<FileData>
	implements FileData, ModelWrapper<FileData> {

	public FileDataWrapper(FileData fileData) {
		super(fileData);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("fileDataId", getFileDataId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("dataFolder", getDataFolder());
		attributes.put("dataName", getDataName());
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

		String dataFolder = (String)attributes.get("dataFolder");

		if (dataFolder != null) {
			setDataFolder(dataFolder);
		}

		String dataName = (String)attributes.get("dataName");

		if (dataName != null) {
			setDataName(dataName);
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
	public FileData cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this file data.
	 *
	 * @return the company ID of this file data
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this file data.
	 *
	 * @return the create date of this file data
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the data folder of this file data.
	 *
	 * @return the data folder of this file data
	 */
	@Override
	public String getDataFolder() {
		return model.getDataFolder();
	}

	/**
	 * Returns the data name of this file data.
	 *
	 * @return the data name of this file data
	 */
	@Override
	public String getDataName() {
		return model.getDataName();
	}

	/**
	 * Returns the file data ID of this file data.
	 *
	 * @return the file data ID of this file data
	 */
	@Override
	public long getFileDataId() {
		return model.getFileDataId();
	}

	/**
	 * Returns the fingerprint of this file data.
	 *
	 * @return the fingerprint of this file data
	 */
	@Override
	public String getFingerprint() {
		return model.getFingerprint();
	}

	@Override
	public com.sohlman.liferay.bfdms.store.FolderFile getFolderFile() {
		return model.getFolderFile();
	}

	/**
	 * Returns the primary key of this file data.
	 *
	 * @return the primary key of this file data
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the size of this file data.
	 *
	 * @return the size of this file data
	 */
	@Override
	public long getSize() {
		return model.getSize();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this file data.
	 *
	 * @param companyId the company ID of this file data
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this file data.
	 *
	 * @param createDate the create date of this file data
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the data folder of this file data.
	 *
	 * @param dataFolder the data folder of this file data
	 */
	@Override
	public void setDataFolder(String dataFolder) {
		model.setDataFolder(dataFolder);
	}

	/**
	 * Sets the data name of this file data.
	 *
	 * @param dataName the data name of this file data
	 */
	@Override
	public void setDataName(String dataName) {
		model.setDataName(dataName);
	}

	/**
	 * Sets the file data ID of this file data.
	 *
	 * @param fileDataId the file data ID of this file data
	 */
	@Override
	public void setFileDataId(long fileDataId) {
		model.setFileDataId(fileDataId);
	}

	/**
	 * Sets the fingerprint of this file data.
	 *
	 * @param fingerprint the fingerprint of this file data
	 */
	@Override
	public void setFingerprint(String fingerprint) {
		model.setFingerprint(fingerprint);
	}

	@Override
	public void setFolderFile(
		com.sohlman.liferay.bfdms.store.FolderFile folderFile) {

		model.setFolderFile(folderFile);
	}

	/**
	 * Sets the primary key of this file data.
	 *
	 * @param primaryKey the primary key of this file data
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the size of this file data.
	 *
	 * @param size the size of this file data
	 */
	@Override
	public void setSize(long size) {
		model.setSize(size);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected FileDataWrapper wrap(FileData fileData) {
		return new FileDataWrapper(fileData);
	}

}