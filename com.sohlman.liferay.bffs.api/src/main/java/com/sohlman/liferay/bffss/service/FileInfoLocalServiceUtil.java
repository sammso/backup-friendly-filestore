package com.sohlman.liferay.bffss.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for FileInfo. This utility wraps
 * {@link com.sohlman.liferay.bffss.service.impl.FileInfoLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoLocalService
 * @see com.sohlman.liferay.bffss.service.base.FileInfoLocalServiceBaseImpl
 * @see com.sohlman.liferay.bffss.service.impl.FileInfoLocalServiceImpl
 * @generated
 */
public class FileInfoLocalServiceUtil {
    private static FileInfoLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.sohlman.liferay.bffss.service.impl.FileInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the file info to the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addFileInfo(fileInfo);
    }

    /**
    * Creates a new file info with the primary key. Does not add the file info to the database.
    *
    * @param fileInfoId the primary key for the new file info
    * @return the new file info
    */
    public static com.sohlman.liferay.bffss.model.FileInfo createFileInfo(
        long fileInfoId) {
        return getService().createFileInfo(fileInfoId);
    }

    /**
    * Deletes the file info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info that was removed
    * @throws PortalException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFileInfo(fileInfoId);
    }

    /**
    * Deletes the file info from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteFileInfo(fileInfo);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @param projection the projection to apply to the query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
        com.liferay.portal.kernel.dao.orm.Projection projection)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery, projection);
    }

    public static com.sohlman.liferay.bffss.model.FileInfo fetchFileInfo(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchFileInfo(fileInfoId);
    }

    /**
    * Returns the file info with the primary key.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info
    * @throws PortalException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileInfo(fileInfoId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
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
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileInfos(start, end);
    }

    /**
    * Returns the number of file infos.
    *
    * @return the number of file infos
    * @throws SystemException if a system exception occurred
    */
    public static int getFileInfosCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileInfosCount();
    }

    /**
    * Updates the file info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param fileInfo the file info
    * @return the file info that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo updateFileInfo(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateFileInfo(fileInfo);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version, java.io.InputStream inputStream)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .addFileInfo(companyId, repositoryId, path, version,
            inputStream);
    }

    public static void deleteFileInfo(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteFileInfo(companyId, repositoryId, path, version);
    }

    public static void deleteFileInfos(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteFileInfos(companyId, repositoryId, path);
    }

    public static void deleteFileInfosByDirectory(long companyId,
        long repositoryId, java.lang.String dirName)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        getService().deleteFileInfosByDirectory(companyId, repositoryId, dirName);
    }

    public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getService().getFileInfo(companyId, repositoryId, path);
    }

    public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getService().getFileInfo(companyId, repositoryId, path, version);
    }

    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileInfos(companyId, repositoryId);
    }

    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileInfos(companyId, repositoryId, path);
    }

    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfosByDirectory(
        long companyId, long repositoryId, java.lang.String dirName)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getFileInfosByDirectory(companyId, repositoryId, dirName);
    }

    public static java.io.InputStream getFileAsStream(long companyId,
        long repositoryId, java.lang.String fileName)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getFileAsStream(companyId, repositoryId, fileName);
    }

    public static java.io.InputStream getFileAsStream(long companyId,
        long repositoryId, java.lang.String fileName, java.lang.String version)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .getFileAsStream(companyId, repositoryId, fileName, version);
    }

    public static boolean hasFileInfo(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().hasFileInfo(companyId, repositoryId, path, version);
    }

    public static void updateFileInfo(long companyId, long oldRepositoryId,
        long newRepositoryId, java.lang.String oldPath, java.lang.String newPath)
        throws com.liferay.portal.kernel.exception.SystemException {
        getService()
            .updateFileInfo(companyId, oldRepositoryId, newRepositoryId,
            oldPath, newPath);
    }

    public static void clearService() {
        _service = null;
    }

    public static FileInfoLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    FileInfoLocalService.class.getName());

            if (invokableLocalService instanceof FileInfoLocalService) {
                _service = (FileInfoLocalService) invokableLocalService;
            } else {
                _service = new FileInfoLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(FileInfoLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setService(FileInfoLocalService service) {
    }
}
