package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sohlman.liferay.bffss.model.FileInfo;

/**
 * The persistence interface for the file info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoPersistenceImpl
 * @see FileInfoUtil
 * @generated
 */
public interface FileInfoPersistence extends BasePersistence<FileInfo> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link FileInfoUtil} to access the file info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R(
        long companyId, long repositoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_First(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_First(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_Last(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_Last(
        long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_R(long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public int countByC_R(long companyId, long repositoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_P(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_P_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_R_P(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public int countByC_R_P(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByC_R_LikeP(
        long companyId, long repositoryId, java.lang.String path, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_LikeP_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_LikeP_First(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_LikeP_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_LikeP_Last(
        long companyId, long repositoryId, java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo[] findByC_R_LikeP_PrevAndNext(
        long fileInfoId, long companyId, long repositoryId,
        java.lang.String path,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63; from the database.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_R_LikeP(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
    *
    * @param companyId the company ID
    * @param repositoryId the repository ID
    * @param path the path
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public int countByC_R_LikeP(long companyId, long repositoryId,
        java.lang.String path)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo findByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo fetchByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo removeByC_R_P_V(
        long companyId, long repositoryId, java.lang.String path,
        java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

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
    public int countByC_R_P_V(long companyId, long repositoryId,
        java.lang.String path, java.lang.String version)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the file infos where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @return the matching file infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findByFileData(
        long fileDataId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo findByFileData_First(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Returns the first file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo fetchByFileData_First(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo findByFileData_Last(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Returns the last file info in the ordered set where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching file info, or <code>null</code> if a matching file info could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo fetchByFileData_Last(
        long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sohlman.liferay.bffss.model.FileInfo[] findByFileData_PrevAndNext(
        long fileInfoId, long fileDataId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Removes all the file infos where fileDataId = &#63; from the database.
    *
    * @param fileDataId the file data ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByFileData(long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of file infos where fileDataId = &#63;.
    *
    * @param fileDataId the file data ID
    * @return the number of matching file infos
    * @throws SystemException if a system exception occurred
    */
    public int countByFileData(long fileDataId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the file info in the entity cache if it is enabled.
    *
    * @param fileInfo the file info
    */
    public void cacheResult(com.sohlman.liferay.bffss.model.FileInfo fileInfo);

    /**
    * Caches the file infos in the entity cache if it is enabled.
    *
    * @param fileInfos the file infos
    */
    public void cacheResult(
        java.util.List<com.sohlman.liferay.bffss.model.FileInfo> fileInfos);

    /**
    * Creates a new file info with the primary key. Does not add the file info to the database.
    *
    * @param fileInfoId the primary key for the new file info
    * @return the new file info
    */
    public com.sohlman.liferay.bffss.model.FileInfo create(long fileInfoId);

    /**
    * Removes the file info with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info that was removed
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo remove(long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    public com.sohlman.liferay.bffss.model.FileInfo updateImpl(
        com.sohlman.liferay.bffss.model.FileInfo fileInfo)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the file info with the primary key or throws a {@link com.sohlman.liferay.bffss.NoSuchFileInfoException} if it could not be found.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info
    * @throws com.sohlman.liferay.bffss.NoSuchFileInfoException if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo findByPrimaryKey(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sohlman.liferay.bffss.NoSuchFileInfoException;

    /**
    * Returns the file info with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param fileInfoId the primary key of the file info
    * @return the file info, or <code>null</code> if a file info with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sohlman.liferay.bffss.model.FileInfo fetchByPrimaryKey(
        long fileInfoId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the file infos.
    *
    * @return the file infos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the file infos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of file infos.
    *
    * @return the number of file infos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
