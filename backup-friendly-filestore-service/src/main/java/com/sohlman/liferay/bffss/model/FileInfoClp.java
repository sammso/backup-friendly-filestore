package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sohlman.liferay.bffss.service.ClpSerializer;
import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class FileInfoClp extends BaseModelImpl<FileInfo> implements FileInfo {
    private long _fileInfoId;
    private long _companyId;
    private long _repositoryId;
    private String _path;
    private String _version;
    private long _fileDataId;
    private BaseModel<?> _fileInfoRemoteModel;
    private Class<?> _clpSerializerClass = com.sohlman.liferay.bffss.service.ClpSerializer.class;

    public FileInfoClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return FileInfo.class;
    }

    @Override
    public String getModelClassName() {
        return FileInfo.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _fileInfoId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setFileInfoId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _fileInfoId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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
        Long fileInfoId = (Long) attributes.get("fileInfoId");

        if (fileInfoId != null) {
            setFileInfoId(fileInfoId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long repositoryId = (Long) attributes.get("repositoryId");

        if (repositoryId != null) {
            setRepositoryId(repositoryId);
        }

        String path = (String) attributes.get("path");

        if (path != null) {
            setPath(path);
        }

        String version = (String) attributes.get("version");

        if (version != null) {
            setVersion(version);
        }

        Long fileDataId = (Long) attributes.get("fileDataId");

        if (fileDataId != null) {
            setFileDataId(fileDataId);
        }
    }

    @Override
    public long getFileInfoId() {
        return _fileInfoId;
    }

    @Override
    public void setFileInfoId(long fileInfoId) {
        _fileInfoId = fileInfoId;

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setFileInfoId", long.class);

                method.invoke(_fileInfoRemoteModel, fileInfoId);
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

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_fileInfoRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getRepositoryId() {
        return _repositoryId;
    }

    @Override
    public void setRepositoryId(long repositoryId) {
        _repositoryId = repositoryId;

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setRepositoryId", long.class);

                method.invoke(_fileInfoRemoteModel, repositoryId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPath() {
        return _path;
    }

    @Override
    public void setPath(String path) {
        _path = path;

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setPath", String.class);

                method.invoke(_fileInfoRemoteModel, path);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getVersion() {
        return _version;
    }

    @Override
    public void setVersion(String version) {
        _version = version;

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setVersion", String.class);

                method.invoke(_fileInfoRemoteModel, version);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getFileDataId() {
        return _fileDataId;
    }

    @Override
    public void setFileDataId(long fileDataId) {
        _fileDataId = fileDataId;

        if (_fileInfoRemoteModel != null) {
            try {
                Class<?> clazz = _fileInfoRemoteModel.getClass();

                Method method = clazz.getMethod("setFileDataId", long.class);

                method.invoke(_fileInfoRemoteModel, fileDataId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getFileInfoRemoteModel() {
        return _fileInfoRemoteModel;
    }

    public void setFileInfoRemoteModel(BaseModel<?> fileInfoRemoteModel) {
        _fileInfoRemoteModel = fileInfoRemoteModel;
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

        Class<?> remoteModelClass = _fileInfoRemoteModel.getClass();

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

        Object returnValue = method.invoke(_fileInfoRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            FileInfoLocalServiceUtil.addFileInfo(this);
        } else {
            FileInfoLocalServiceUtil.updateFileInfo(this);
        }
    }

    @Override
    public FileInfo toEscapedModel() {
        return (FileInfo) ProxyUtil.newProxyInstance(FileInfo.class.getClassLoader(),
            new Class[] { FileInfo.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        FileInfoClp clone = new FileInfoClp();

        clone.setFileInfoId(getFileInfoId());
        clone.setCompanyId(getCompanyId());
        clone.setRepositoryId(getRepositoryId());
        clone.setPath(getPath());
        clone.setVersion(getVersion());
        clone.setFileDataId(getFileDataId());

        return clone;
    }

    @Override
    public int compareTo(FileInfo fileInfo) {
        int value = 0;

        value = getVersion().compareTo(fileInfo.getVersion());

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof FileInfoClp)) {
            return false;
        }

        FileInfoClp fileInfo = (FileInfoClp) obj;

        long primaryKey = fileInfo.getPrimaryKey();

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

        sb.append("{fileInfoId=");
        sb.append(getFileInfoId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", repositoryId=");
        sb.append(getRepositoryId());
        sb.append(", path=");
        sb.append(getPath());
        sb.append(", version=");
        sb.append(getVersion());
        sb.append(", fileDataId=");
        sb.append(getFileDataId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.sohlman.liferay.bffss.model.FileInfo");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>fileInfoId</column-name><column-value><![CDATA[");
        sb.append(getFileInfoId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>repositoryId</column-name><column-value><![CDATA[");
        sb.append(getRepositoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>path</column-name><column-value><![CDATA[");
        sb.append(getPath());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>version</column-name><column-value><![CDATA[");
        sb.append(getVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileDataId</column-name><column-value><![CDATA[");
        sb.append(getFileDataId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
