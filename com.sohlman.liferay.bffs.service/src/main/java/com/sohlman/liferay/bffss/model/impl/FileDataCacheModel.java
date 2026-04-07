/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bffss.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

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
 * @generated
 */
public class FileDataCacheModel
	implements CacheModel<FileData>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileDataCacheModel)) {
			return false;
		}

		FileDataCacheModel fileDataCacheModel = (FileDataCacheModel)object;

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
			fileDataImpl.setName("");
		}
		else {
			fileDataImpl.setName(name);
		}

		fileDataImpl.setSize(size);

		if (fingerprint == null) {
			fileDataImpl.setFingerprint("");
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
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fileDataId);

		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeLong(size);

		if (fingerprint == null) {
			objectOutput.writeUTF("");
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