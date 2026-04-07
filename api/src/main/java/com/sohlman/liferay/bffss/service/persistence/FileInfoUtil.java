/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.liferay.bffss.model.FileInfo;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file info service. This utility wraps <code>com.sohlman.liferay.bffss.service.persistence.impl.FileInfoPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoPersistence
 * @generated
 */
public class FileInfoUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(FileInfo fileInfo) {
		getPersistence().clearCache(fileInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, FileInfo> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileInfo> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileInfo update(FileInfo fileInfo) {
		return getPersistence().update(fileInfo);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileInfo update(
		FileInfo fileInfo, ServiceContext serviceContext) {

		return getPersistence().update(fileInfo, serviceContext);
	}

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @return the matching file infos
	 */
	public static List<FileInfo> findByC_R(long companyId, long repositoryId) {
		return getPersistence().findByC_R(companyId, repositoryId);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	public static List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end) {

		return getPersistence().findByC_R(companyId, repositoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findByC_R(
			companyId, repositoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R(
		long companyId, long repositoryId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_R(
			companyId, repositoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_First(
			long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_First(
			companyId, repositoryId, orderByComparator);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_First(
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_First(
			companyId, repositoryId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_Last(
			long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_Last(
			companyId, repositoryId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_Last(
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_Last(
			companyId, repositoryId, orderByComparator);
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo[] findByC_R_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_PrevAndNext(
			fileInfoId, companyId, repositoryId, orderByComparator);
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 */
	public static void removeByC_R(long companyId, long repositoryId) {
		getPersistence().removeByC_R(companyId, repositoryId);
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @return the number of matching file infos
	 */
	public static int countByC_R(long companyId, long repositoryId) {
		return getPersistence().countByC_R(companyId, repositoryId);
	}

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	public static List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path) {

		return getPersistence().findByC_R_P(companyId, repositoryId, path);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	public static List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end) {

		return getPersistence().findByC_R_P(
			companyId, repositoryId, path, start, end);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findByC_R_P(
			companyId, repositoryId, path, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R_P(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_R_P(
			companyId, repositoryId, path, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_P_First(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_P_First(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_P_First(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_P_First(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_P_Last(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_P_Last(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_P_Last(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_P_Last(
			companyId, repositoryId, path, orderByComparator);
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
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo[] findByC_R_P_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_P_PrevAndNext(
			fileInfoId, companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 */
	public static void removeByC_R_P(
		long companyId, long repositoryId, String path) {

		getPersistence().removeByC_R_P(companyId, repositoryId, path);
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the number of matching file infos
	 */
	public static int countByC_R_P(
		long companyId, long repositoryId, String path) {

		return getPersistence().countByC_R_P(companyId, repositoryId, path);
	}

	/**
	 * Returns all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the matching file infos
	 */
	public static List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		return getPersistence().findByC_R_LikeP(companyId, repositoryId, path);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	public static List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end) {

		return getPersistence().findByC_R_LikeP(
			companyId, repositoryId, path, start, end);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findByC_R_LikeP(
			companyId, repositoryId, path, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC_R_LikeP(
		long companyId, long repositoryId, String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC_R_LikeP(
			companyId, repositoryId, path, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_LikeP_First(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_LikeP_First(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_LikeP_First(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_LikeP_First(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_LikeP_Last(
			long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_LikeP_Last(
			companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_LikeP_Last(
		long companyId, long repositoryId, String path,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_R_LikeP_Last(
			companyId, repositoryId, path, orderByComparator);
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
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo[] findByC_R_LikeP_PrevAndNext(
			long fileInfoId, long companyId, long repositoryId, String path,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_LikeP_PrevAndNext(
			fileInfoId, companyId, repositoryId, path, orderByComparator);
	}

	/**
	 * Removes all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 */
	public static void removeByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		getPersistence().removeByC_R_LikeP(companyId, repositoryId, path);
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @return the number of matching file infos
	 */
	public static int countByC_R_LikeP(
		long companyId, long repositoryId, String path) {

		return getPersistence().countByC_R_LikeP(companyId, repositoryId, path);
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or throws a <code>NoSuchFileInfoException</code> if it could not be found.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_R_P_V(
			long companyId, long repositoryId, String path, String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_R_P_V(
			companyId, repositoryId, path, version);
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_P_V(
		long companyId, long repositoryId, String path, String version) {

		return getPersistence().fetchByC_R_P_V(
			companyId, repositoryId, path, version);
	}

	/**
	 * Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_R_P_V(
		long companyId, long repositoryId, String path, String version,
		boolean useFinderCache) {

		return getPersistence().fetchByC_R_P_V(
			companyId, repositoryId, path, version, useFinderCache);
	}

	/**
	 * Removes the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the file info that was removed
	 */
	public static FileInfo removeByC_R_P_V(
			long companyId, long repositoryId, String path, String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().removeByC_R_P_V(
			companyId, repositoryId, path, version);
	}

	/**
	 * Returns the number of file infos where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63;.
	 *
	 * @param companyId the company ID
	 * @param repositoryId the repository ID
	 * @param path the path
	 * @param version the version
	 * @return the number of matching file infos
	 */
	public static int countByC_R_P_V(
		long companyId, long repositoryId, String path, String version) {

		return getPersistence().countByC_R_P_V(
			companyId, repositoryId, path, version);
	}

	/**
	 * Returns all the file infos where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @return the matching file infos
	 */
	public static List<FileInfo> findByFileData(long fileDataId) {
		return getPersistence().findByFileData(fileDataId);
	}

	/**
	 * Returns a range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	public static List<FileInfo> findByFileData(
		long fileDataId, int start, int end) {

		return getPersistence().findByFileData(fileDataId, start, end);
	}

	/**
	 * Returns an ordered range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByFileData(
		long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findByFileData(
			fileDataId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos where fileDataId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param fileDataId the file data ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByFileData(
		long fileDataId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFileData(
			fileDataId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByFileData_First(
			long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByFileData_First(
			fileDataId, orderByComparator);
	}

	/**
	 * Returns the first file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByFileData_First(
		long fileDataId, OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByFileData_First(
			fileDataId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByFileData_Last(
			long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByFileData_Last(
			fileDataId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByFileData_Last(
		long fileDataId, OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByFileData_Last(
			fileDataId, orderByComparator);
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where fileDataId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param fileDataId the file data ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo[] findByFileData_PrevAndNext(
			long fileInfoId, long fileDataId,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByFileData_PrevAndNext(
			fileInfoId, fileDataId, orderByComparator);
	}

	/**
	 * Removes all the file infos where fileDataId = &#63; from the database.
	 *
	 * @param fileDataId the file data ID
	 */
	public static void removeByFileData(long fileDataId) {
		getPersistence().removeByFileData(fileDataId);
	}

	/**
	 * Returns the number of file infos where fileDataId = &#63;.
	 *
	 * @param fileDataId the file data ID
	 * @return the number of matching file infos
	 */
	public static int countByFileData(long fileDataId) {
		return getPersistence().countByFileData(fileDataId);
	}

	/**
	 * Returns all the file infos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching file infos
	 */
	public static List<FileInfo> findByC(long companyId) {
		return getPersistence().findByC(companyId);
	}

	/**
	 * Returns a range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of matching file infos
	 */
	public static List<FileInfo> findByC(long companyId, int start, int end) {
		return getPersistence().findByC(companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC(
		long companyId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findByC(
			companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file infos
	 */
	public static List<FileInfo> findByC(
		long companyId, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByC(
			companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_First(
			long companyId, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_First(companyId, orderByComparator);
	}

	/**
	 * Returns the first file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_First(
		long companyId, OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_First(companyId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info
	 * @throws NoSuchFileInfoException if a matching file info could not be found
	 */
	public static FileInfo findByC_Last(
			long companyId, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_Last(companyId, orderByComparator);
	}

	/**
	 * Returns the last file info in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file info, or <code>null</code> if a matching file info could not be found
	 */
	public static FileInfo fetchByC_Last(
		long companyId, OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().fetchByC_Last(companyId, orderByComparator);
	}

	/**
	 * Returns the file infos before and after the current file info in the ordered set where companyId = &#63;.
	 *
	 * @param fileInfoId the primary key of the current file info
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo[] findByC_PrevAndNext(
			long fileInfoId, long companyId,
			OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByC_PrevAndNext(
			fileInfoId, companyId, orderByComparator);
	}

	/**
	 * Removes all the file infos where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public static void removeByC(long companyId) {
		getPersistence().removeByC(companyId);
	}

	/**
	 * Returns the number of file infos where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching file infos
	 */
	public static int countByC(long companyId) {
		return getPersistence().countByC(companyId);
	}

	/**
	 * Caches the file info in the entity cache if it is enabled.
	 *
	 * @param fileInfo the file info
	 */
	public static void cacheResult(FileInfo fileInfo) {
		getPersistence().cacheResult(fileInfo);
	}

	/**
	 * Caches the file infos in the entity cache if it is enabled.
	 *
	 * @param fileInfos the file infos
	 */
	public static void cacheResult(List<FileInfo> fileInfos) {
		getPersistence().cacheResult(fileInfos);
	}

	/**
	 * Creates a new file info with the primary key. Does not add the file info to the database.
	 *
	 * @param fileInfoId the primary key for the new file info
	 * @return the new file info
	 */
	public static FileInfo create(long fileInfoId) {
		return getPersistence().create(fileInfoId);
	}

	/**
	 * Removes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info that was removed
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo remove(long fileInfoId)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().remove(fileInfoId);
	}

	public static FileInfo updateImpl(FileInfo fileInfo) {
		return getPersistence().updateImpl(fileInfo);
	}

	/**
	 * Returns the file info with the primary key or throws a <code>NoSuchFileInfoException</code> if it could not be found.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info
	 * @throws NoSuchFileInfoException if a file info with the primary key could not be found
	 */
	public static FileInfo findByPrimaryKey(long fileInfoId)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {

		return getPersistence().findByPrimaryKey(fileInfoId);
	}

	/**
	 * Returns the file info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info, or <code>null</code> if a file info with the primary key could not be found
	 */
	public static FileInfo fetchByPrimaryKey(long fileInfoId) {
		return getPersistence().fetchByPrimaryKey(fileInfoId);
	}

	/**
	 * Returns all the file infos.
	 *
	 * @return the file infos
	 */
	public static List<FileInfo> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of file infos
	 */
	public static List<FileInfo> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file infos
	 */
	public static List<FileInfo> findAll(
		int start, int end, OrderByComparator<FileInfo> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file infos
	 */
	public static List<FileInfo> findAll(
		int start, int end, OrderByComparator<FileInfo> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file infos from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file infos.
	 *
	 * @return the number of file infos
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileInfoPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FileInfoPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FileInfoPersistence _persistence;

}