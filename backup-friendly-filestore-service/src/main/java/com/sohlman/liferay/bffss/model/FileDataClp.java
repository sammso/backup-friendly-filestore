package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sohlman.liferay.bffss.service.ClpSerializer;
import com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class FileDataClp extends BaseModelImpl<FileData> implements FileData {
    private long _fileDataId;
    private long _companyId;
    private Date _createDate;
    private String _name;
    private long _size;
    private String _fingerprint;
    private BaseModel<?> _fileDataRemoteModel;
    private Class<?> _clpSerializerClass = com.sohlman.liferay.bffss.service.ClpSerializer.class;

    public FileDataClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return FileData.class;
    }

    @Override
    public String getModelClassName() {
        return FileData.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _fileDataId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFileDataId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fileDataId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("fileDataId", getFileDataId());
        attributes.put("companyId", getCompanyId());
        attributes.put("createDate", getCreateDate());
        attributes.put("name", getName());
        attributes.put("size", getSize());
        attributes.put("fingerprint", getFingerprint());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long fileDataId = (Long) attributes.get("fileDataId");

        if (fileDataId != null) {
            setFileDataId(fileDataId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        Long size = (Long) attributes.get("size");

        if (size != null) {
            setSize(size);
        }

        String fingerprint = (String) attributes.get("fingerprint");

        if (fingerprint != null) {
            setFingerprint(fingerprint);
        }
    }

    @Override
    public long getFileDataId() {
        return _fileDataId;
    }

    @Override
    public void setFileDataId(long fileDataId) {
        _fileDataId = fileDataId;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setFileDataId", long.class);

                method.invoke(_fileDataRemoteModel, fileDataId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_fileDataRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_fileDataRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public void setName(String name) {
        _name = name;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setName", String.class);

                method.invoke(_fileDataRemoteModel, name);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getSize() {
        return _size;
    }

    @Override
    public void setSize(long size) {
        _size = size;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setSize", long.class);

                method.invoke(_fileDataRemoteModel, size);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getFingerprint() {
        return _fingerprint;
    }

    @Override
    public void setFingerprint(String fingerprint) {
        _fingerprint = fingerprint;

        if (_fileDataRemoteModel != null) {
            try {
                Class<?> clazz = _fileDataRemoteModel.getClass();

                Method method = clazz.getMethod("setFingerprint", String.class);

                method.invoke(_fileDataRemoteModel, fingerprint);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFileDataRemoteModel() {
        return _fileDataRemoteModel;
    }

    public void setFileDataRemoteModel(BaseModel<?> fileDataRemoteModel) {
        _fileDataRemoteModel = fileDataRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _fileDataRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_fileDataRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FileDataLocalServiceUtil.addFileData(this);
        } else {
            FileDataLocalServiceUtil.updateFileData(this);
        }
    }

    @Override
    public FileData toEscapedModel() {
        return (FileData) ProxyUtil.newProxyInstance(FileData.class.getClassLoader(),
            new Class[] { FileData.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FileDataClp clone = new FileDataClp();

        clone.setFileDataId(getFileDataId());
        clone.setCompanyId(getCompanyId());
        clone.setCreateDate(getCreateDate());
        clone.setName(getName());
        clone.setSize(getSize());
        clone.setFingerprint(getFingerprint());

        return clone;
    }

    @Override
    public int compareTo(FileData fileData) {
        long primaryKey = fileData.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FileDataClp)) {
            return false;
        }

        FileDataClp fileData = (FileDataClp) obj;

        long primaryKey = fileData.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{fileDataId=");
        sb.append(getFileDataId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", size=");
        sb.append(getSize());
        sb.append(", fingerprint=");
        sb.append(getFingerprint());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.sohlman.liferay.bffss.model.FileData");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileDataId</column-name><column-value><![CDATA[");
        sb.append(getFileDataId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>size</column-name><column-value><![CDATA[");
        sb.append(getSize());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fingerprint</column-name><column-value><![CDATA[");
        sb.append(getFingerprint());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
