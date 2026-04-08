/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.sohlman.liferay.bfdms.model.FileInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FileInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class FileInfoCacheModel
	implements CacheModel<FileInfo>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FileInfoCacheModel)) {
			return false;
		}

		FileInfoCacheModel fileInfoCacheModel = (FileInfoCacheModel)object;

		if (fileInfoId == fileInfoCacheModel.fileInfoId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, fileInfoId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{fileInfoId=");
		sb.append(fileInfoId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", repositoryId=");
		sb.append(repositoryId);
		sb.append(", path=");
		sb.append(path);
		sb.append(", version=");
		sb.append(version);
		sb.append(", fileDataId=");
		sb.append(fileDataId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FileInfo toEntityModel() {
		FileInfoImpl fileInfoImpl = new FileInfoImpl();

		fileInfoImpl.setFileInfoId(fileInfoId);
		fileInfoImpl.setCompanyId(companyId);
		fileInfoImpl.setRepositoryId(repositoryId);

		if (path == null) {
			fileInfoImpl.setPath("");
		}
		else {
			fileInfoImpl.setPath(path);
		}

		if (version == null) {
			fileInfoImpl.setVersion("");
		}
		else {
			fileInfoImpl.setVersion(version);
		}

		fileInfoImpl.setFileDataId(fileDataId);

		fileInfoImpl.resetOriginalValues();

		return fileInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		fileInfoId = objectInput.readLong();

		companyId = objectInput.readLong();

		repositoryId = objectInput.readLong();
		path = objectInput.readUTF();
		version = objectInput.readUTF();

		fileDataId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(fileInfoId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(repositoryId);

		if (path == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(path);
		}

		if (version == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(fileDataId);
	}

	public long fileInfoId;
	public long companyId;
	public long repositoryId;
	public String path;
	public String version;
	public long fileDataId;

}