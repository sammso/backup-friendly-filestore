package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sohlman.liferay.bffss.model.FileData;

import java.util.List;

/**
 * The persistence utility for the file data service. This utility wraps {@link FileDataPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileDataPersistence
 * @see FileDataPersistenceImpl
 * @generated
 */
public class FileDataUtil {
    private static FileDataPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(FileData fileData) {
        getPersistence().clearCache(fileData);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<FileData> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<FileData> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<FileData> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static FileData update(FileData fileData) throws SystemException {
        return getPersistence().update(fileData);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static FileData update(FileData fileData,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(fileData, serviceContext);
    }

    /**
    * Returns all the file datas where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @return the matching file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findByFingerPrint(
        java.lang.String fingerprint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFingerPrint(fingerprint);
    }

    /**
    * Returns a range of all the file datas where fingerprint = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fingerprint the fingerprint
    * @param start the lower bound of the range of file datas
    * @param end the upper bound of the range of file datas (not inclusive)
    * @return the range of matching file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findByFingerPrint(
        java.lang.String fingerprint, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFingerPrint(fingerprint, start, end);
    }

    /**
    * Returns an ordered range of all the file datas where fingerprint = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fingerprint the fingerprint
    * @param start the lower bound of the range of file datas
    * @param end the upper bound of the range of file datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findByFingerPrint(
        java.lang.String fingerprint, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFingerPrint(fingerprint, start, end, orderByComparator);
    }

    /**
    * Returns the first file data in the ordered set where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file data
    * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a matching file data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData findByFingerPrint_First(
        java.lang.String fingerprint,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileDataException {
        return getPersistence()
                   .findByFingerPrint_First(fingerprint, orderByComparator);
    }

    /**
    * Returns the first file data in the ordered set where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file data, or <code>null</code> if a matching file data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData fetchByFingerPrint_First(
        java.lang.String fingerprint,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFingerPrint_First(fingerprint, orderByComparator);
    }

    /**
    * Returns the last file data in the ordered set where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file data
    * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a matching file data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData findByFingerPrint_Last(
        java.lang.String fingerprint,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileDataException {
        return getPersistence()
                   .findByFingerPrint_Last(fingerprint, orderByComparator);
    }

    /**
    * Returns the last file data in the ordered set where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file data, or <code>null</code> if a matching file data could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData fetchByFingerPrint_Last(
        java.lang.String fingerprint,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFingerPrint_Last(fingerprint, orderByComparator);
    }

    /**
    * Returns the file datas before and after the current file data in the ordered set where fingerprint = &#63;.
    *
    * @param fileDataId the primary key of the current file data
    * @param fingerprint the fingerprint
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next file data
    * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData[] findByFingerPrint_PrevAndNext(
        long fileDataId, java.lang.String fingerprint,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileDataException {
        return getPersistence()
                   .findByFingerPrint_PrevAndNext(fileDataId, fingerprint,
            orderByComparator);
    }

    /**
    * Removes all the file datas where fingerprint = &#63; from the database.
    *
    * @param fingerprint the fingerprint
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFingerPrint(java.lang.String fingerprint)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFingerPrint(fingerprint);
    }

    /**
    * Returns the number of file datas where fingerprint = &#63;.
    *
    * @param fingerprint the fingerprint
    * @return the number of matching file datas
    * @throws SystemException if a system exception occurred
    */
    public static int countByFingerPrint(java.lang.String fingerprint)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFingerPrint(fingerprint);
    }

    /**
    * Caches the file data in the entity cache if it is enabled.
    *
    * @param fileData the file data
    */
    public static void cacheResult(
        com.sohlman.liferay.bffss.model.FileData fileData) {
        getPersistence().cacheResult(fileData);
    }

    /**
    * Caches the file datas in the entity cache if it is enabled.
    *
    * @param fileDatas the file datas
    */
    public static void cacheResult(
        java.util.List<com.sohlman.liferay.bffss.model.FileData> fileDatas) {
        getPersistence().cacheResult(fileDatas);
    }

    /**
    * Creates a new file data with the primary key. Does not add the file data to the database.
    *
    * @param fileDataId the primary key for the new file data
    * @return the new file data
    */
    public static com.sohlman.liferay.bffss.model.FileData create(
        long fileDataId) {
        return getPersistence().create(fileDataId);
    }

    /**
    * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fileDataId the primary key of the file data
    * @return the file data that was removed
    * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData remove(
        long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileDataException {
        return getPersistence().remove(fileDataId);
    }

    public static com.sohlman.liferay.bffss.model.FileData updateImpl(
        com.sohlman.liferay.bffss.model.FileData fileData)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(fileData);
    }

    /**
    * Returns the file data with the primary key or throws a {@link com.sohlman.liferay.bffss.NoSuchFileDataException} if it could not be found.
    *
    * @param fileDataId the primary key of the file data
    * @return the file data
    * @throws com.sohlman.liferay.bffss.NoSuchFileDataException if a file data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData findByPrimaryKey(
        long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileDataException {
        return getPersistence().findByPrimaryKey(fileDataId);
    }

    /**
    * Returns the file data with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fileDataId the primary key of the file data
    * @return the file data, or <code>null</code> if a file data with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileData fetchByPrimaryKey(
        long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fileDataId);
    }

    /**
    * Returns all the file datas.
    *
    * @return the file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the file datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of file datas
    * @param end the upper bound of the range of file datas (not inclusive)
    * @return the range of file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the file datas.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of file datas
    * @param end the upper bound of the range of file datas (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of file datas
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileData> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the file datas from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of file datas.
    *
    * @return the number of file datas
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FileDataPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FileDataPersistence) PortletBeanLocatorUtil.locate(com.sohlman.liferay.bffss.service.ClpSerializer.getServletContextName(),
                    FileDataPersistence.class.getName());

            ReferenceRegistry.registerReference(FileDataUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FileDataPersistence persistence) {
    }
}
