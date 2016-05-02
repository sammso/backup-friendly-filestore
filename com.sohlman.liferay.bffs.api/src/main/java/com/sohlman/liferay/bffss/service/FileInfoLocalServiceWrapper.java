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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link FileInfoLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoLocalService
 * @generated
 */
@ProviderType
public class FileInfoLocalServiceWrapper implements FileInfoLocalService,
	ServiceWrapper<FileInfoLocalService> {
	public FileInfoLocalServiceWrapper(
		FileInfoLocalService fileInfoLocalService) {
		_fileInfoLocalService = fileInfoLocalService;
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
		long companyId, long repositoryId, java.lang.String path,
		java.lang.String version, java.io.InputStream inputStream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileInfoLocalService.addFileInfo(companyId, repositoryId, path,
			version, inputStream);
	}

	/**
	* Adds the file info to the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was added
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileInfo addFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
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

	@Override
	public void deleteFileInfo(long companyId, long repositoryId,
		java.lang.String path, java.lang.String version)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_fileInfoLocalService.deleteFileInfo(companyId, repositoryId, path,
			version);
	}

	/**
	* Deletes the file info from the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was removed
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
		return _fileInfoLocalService.deleteFileInfo(fileInfo);
	}

	/**
	* Deletes the file info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileInfoId the primary key of the file info
	* @return the file info that was removed
	* @throws PortalException if a file info with the primary key could not be found
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileInfo deleteFileInfo(
		long fileInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileInfoLocalService.deleteFileInfo(fileInfoId);
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

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileInfoLocalService.deletePersistedModel(persistedModel);
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
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
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _fileInfoLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _fileInfoLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _fileInfoLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileInfo fetchFileInfo(
		long fileInfoId) {
		return _fileInfoLocalService.fetchFileInfo(fileInfoId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _fileInfoLocalService.getActionableDynamicQuery();
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
	public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
		long companyId, long repositoryId, java.lang.String path)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return _fileInfoLocalService.getFileInfo(companyId, repositoryId, path);
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(
		long companyId, long repositoryId, java.lang.String path,
		java.lang.String version)
		throws com.sohlman.liferay.bffss.exception.NoSuchFileInfoException {
		return _fileInfoLocalService.getFileInfo(companyId, repositoryId, path,
			version);
	}

	/**
	* Returns the file info with the primary key.
	*
	* @param fileInfoId the primary key of the file info
	* @return the file info
	* @throws PortalException if a file info with the primary key could not be found
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileInfo getFileInfo(long fileInfoId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileInfoLocalService.getFileInfo(fileInfoId);
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
	@Override
	public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfos(
		int start, int end) {
		return _fileInfoLocalService.getFileInfos(start, end);
	}

	@Override
	public java.util.List<com.sohlman.liferay.bffss.model.FileInfo> getFileInfosByDirectory(
		long companyId, long repositoryId, java.lang.String dirName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileInfoLocalService.getFileInfosByDirectory(companyId,
			repositoryId, dirName);
	}

	/**
	* Returns the number of file infos.
	*
	* @return the number of file infos
	*/
	@Override
	public int getFileInfosCount() {
		return _fileInfoLocalService.getFileInfosCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _fileInfoLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _fileInfoLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileInfoLocalService.getPersistedModel(primaryKeyObj);
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
	* Updates the file info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileInfo the file info
	* @return the file info that was updated
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileInfo updateFileInfo(
		com.sohlman.liferay.bffss.model.FileInfo fileInfo) {
		return _fileInfoLocalService.updateFileInfo(fileInfo);
	}

	@Override
	public FileInfoLocalService getWrappedService() {
		return _fileInfoLocalService;
	}

	@Override
	public void setWrappedService(FileInfoLocalService fileInfoLocalService) {
		_fileInfoLocalService = fileInfoLocalService;
	}

	private FileInfoLocalService _fileInfoLocalService;
}