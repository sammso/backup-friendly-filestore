package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sohlman.liferay.bffss.model.FileInfo;

import java.util.List;

/**
 * The persistence utility for the file info service. This utility wraps {@link FileInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoPersistence
 * @see FileInfoPersistenceImpl
 * @generated
 */
public class FileInfoUtil {
    private static FileInfoPersistence _persistence;

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
    public static void clearCache(FileInfo fileInfo) {
        getPersistence().clearCache(fileInfo);
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
    public static List<FileInfo> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<FileInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<FileInfo> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static FileInfo update(FileInfo fileInfo) throws SystemException {
        return getPersistence().update(fileInfo);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static FileInfo update(FileInfo fileInfo,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(fileInfo, serviceContext);
    }

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_R(companyId, repositoryId);
    }

    /**
    * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @return the range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_R(companyId, repositoryId, start, end);
    }

    /**
    * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_R(companyId, repositoryId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_First(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_First(companyId, repositoryId, orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_First(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_First(companyId, repositoryId, orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_Last(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_Last(companyId, repositoryId, orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_Last(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_Last(companyId, repositoryId, orderByComparator);
    }

    /**
    * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param fileInfoId the primary key of the current file info
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_PrevAndNext(fileInfoId, companyId, repositoryId,
            orderByComparator);
    }

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_R(long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_R(companyId, repositoryId);
    }

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_R(long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_R(companyId, repositoryId);
    }

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_R_P(companyId, repositoryId, path);
    }

    /**
    * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @return the range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_R_P(companyId, repositoryId, path, start, end);
    }

    /**
    * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_R_P(companyId, repositoryId, path, start, end,
            orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_P_First(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_P_First(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_P_Last(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_P_Last(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param fileInfoId the primary key of the current file info
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_P_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_P_PrevAndNext(fileInfoId, companyId,
            repositoryId, path, orderByComparator);
    }

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_R_P(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_R_P(companyId, repositoryId, path);
    }

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_R_P(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_R_P(companyId, repositoryId, path);
    }

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_R_LikeP(companyId, repositoryId, path);
    }

    /**
    * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @return the range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_R_LikeP(companyId, repositoryId, path, start, end);
    }

    /**
    * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_R_LikeP(companyId, repositoryId, path, start, end,
            orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_LikeP_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_LikeP_First(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_LikeP_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_LikeP_First(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_LikeP_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_LikeP_Last(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_LikeP_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_LikeP_Last(companyId, repositoryId, path,
            orderByComparator);
    }

    /**
    * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param fileInfoId the primary key of the current file info
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_LikeP_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_LikeP_PrevAndNext(fileInfoId, companyId,
            repositoryId, path, orderByComparator);
    }

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_R_LikeP(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_R_LikeP(companyId, repositoryId, path);
    }

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_R_LikeP(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_R_LikeP(companyId, repositoryId, path);
    }

    /**
    * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or throws a {@link com.sohlman.liferay.bffss.NoSuchFileInfoException} if it could not be found.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param version the version
    * @return the matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByC_R_P_V(companyId, repositoryId, path, version);
    }

    /**
    * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param version the version
    * @return the matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_P_V(companyId, repositoryId, path, version);
    }

    /**
    * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param version the version
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_R_P_V(companyId, repositoryId, path, version,
            retrieveFromCache);
    }

    /**
    * Removes the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param version the version
    * @return the file info that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo removeByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .removeByC_R_P_V(companyId, repositoryId, path, version);
    }

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @param version the version
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_R_P_V(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByC_R_P_V(companyId, repositoryId, path, version);
    }

    /**
    * Returns all the file infos where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFileData(fileDataId);
    }

    /**
    * Returns a range of all the file infos where fileDataId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fileDataId the file data ID
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @return the range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByFileData(fileDataId, start, end);
    }

    /**
    * Returns an ordered range of all the file infos where fileDataId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param fileDataId the file data ID
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByFileData(fileDataId, start, end, orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByFileData_First(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByFileData_First(fileDataId, orderByComparator);
    }

    /**
    * Returns the first file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByFileData_First(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFileData_First(fileDataId, orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByFileData_Last(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByFileData_Last(fileDataId, orderByComparator);
    }

    /**
    * Returns the last file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByFileData_Last(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByFileData_Last(fileDataId, orderByComparator);
    }

    /**
    * Returns the file infos before and after the current file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileInfoId the primary key of the current file info
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo[] findByFileData_PrevAndNext(
        long fileInfoId, long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence()
                   .findByFileData_PrevAndNext(fileInfoId, fileDataId,
            orderByComparator);
    }

    /**
    * Removes all the file infos where fileDataId = &#63; from the database.
    *
    * @param fileDataId the file data ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByFileData(long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByFileData(fileDataId);
    }

    /**
    * Returns the number of file infos where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countByFileData(long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByFileData(fileDataId);
    }

    /**
    * Caches the file info in the entity cache if it is enabled.
    *
    * @param fileInfo the file info
    */
    public static void cacheResult(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
        getPersistence().cacheResult(fileInfo);
    }

    /**
    * Caches the file infos in the entity cache if it is enabled.
    *
    * @param fileInfos the file infos
    */
    public static void cacheResult(
        java.util.List<com.sohlman.liferay.bffss.model.FileInfo> fileInfos) {
        getPersistence().cacheResult(fileInfos);
    }

    /**
    * Creates a new file info with the primary key. Does not add the file info to the database.
    *
    * @param fileInfoId the primary key for the new file info
    * @return the new file info
    */
    public static com.sohlman.liferay.bffss.model.FileInfo create(
        long fileInfoId) {
        return getPersistence().create(fileInfoId);
    }

    /**
    * Removes the file info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info that was removed
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo remove(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence().remove(fileInfoId);
    }

    public static com.sohlman.liferay.bffss.model.FileInfo updateImpl(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(fileInfo);
    }

    /**
    * Returns the file info with the primary key or throws a {@link com.sohlman.liferay.bffss.NoSuchFileInfoException} if it could not be found.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo findByPrimaryKey(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException {
        return getPersistence().findByPrimaryKey(fileInfoId);
    }

    /**
    * Returns the file info with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info, or <code>null</code> if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sohlman.liferay.bffss.model.FileInfo fetchByPrimaryKey(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(fileInfoId);
    }

    /**
    * Returns all the file infos.
    *
    * @return the file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the file infos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of file infos
    * @param end the upper bound of the range of file infos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of file infos
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the file infos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of file infos.
    *
    * @return the number of file infos
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static FileInfoPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (FileInfoPersistence) PortletBeanLocatorUtil.locate(com.sohlman.liferay.bffss.service.ClpSerializer.getServletContextName(),
                    FileInfoPersistence.class.getName());

            ReferenceRegistry.registerReference(FileInfoUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(FileInfoPersistence persistence) {
    }
}
