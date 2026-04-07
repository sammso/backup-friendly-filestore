/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bffss.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.liferay.bffss.model.FileData;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the file data service. This utility wraps <code>com.sohlman.liferay.bffss.service.persistence.impl.FileDataPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FileDataPersistence
 * @generated
 */
public class FileDataUtil {

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
	public static void clearCache(FileData fileData) {
		getPersistence().clearCache(fileData);
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
	public static Map<Serializable, FileData> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<FileData> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<FileData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<FileData> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<FileData> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static FileData update(FileData fileData) {
		return getPersistence().update(fileData);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static FileData update(
		FileData fileData, ServiceContext serviceContext) {

		return getPersistence().update(fileData, serviceContext);
	}

	/**
	 * Returns all the file datas where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @return the matching file datas
	 */
	public static List<FileData> findByFingerPrint(String fingerprint) {
		return getPersistence().findByFingerPrint(fingerprint);
	}

	/**
	 * Returns a range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @return the range of matching file datas
	 */
	public static List<FileData> findByFingerPrint(
		String fingerprint, int start, int end) {

		return getPersistence().findByFingerPrint(fingerprint, start, end);
	}

	/**
	 * Returns an ordered range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching file datas
	 */
	public static List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		OrderByComparator<FileData> orderByComparator) {

		return getPersistence().findByFingerPrint(
			fingerprint, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file datas where fingerprint = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param fingerprint the fingerprint
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching file datas
	 */
	public static List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		OrderByComparator<FileData> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFingerPrint(
			fingerprint, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	public static FileData findByFingerPrint_First(
			String fingerprint, OrderByComparator<FileData> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileDataException {

		return getPersistence().findByFingerPrint_First(
			fingerprint, orderByComparator);
	}

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data, or <code>null</code> if a matching file data could not be found
	 */
	public static FileData fetchByFingerPrint_First(
		String fingerprint, OrderByComparator<FileData> orderByComparator) {

		return getPersistence().fetchByFingerPrint_First(
			fingerprint, orderByComparator);
	}

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	public static FileData findByFingerPrint_Last(
			String fingerprint, OrderByComparator<FileData> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileDataException {

		return getPersistence().findByFingerPrint_Last(
			fingerprint, orderByComparator);
	}

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data, or <code>null</code> if a matching file data could not be found
	 */
	public static FileData fetchByFingerPrint_Last(
		String fingerprint, OrderByComparator<FileData> orderByComparator) {

		return getPersistence().fetchByFingerPrint_Last(
			fingerprint, orderByComparator);
	}

	/**
	 * Returns the file datas before and after the current file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fileDataId the primary key of the current file data
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	public static FileData[] findByFingerPrint_PrevAndNext(
			long fileDataId, String fingerprint,
			OrderByComparator<FileData> orderByComparator)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileDataException {

		return getPersistence().findByFingerPrint_PrevAndNext(
			fileDataId, fingerprint, orderByComparator);
	}

	/**
	 * Removes all the file datas where fingerprint = &#63; from the database.
	 *
	 * @param fingerprint the fingerprint
	 */
	public static void removeByFingerPrint(String fingerprint) {
		getPersistence().removeByFingerPrint(fingerprint);
	}

	/**
	 * Returns the number of file datas where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @return the number of matching file datas
	 */
	public static int countByFingerPrint(String fingerprint) {
		return getPersistence().countByFingerPrint(fingerprint);
	}

	/**
	 * Caches the file data in the entity cache if it is enabled.
	 *
	 * @param fileData the file data
	 */
	public static void cacheResult(FileData fileData) {
		getPersistence().cacheResult(fileData);
	}

	/**
	 * Caches the file datas in the entity cache if it is enabled.
	 *
	 * @param fileDatas the file datas
	 */
	public static void cacheResult(List<FileData> fileDatas) {
		getPersistence().cacheResult(fileDatas);
	}

	/**
	 * Creates a new file data with the primary key. Does not add the file data to the database.
	 *
	 * @param fileDataId the primary key for the new file data
	 * @return the new file data
	 */
	public static FileData create(long fileDataId) {
		return getPersistence().create(fileDataId);
	}

	/**
	 * Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data that was removed
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	public static FileData remove(long fileDataId)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileDataException {

		return getPersistence().remove(fileDataId);
	}

	public static FileData updateImpl(FileData fileData) {
		return getPersistence().updateImpl(fileData);
	}

	/**
	 * Returns the file data with the primary key or throws a <code>NoSuchFileDataException</code> if it could not be found.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	public static FileData findByPrimaryKey(long fileDataId)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileDataException {

		return getPersistence().findByPrimaryKey(fileDataId);
	}

	/**
	 * Returns the file data with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param fileDataId the primary key of the file data
	 * @return the file data, or <code>null</code> if a file data with the primary key could not be found
	 */
	public static FileData fetchByPrimaryKey(long fileDataId) {
		return getPersistence().fetchByPrimaryKey(fileDataId);
	}

	/**
	 * Returns all the file datas.
	 *
	 * @return the file datas
	 */
	public static List<FileData> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @return the range of file datas
	 */
	public static List<FileData> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file datas
	 */
	public static List<FileData> findAll(
		int start, int end, OrderByComparator<FileData> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the file datas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of file datas
	 */
	public static List<FileData> findAll(
		int start, int end, OrderByComparator<FileData> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the file datas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of file datas.
	 *
	 * @return the number of file datas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static FileDataPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(FileDataPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile FileDataPersistence _persistence;

}