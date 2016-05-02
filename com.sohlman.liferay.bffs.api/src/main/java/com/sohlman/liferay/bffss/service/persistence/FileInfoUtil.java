/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sohlman.liferay.bffss.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.liferay.bffss.model.FileInfo;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the file info service. This utility wraps {@link com.sohlman.liferay.bffss.service.persistence.impl.FileInfoPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoPersistence
 * @see com.sohlman.liferay.bffss.service.persistence.impl.FileInfoPersistenceImpl
 * @generated
 */
@ProviderType
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
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileInfo> findWithDynamicQuery(DynamicQuery dynamicQuery) {
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
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	public static FileInfo update(FileInfo fileInfo,
		ServiceContext serviceContext) {
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @return the range of matching file infos
	*/
	public static List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end) {
		return getPersistence().findByC_R(companyId, repositoryId, start, end);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end, OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence()
				   .findByC_R(companyId, repositoryId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByC_R(long companyId, long repositoryId,
		int start, int end, OrderByComparator<FileInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_R(companyId, repositoryId, start, end,
			orderByComparator, retrieveFromCache);
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
	public static FileInfo findByC_R_First(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_First(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByC_R_Last(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_Last(long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a file info with the primary key could not be found
	*/
	public static FileInfo[] findByC_R_PrevAndNext(long fileInfoId,
		long companyId, long repositoryId,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getPersistence()
				   .findByC_R_PrevAndNext(fileInfoId, companyId, repositoryId,
			orderByComparator);
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
	public static List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		java.lang.String path) {
		return getPersistence().findByC_R_P(companyId, repositoryId, path);
	}

	/**
	* Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param path the path
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @return the range of matching file infos
	*/
	public static List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		java.lang.String path, int start, int end) {
		return getPersistence()
				   .findByC_R_P(companyId, repositoryId, path, start, end);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		java.lang.String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence()
				   .findByC_R_P(companyId, repositoryId, path, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param path the path
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByC_R_P(long companyId, long repositoryId,
		java.lang.String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_R_P(companyId, repositoryId, path, start, end,
			orderByComparator, retrieveFromCache);
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
	public static FileInfo findByC_R_P_First(long companyId, long repositoryId,
		java.lang.String path, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_P_First(long companyId,
		long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByC_R_P_Last(long companyId, long repositoryId,
		java.lang.String path, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_P_Last(long companyId, long repositoryId,
		java.lang.String path, OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a file info with the primary key could not be found
	*/
	public static FileInfo[] findByC_R_P_PrevAndNext(long fileInfoId,
		long companyId, long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static void removeByC_R_P(long companyId, long repositoryId,
		java.lang.String path) {
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
	public static int countByC_R_P(long companyId, long repositoryId,
		java.lang.String path) {
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
	public static List<FileInfo> findByC_R_LikeP(long companyId,
		long repositoryId, java.lang.String path) {
		return getPersistence().findByC_R_LikeP(companyId, repositoryId, path);
	}

	/**
	* Returns a range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param path the path
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @return the range of matching file infos
	*/
	public static List<FileInfo> findByC_R_LikeP(long companyId,
		long repositoryId, java.lang.String path, int start, int end) {
		return getPersistence()
				   .findByC_R_LikeP(companyId, repositoryId, path, start, end);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	public static List<FileInfo> findByC_R_LikeP(long companyId,
		long repositoryId, java.lang.String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence()
				   .findByC_R_LikeP(companyId, repositoryId, path, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the file infos where companyId = &#63; and repositoryId = &#63; and path LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param path the path
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByC_R_LikeP(long companyId,
		long repositoryId, java.lang.String path, int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByC_R_LikeP(companyId, repositoryId, path, start, end,
			orderByComparator, retrieveFromCache);
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
	public static FileInfo findByC_R_LikeP_First(long companyId,
		long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_LikeP_First(long companyId,
		long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByC_R_LikeP_Last(long companyId,
		long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_LikeP_Last(long companyId,
		long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a file info with the primary key could not be found
	*/
	public static FileInfo[] findByC_R_LikeP_PrevAndNext(long fileInfoId,
		long companyId, long repositoryId, java.lang.String path,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static void removeByC_R_LikeP(long companyId, long repositoryId,
		java.lang.String path) {
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
	public static int countByC_R_LikeP(long companyId, long repositoryId,
		java.lang.String path) {
		return getPersistence().countByC_R_LikeP(companyId, repositoryId, path);
	}

	/**
	* Returns the file info where companyId = &#63; and repositoryId = &#63; and path = &#63; and version = &#63; or throws a {@link NoSuchFileInfoException} if it could not be found.
	*
	* @param companyId the company ID
	* @param repositoryId the repository ID
	* @param path the path
	* @param version the version
	* @return the matching file info
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByC_R_P_V(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static FileInfo fetchByC_R_P_V(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version) {
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
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching file info, or <code>null</code> if a matching file info could not be found
	*/
	public static FileInfo fetchByC_R_P_V(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version,
		boolean retrieveFromCache) {
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
	*/
	public static FileInfo removeByC_R_P_V(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
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
	*/
	public static int countByC_R_P_V(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version) {
		return getPersistence()
				   .countByC_R_P_V(companyId, repositoryId, path, version);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileDataId the file data ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @return the range of matching file infos
	*/
	public static List<FileInfo> findByFileData(long fileDataId, int start,
		int end) {
		return getPersistence().findByFileData(fileDataId, start, end);
	}

	/**
	* Returns an ordered range of all the file infos where fileDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileDataId the file data ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByFileData(long fileDataId, int start,
		int end, OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence()
				   .findByFileData(fileDataId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the file infos where fileDataId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fileDataId the file data ID
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching file infos
	*/
	public static List<FileInfo> findByFileData(long fileDataId, int start,
		int end, OrderByComparator<FileInfo> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByFileData(fileDataId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first file info in the ordered set where fileDataId = &#63;.
	*
	* @param fileDataId the file data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file info
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByFileData_First(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getPersistence()
				   .findByFileData_First(fileDataId, orderByComparator);
	}

	/**
	* Returns the first file info in the ordered set where fileDataId = &#63;.
	*
	* @param fileDataId the file data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file info, or <code>null</code> if a matching file info could not be found
	*/
	public static FileInfo fetchByFileData_First(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence()
				   .fetchByFileData_First(fileDataId, orderByComparator);
	}

	/**
	* Returns the last file info in the ordered set where fileDataId = &#63;.
	*
	* @param fileDataId the file data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file info
	* @throws NoSuchFileInfoException if a matching file info could not be found
	*/
	public static FileInfo findByFileData_Last(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getPersistence()
				   .findByFileData_Last(fileDataId, orderByComparator);
	}

	/**
	* Returns the last file info in the ordered set where fileDataId = &#63;.
	*
	* @param fileDataId the file data ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file info, or <code>null</code> if a matching file info could not be found
	*/
	public static FileInfo fetchByFileData_Last(long fileDataId,
		OrderByComparator<FileInfo> orderByComparator) {
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
	* @throws NoSuchFileInfoException if a file info with the primary key could not be found
	*/
	public static FileInfo[] findByFileData_PrevAndNext(long fileInfoId,
		long fileDataId, OrderByComparator<FileInfo> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getPersistence()
				   .findByFileData_PrevAndNext(fileInfoId, fileDataId,
			orderByComparator);
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
	* Returns the file info with the primary key or throws a {@link NoSuchFileInfoException} if it could not be found.
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

	public static java.util.Map<java.io.Serializable, FileInfo> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of file infos
	*/
	public static List<FileInfo> findAll(int start, int end,
		OrderByComparator<FileInfo> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the file infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file infos
	* @param end the upper bound of the range of file infos (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of file infos
	*/
	public static List<FileInfo> findAll(int start, int end,
		OrderByComparator<FileInfo> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
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

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static FileInfoPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FileInfoPersistence, FileInfoPersistence> _serviceTracker =
		ServiceTrackerFactory.open(FileInfoPersistence.class);
}