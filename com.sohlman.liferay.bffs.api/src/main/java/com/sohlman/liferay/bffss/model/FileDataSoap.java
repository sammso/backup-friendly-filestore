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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FileDataSoap implements Serializable {
	public static FileDataSoap toSoapModel(FileData model) {
		FileDataSoap soapModel = new FileDataSoap();

		soapModel.setFileDataId(model.getFileDataId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setName(model.getName());
		soapModel.setSize(model.getSize());
		soapModel.setFingerprint(model.getFingerprint());

		return soapModel;
	}

	public static FileDataSoap[] toSoapModels(FileData[] models) {
		FileDataSoap[] soapModels = new FileDataSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FileDataSoap[][] toSoapModels(FileData[][] models) {
		FileDataSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FileDataSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FileDataSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FileDataSoap[] toSoapModels(List<FileData> models) {
		List<FileDataSoap> soapModels = new ArrayList<FileDataSoap>(models.size());

		for (FileData model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FileDataSoap[soapModels.size()]);
	}

	public FileDataSoap() {
	}

	public long getPrimaryKey() {
		return _fileDataId;
	}

	public void setPrimaryKey(long pk) {
		setFileDataId(pk);
	}

	public long getFileDataId() {
		return _fileDataId;
	}

	public void setFileDataId(long fileDataId) {
		_fileDataId = fileDataId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getSize() {
		return _size;
	}

	public void setSize(long size) {
		_size = size;
	}

	public String getFingerprint() {
		return _fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		_fingerprint = fingerprint;
	}

	private long _fileDataId;
	private long _companyId;
	private Date _createDate;
	private String _name;
	private long _size;
	private String _fingerprint;
}