package com.sohlman.liferay.bffss.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FileInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoLocalService
 * @generated
 */
public class FileInfoLocalServiceWrapper implements FileInfoLocalService,
    ServiceWrapper<FileInfoLocalService> {
    private FileInfoLocalService _fileInfoLocalService;

    public FileInfoLocalServiceWrapper(
        FileInfoLocalService fileInfoLocalService) {
        _fileInfoLocalService = fileInfoLocalService;
    }

    /**
    * Adds the file info to the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was added
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.addFileInfo(fileInfo);
    }

    /**
    * Creates a new file info with the primary key. Does not add the file info to the database.
    *
    * @param fileInfoId the primary key for the new file info
    * @return the new file info
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo createFileInfo(
        long fileInfoId) {
        return _fileInfoLocalService.createFileInfo(fileInfoId);
    }

    /**
    * Deletes the file info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info that was removed
    * @throws PortalException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.deleteFileInfo(fileInfoId);
    }

    /**
    * Deletes the file info from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was removed
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.deleteFileInfo(fileInfo);
    }

    @Override
    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _fileInfoLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @Override
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    @Override
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.dynamicQueryCount(dynamicQuery, projection);
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo fetchFileInfo(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.fetchFileInfo(fileInfoId);
    }

    /**
    * Returns the file info with the primary key.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info
    * @throws PortalException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(long fileInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfo(fileInfoId);
    }

    @Override
    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the file infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @return the range of file infos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfos(start, end);
    }

    /**
    * Returns the number of file infos.
    *
    * @return the number of file infos
    * @throws SystemException if a system exception occurred
    */
    @Override
    public int getFileInfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfosCount();
    }

    /**
    * Updates the file info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was updated
    * @throws SystemException if a system exception occurred
    */
    @Override
    public com.sohlman.liferay.bffss.model.FileInfo updateFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.updateFileInfo(fileInfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    @Override
    public java.lang.String getBeanIdentifier() {
        return _fileInfoLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    @Override
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _fileInfoLocalService.setBeanIdentifier(beanIdentifier);
    }

    @Override
    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _fileInfoLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version, byte[] bytes)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.addFileInfo(companyId, repositoryId, path,
            version, bytes);
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version, java.io.InputStream inputStream, long size)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.addFileInfo(companyId, repositoryId, path,
            version, inputStream, size);
    }

    @Override
    public void deleteFileInfo(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _fileInfoLocalService.deleteFileInfo(companyId, repositoryId, path,
            version);
    }

    @Override
    public void deleteFileInfos(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _fileInfoLocalService.deleteFileInfos(companyId, repositoryId, path);
    }

    @Override
    public void deleteFileInfosByDirectory(long companyId, long repositoryId,
        java.lang.String dirName)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        _fileInfoLocalService.deleteFileInfosByDirectory(companyId,
            repositoryId, dirName);
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return _fileInfoLocalService.getFileInfo(companyId, repositoryId, path);
    }

    @Override
    public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return _fileInfoLocalService.getFileInfo(companyId, repositoryId, path,
            version);
    }

    @Override
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfos(companyId, repositoryId);
    }

    @Override
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfos(companyId, repositoryId, path);
    }

    @Override
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfosByDirectory(
        long companyId, long repositoryId, java.lang.String dirName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileInfosByDirectory(companyId,
            repositoryId, dirName);
    }

    @Override
    public java.io.InputStream getFileAsStream(long companyId,
        long repositoryId, java.lang.String fileName)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileAsStream(companyId, repositoryId,
            fileName);
    }

    @Override
    public java.io.InputStream getFileAsStream(long companyId,
        long repositoryId, java.lang.String fileName, java.lang.String version)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.getFileAsStream(companyId, repositoryId,
            fileName, version);
    }

    @Override
    public boolean hasFileInfo(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _fileInfoLocalService.hasFileInfo(companyId, repositoryId, path,
            version);
    }

    @Override
    public void updateFileInfo(long companyId, long oldRepositoryId,
        long newRepositoryId, java.lang.String oldPath, java.lang.String newPath)
        throws com.liferay.portal.kernel.exception.SystemException {
        _fileInfoLocalService.updateFileInfo(companyId, oldRepositoryId,
            newRepositoryId, oldPath, newPath);
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
     */
    public FileInfoLocalService getWrappedFileInfoLocalService() {
        return _fileInfoLocalService;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
     */
    public void setWrappedFileInfoLocalService(
        FileInfoLocalService fileInfoLocalService) {
        _fileInfoLocalService = fileInfoLocalService;
    }

    @Override
    public FileInfoLocalService getWrappedService() {
        return _fileInfoLocalService;
    }

    @Override
    public void setWrappedService(FileInfoLocalService fileInfoLocalService) {
        _fileInfoLocalService = fileInfoLocalService;
    }
}
