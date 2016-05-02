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

package com.sohlman.liferay.bffss.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.sohlman.liferay.bffss.model.FileData;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FileData in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FileData
 * @generated
 */
@ProviderType
public class FileDataCacheModel implements CacheModel<FileData>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FileDataCacheModel)) {
			return false;
		}

		FileDataCacheModel fileDataCacheModel = (FileDataCacheModel)obj;

		if (fileDataId == fileDataCacheModel.fileDataId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileDataId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{fileDataId=");
		sb.append(fileDataId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", size=");
		sb.append(size);
		sb.append(", fingerprint=");
		sb.append(fingerprint);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileData toEntityModel() {
		FileDataImpl fileDataImpl = new FileDataImpl();

		fileDataImpl.setFileDataId(fileDataId);
		fileDataImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			fileDataImpl.setCreateDate(null);
		}
		else {
			fileDataImpl.setCreateDate(new Date(createDate));
		}

		if (name == null) {
			fileDataImpl.setName(StringPool.BLANK);
		}
		else {
			fileDataImpl.setName(name);
		}

		fileDataImpl.setSize(size);

		if (fingerprint == null) {
			fileDataImpl.setFingerprint(StringPool.BLANK);
		}
		else {
			fileDataImpl.setFingerprint(fingerprint);
		}

		fileDataImpl.resetOriginalValues();

		return fileDataImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileDataId = objectInput.readLong();

		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		name = objectInput.readUTF();

		size = objectInput.readLong();
		fingerprint = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(fileDataId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(size);

		if (fingerprint == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fingerprint);
		}
	}

	public long fileDataId;
	public long companyId;
	public long createDate;
	public String name;
	public long size;
	public String fingerprint;
}