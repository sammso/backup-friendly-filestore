package com.sohlman.liferay.bffss.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the FileInfo service. Represents a row in the &quot;bffss_FileInfo&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sohlman.liferay.bffss.model.impl.FileInfoImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfo
 * @see com.sohlman.liferay.bffss.model.impl.FileInfoImpl
 * @see com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl
 * @generated
 */
public interface FileInfoModel extends BaseModel<FileInfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a file info model instance should use the {@link FileInfo} interface instead.
     */

    /**
     * Returns the primary key of this file info.
     *
     * @return the primary key of this file info
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this file info.
     *
     * @param primaryKey the primary key of this file info
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the file info ID of this file info.
     *
     * @return the file info ID of this file info
     */
    public long getFileInfoId();

    /**
     * Sets the file info ID of this file info.
     *
     * @param fileInfoId the file info ID of this file info
     */
    public void setFileInfoId(long fileInfoId);

    /**
     * Returns the company ID of this file info.
     *
     * @return the company ID of this file info
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this file info.
     *
     * @param companyId the company ID of this file info
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the repository ID of this file info.
     *
     * @return the repository ID of this file info
     */
    public long getRepositoryId();

    /**
     * Sets the repository ID of this file info.
     *
     * @param repositoryId the repository ID of this file info
     */
    public void setRepositoryId(long repositoryId);

    /**
     * Returns the path of this file info.
     *
     * @return the path of this file info
     */
    @AutoEscape
    public String getPath();

    /**
     * Sets the path of this file info.
     *
     * @param path the path of this file info
     */
    public void setPath(String path);

    /**
     * Returns the version of this file info.
     *
     * @return the version of this file info
     */
    @AutoEscape
    public String getVersion();

    /**
     * Sets the version of this file info.
     *
     * @param version the version of this file info
     */
    public void setVersion(String version);

    /**
     * Returns the file data ID of this file info.
     *
     * @return the file data ID of this file info
     */
    public long getFileDataId();

    /**
     * Sets the file data ID of this file info.
     *
     * @param fileDataId the file data ID of this file info
     */
    public void setFileDataId(long fileDataId);

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
    public int compareTo(FileInfo fileInfo);

    @Override
    public int hashCode();

    @Override
    public CacheModel<FileInfo> toCacheModel();

    @Override
    public FileInfo toEscapedModel();

    @Override
    public FileInfo toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
