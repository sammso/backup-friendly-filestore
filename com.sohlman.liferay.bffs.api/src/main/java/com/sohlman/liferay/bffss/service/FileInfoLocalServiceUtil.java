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

package com.sohlman.liferay.bffss.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

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
@ProviderType
public class FileInfoLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sohlman.liferay.bffss.service.impl.FileInfoLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
		long companyId, long repositoryId, java.lang.String path,
		java.lang.String version, java.io.InputStream inputStream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addFileInfo(companyId, repositoryId, path, version,
			inputStream);
	}

	/**
	* Adds the file info to the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was added
	*/
	public static com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
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

	public static void deleteFileInfo(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteFileInfo(companyId, repositoryId, path, version);
	}

	/**
	* Deletes the file info from the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was removed
	*/
	public static com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
		return getService().deleteFileInfo(fileInfo);
	}

	/**
	* Deletes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfoId the primary key of the file info
	* @return the file info that was removed
	* @throws PortalException if a file info with the primary key could not be found
	*/
	public static com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
		long fileInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteFileInfo(fileInfoId);
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

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
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
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
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
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
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
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.sohlman.liferay.bffss.model.FileInfo fetchFileInfo(
		long fileInfoId) {
		return getService().fetchFileInfo(fileInfoId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
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

	public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
		long companyId, long repositoryId, java.lang.String path)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getService().getFileInfo(companyId, repositoryId, path);
	}

	public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
		long companyId, long repositoryId, java.lang.String path,
		java.lang.String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return getService().getFileInfo(companyId, repositoryId, path, version);
	}

	/**
	* Returns the file info with the primary key.
	*
	* @param fileInfoId the primary key of the file info
	* @return the file info
	* @throws PortalException if a file info with the primary key could not be found
	*/
	public static com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
		long fileInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getFileInfo(fileInfoId);
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
	*/
	public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
		int start, int end) {
		return getService().getFileInfos(start, end);
	}

	public static java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfosByDirectory(
		long companyId, long repositoryId, java.lang.String dirName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getFileInfosByDirectory(companyId, repositoryId, dirName);
	}

	/**
	* Returns the number of file infos.
	*
	* @return the number of file infos
	*/
	public static int getFileInfosCount() {
		return getService().getFileInfosCount();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
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

	/**
	* Updates the file info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was updated
	*/
	public static com.sohlman.liferay.bffss.model.FileInfo updateFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
		return getService().updateFileInfo(fileInfo);
	}

	public static FileInfoLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<FileInfoLocalService, FileInfoLocalService> _serviceTracker =
		ServiceTrackerFactory.open(FileInfoLocalService.class);
}