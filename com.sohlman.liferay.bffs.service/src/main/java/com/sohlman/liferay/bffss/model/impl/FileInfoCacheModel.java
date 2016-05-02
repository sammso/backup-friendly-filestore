package com.sohlman.liferay.bffss.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sohlman.liferay.bffss.model.FileInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing FileInfo in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfo
 * @generated
 */
public class FileInfoCacheModel implements CacheModel<FileInfo>, Externalizable {
    public long fileInfoId;
    public long companyId;
    public long repositoryId;
    public String path;
    public String version;
    public long fileDataId;

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
            fileInfoImpl.setPath(StringPool.BLANK);
        } else {
            fileInfoImpl.setPath(path);
        }

        if (version == null) {
            fileInfoImpl.setVersion(StringPool.BLANK);
        } else {
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
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(fileInfoId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(repositoryId);

        if (path == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(path);
        }

        if (version == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(version);
        }

        objectOutput.writeLong(fileDataId);
    }
}
