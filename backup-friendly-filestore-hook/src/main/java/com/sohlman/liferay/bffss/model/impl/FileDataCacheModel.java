package com.sohlman.liferay.bffss.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

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
public class FileDataCacheModel implements CacheModel<FileData>, Externalizable {
    public long fileDataId;
    public long companyId;
    public long createDate;
    public String name;
    public long size;
    public long deletedTimestamp;
    public String fingerprint;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

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
        sb.append(", deletedTimestamp=");
        sb.append(deletedTimestamp);
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
        } else {
            fileDataImpl.setCreateDate(new Date(createDate));
        }

        if (name == null) {
            fileDataImpl.setName(StringPool.BLANK);
        } else {
            fileDataImpl.setName(name);
        }

        fileDataImpl.setSize(size);
        fileDataImpl.setDeletedTimestamp(deletedTimestamp);

        if (fingerprint == null) {
            fileDataImpl.setFingerprint(StringPool.BLANK);
        } else {
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
        deletedTimestamp = objectInput.readLong();
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
        } else {
            objectOutput.writeUTF(name);
        }

        objectOutput.writeLong(size);
        objectOutput.writeLong(deletedTimestamp);

        if (fingerprint == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(fingerprint);
        }
    }
}
