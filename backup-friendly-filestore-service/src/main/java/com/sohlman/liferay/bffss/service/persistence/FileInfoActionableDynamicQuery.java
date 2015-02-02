package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FileInfoActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FileInfoActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FileInfoLocalServiceUtil.getService());
        setClass(FileInfo.class);

        setClassLoader(com.sohlman.liferay.bffss.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fileInfoId");
    }
}
