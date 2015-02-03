package com.sohlman.liferay.bffss.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.model.FileDataModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the FileData service. Represents a row in the &quot;bffss_FileData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sohlman.liferay.bffss.model.FileDataModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link FileDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileDataImpl
 * @see com.sohlman.liferay.bffss.model.FileData
 * @see com.sohlman.liferay.bffss.model.FileDataModel
 * @generated
 */
public class FileDataModelImpl extends BaseModelImpl<FileData>
    implements FileDataModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a file data model instance should use the {@link com.sohlman.liferay.bffss.model.FileData} interface instead.
     */
    public static final String TABLE_NAME = "bffss_FileData";
    public static final Object[][] TABLE_COLUMNS = {
            { "fileDataId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "name", Types.VARCHAR },
            { "size_", Types.BIGINT },
            { "fingerprint", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table bffss_FileData (fileDataId LONG not null primary key,companyId LONG,createDate DATE null,name VARCHAR(75) null,size_ LONG,fingerprint VARCHAR(75) null)";
    public static final String TABLE_SQL_DROP = "drop table bffss_FileData";
    public static final String ORDER_BY_JPQL = " ORDER BY fileData.fileDataId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY bffss_FileData.fileDataId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sohlman.liferay.bffss.model.FileData"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sohlman.liferay.bffss.model.FileData"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.sohlman.liferay.bffss.model.FileData"),
            true);
    public static long FINGERPRINT_COLUMN_BITMASK = 1L;
    public static long FILEDATAID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sohlman.liferay.bffss.model.FileData"));
    private static ClassLoader _classLoader = FileData.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            FileData.class
        };
    private long _fileDataId;
    private long _companyId;
    private Date _createDate;
    private String _name;
    private long _size;
    private String _fingerprint;
    private String _originalFingerprint;
    private long _columnBitmask;
    private FileData _escapedModel;

    public FileDataModelImpl() {
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
    public Class<?> getModelClass() {
        return FileData.class;
    }

    @Override
    public String getModelClassName() {
        return FileData.class.getName();
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
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
    }

    @Override
    public long getSize() {
        return _size;
    }

    @Override
    public void setSize(long size) {
        _size = size;
    }

    @Override
    public String getFingerprint() {
        if (_fingerprint == null) {
            return StringPool.BLANK;
        } else {
            return _fingerprint;
        }
    }

    @Override
    public void setFingerprint(String fingerprint) {
        _columnBitmask |= FINGERPRINT_COLUMN_BITMASK;

        if (_originalFingerprint == null) {
            _originalFingerprint = _fingerprint;
        }

        _fingerprint = fingerprint;
    }

    public String getOriginalFingerprint() {
        return GetterUtil.getString(_originalFingerprint);
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            FileData.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public FileData toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (FileData) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        FileDataImpl fileDataImpl = new FileDataImpl();

        fileDataImpl.setFileDataId(getFileDataId());
        fileDataImpl.setCompanyId(getCompanyId());
        fileDataImpl.setCreateDate(getCreateDate());
        fileDataImpl.setName(getName());
        fileDataImpl.setSize(getSize());
        fileDataImpl.setFingerprint(getFingerprint());

        fileDataImpl.resetOriginalValues();

        return fileDataImpl;
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

        if (!(obj instanceof FileData)) {
            return false;
        }

        FileData fileData = (FileData) obj;

        long primaryKey = fileData.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        FileDataModelImpl fileDataModelImpl = this;

        fileDataModelImpl._originalFingerprint = fileDataModelImpl._fingerprint;

        fileDataModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<FileData> toCacheModel() {
        FileDataCacheModel fileDataCacheModel = new FileDataCacheModel();

        fileDataCacheModel.fileDataId = getFileDataId();

        fileDataCacheModel.companyId = getCompanyId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            fileDataCacheModel.createDate = createDate.getTime();
        } else {
            fileDataCacheModel.createDate = Long.MIN_VALUE;
        }

        fileDataCacheModel.name = getName();

        String name = fileDataCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            fileDataCacheModel.name = null;
        }

        fileDataCacheModel.size = getSize();

        fileDataCacheModel.fingerprint = getFingerprint();

        String fingerprint = fileDataCacheModel.fingerprint;

        if ((fingerprint != null) && (fingerprint.length() == 0)) {
            fileDataCacheModel.fingerprint = null;
        }

        return fileDataCacheModel;
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
