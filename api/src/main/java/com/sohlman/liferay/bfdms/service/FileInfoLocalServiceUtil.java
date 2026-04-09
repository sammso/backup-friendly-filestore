/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.sohlman.liferay.bfdms.model.FileInfo;

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for FileInfo. This utility wraps
 * <code>com.sohlman.liferay.bfdms.service.impl.FileInfoLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoLocalService
 * @generated
 */
public class FileInfoLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.sohlman.liferay.bfdms.service.impl.FileInfoLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the file info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileInfo the file info
	 * @return the file info that was added
	 */
	public static FileInfo addFileInfo(FileInfo fileInfo) {
		return getService().addFileInfo(fileInfo);
	}

	public static FileInfo addFileInfo(
			long companyId, long repositoryId, String path, String version,
			InputStream inputStream)
		throws SystemException {

		return getService().addFileInfo(
			companyId, repositoryId, path, version, inputStream);
	}

	/**
	 * Creates a new file info with the primary key. Does not add the file info to the database.
	 *
	 * @param fileInfoId the primary key for the new file info
	 * @return the new file info
	 */
	public static FileInfo createFileInfo(long fileInfoId) {
		return getService().createFileInfo(fileInfoId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the file info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileInfo the file info
	 * @return the file info that was removed
	 */
	public static FileInfo deleteFileInfo(FileInfo fileInfo) {
		return getService().deleteFileInfo(fileInfo);
	}

	/**
	 * Deletes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info that was removed
	 * @throws PortalException if a file info with the primary key could not be found
	 */
	public static FileInfo deleteFileInfo(long fileInfoId)
		throws PortalException {

		return getService().deleteFileInfo(fileInfoId);
	}

	public static void deleteFileInfo(
			long companyId, long repositoryId, String path, String version)
		throws PortalException, SystemException {

		getService().deleteFileInfo(companyId, repositoryId, path, version);
	}

	public static void deleteFileInfos(
			long companyId, long repositoryId, String path)
		throws PortalException, SystemException {

		getService().deleteFileInfos(companyId, repositoryId, path);
	}

	public static void deleteFileInfosByCompany(long companyId)
		throws PortalException {

		getService().deleteFileInfosByCompany(companyId);
	}

	public static void deleteFileInfosByDirectory(
			long companyId, long repositoryId, String dirName)
		throws PortalException, SystemException {

		getService().deleteFileInfosByDirectory(
			companyId, repositoryId, dirName);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sohlman.liferay.bfdms.model.impl.FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sohlman.liferay.bfdms.model.impl.FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static FileInfo fetchFileInfo(long fileInfoId) {
		return getService().fetchFileInfo(fileInfoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return getService().getFileAsStream(companyId, repositoryId, fileName);
	}

	public static InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName, String version)
		throws PortalException, SystemException {

		return getService().getFileAsStream(
			companyId, repositoryId, fileName, version);
	}

	/**
	 * Returns the file info with the primary key.
	 *
	 * @param fileInfoId the primary key of the file info
	 * @return the file info
	 * @throws PortalException if a file info with the primary key could not be found
	 */
	public static FileInfo getFileInfo(long fileInfoId) throws PortalException {
		return getService().getFileInfo(fileInfoId);
	}

	public static FileInfo getFileInfo(
			long companyId, long repositoryId, String path)
		throws com.sohlman.liferay.bfdms.exception.NoSuchFileInfoException {

		return getService().getFileInfo(companyId, repositoryId, path);
	}

	public static FileInfo getFileInfo(
			long companyId, long repositoryId, String path, String version)
		throws com.sohlman.liferay.bfdms.exception.NoSuchFileInfoException {

		return getService().getFileInfo(companyId, repositoryId, path, version);
	}

	/**
	 * Returns a range of all the file infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.sohlman.liferay.bfdms.model.impl.FileInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file infos
	 * @param end the upper bound of the range of file infos (not inclusive)
	 * @return the range of file infos
	 */
	public static List<FileInfo> getFileInfos(int start, int end) {
		return getService().getFileInfos(start, end);
	}

	public static List<FileInfo> getFileInfos(long companyId, long repositoryId)
		throws SystemException {

		return getService().getFileInfos(companyId, repositoryId);
	}

	public static List<FileInfo> getFileInfos(
			long companyId, long repositoryId, String path)
		throws SystemException {

		return getService().getFileInfos(companyId, repositoryId, path);
	}

	public static List<FileInfo> getFileInfosByDirectory(
			long companyId, long repositoryId, String dirName)
		throws SystemException {

		return getService().getFileInfosByDirectory(
			companyId, repositoryId, dirName);
	}

	/**
	 * Returns the number of file infos.
	 *
	 * @return the number of file infos
	 */
	public static int getFileInfosCount() {
		return getService().getFileInfosCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static boolean hasFileInfo(
			long companyId, long repositoryId, String path, String version)
		throws SystemException {

		return getService().hasFileInfo(companyId, repositoryId, path, version);
	}

	/**
	 * Updates the file info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FileInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fileInfo the file info
	 * @return the file info that was updated
	 */
	public static FileInfo updateFileInfo(FileInfo fileInfo) {
		return getService().updateFileInfo(fileInfo);
	}

	public static void updateFileInfo(
			long companyId, long oldRepositoryId, long newRepositoryId,
			String oldPath, String newPath)
		throws SystemException {

		getService().updateFileInfo(
			companyId, oldRepositoryId, newRepositoryId, oldPath, newPath);
	}

	public static FileInfoLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<FileInfoLocalService> _serviceSnapshot =
		new Snapshot<>(
			FileInfoLocalServiceUtil.class, FileInfoLocalService.class);

}