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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class FileInfoSoap implements Serializable {
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
		}
		else {
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

	public FileInfoSoap() {
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

	private long _fileInfoId;
	private long _companyId;
	private long _repositoryId;
	private String _path;
	private String _version;
	private long _fileDataId;
}