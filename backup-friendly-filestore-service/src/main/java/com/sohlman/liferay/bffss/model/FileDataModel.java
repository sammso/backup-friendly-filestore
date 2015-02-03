package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the FileData service. Represents a row in the &quot;bffss_FileData&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sohlman.liferay.bffss.model.impl.FileDataImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileData
 * @see com.sohlman.liferay.bffss.model.impl.FileDataImpl
 * @see com.sohlman.liferay.bffss.model.impl.FileDataModelImpl
 * @generated
 */
public interface FileDataModel extends BaseModel<FileData> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a file data model instance should use the {@link FileData} interface instead.
     */

    /**
     * Returns the primary key of this file data.
     *
     * @return the primary key of this file data
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this file data.
     *
     * @param primaryKey the primary key of this file data
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the file data ID of this file data.
     *
     * @return the file data ID of this file data
     */
    public long getFileDataId();

    /**
     * Sets the file data ID of this file data.
     *
     * @param fileDataId the file data ID of this file data
     */
    public void setFileDataId(long fileDataId);

    /**
     * Returns the company ID of this file data.
     *
     * @return the company ID of this file data
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this file data.
     *
     * @param companyId the company ID of this file data
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the create date of this file data.
     *
     * @return the create date of this file data
     */
    public Date getCreateDate();

    /**
     * Sets the create date of this file data.
     *
     * @param createDate the create date of this file data
     */
    public void setCreateDate(Date createDate);

    /**
     * Returns the name of this file data.
     *
     * @return the name of this file data
     */
    @AutoEscape
    public String getName();

    /**
     * Sets the name of this file data.
     *
     * @param name the name of this file data
     */
    public void setName(String name);

    /**
     * Returns the size of this file data.
     *
     * @return the size of this file data
     */
    public long getSize();

    /**
     * Sets the size of this file data.
     *
     * @param size the size of this file data
     */
    public void setSize(long size);

    /**
     * Returns the fingerprint of this file data.
     *
     * @return the fingerprint of this file data
     */
    @AutoEscape
    public String getFingerprint();

    /**
     * Sets the fingerprint of this file data.
     *
     * @param fingerprint the fingerprint of this file data
     */
    public void setFingerprint(String fingerprint);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(FileData fileData);

    @Override
    public int hashCode();

    @Override
    public CacheModel<FileData> toCacheModel();

    @Override
    public FileData toEscapedModel();

    @Override
    public FileData toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
