package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class FileDataActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public FileDataActionableDynamicQuery() throws SystemException {
        setBaseLocalService(FileDataLocalServiceUtil.getService());
        setClass(FileData.class);

        setClassLoader(com.sohlman.liferay.bffss.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("fileDataId");
    }
}
