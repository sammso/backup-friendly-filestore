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
 * Provides a wrapper for {@link FileDataLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FileDataLocalService
 * @generated
 */
@ProviderType
public class FileDataLocalServiceWrapper implements FileDataLocalService,
	ServiceWrapper<FileDataLocalService> {
	public FileDataLocalServiceWrapper(
		FileDataLocalService fileDataLocalService) {
		_fileDataLocalService = fileDataLocalService;
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileData addFileData(
		long companyId, java.io.InputStream inputStream)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fileDataLocalService.addFileData(companyId, inputStream);
	}

	/**
	* Adds the file data to the database. Also notifies the appropriate model listeners.
	*
	* @param fileData the file data
	* @return the file data that was added
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData addFileData(
		com.sohlman.liferay.bffss.model.FileData fileData) {
		return _fileDataLocalService.addFileData(fileData);
	}

	/**
	* Creates a new file data with the primary key. Does not add the file data to the database.
	*
	* @param fileDataId the primary key for the new file data
	* @return the new file data
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData createFileData(
		long fileDataId) {
		return _fileDataLocalService.createFileData(fileDataId);
	}

	/**
	* Deletes the file data from the database. Also notifies the appropriate model listeners.
	*
	* @param fileData the file data
	* @return the file data that was removed
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData deleteFileData(
		com.sohlman.liferay.bffss.model.FileData fileData) {
		return _fileDataLocalService.deleteFileData(fileData);
	}

	/**
	* Deletes the file data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileDataId the primary key of the file data
	* @return the file data that was removed
	* @throws PortalException if a file data with the primary key could not be found
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData deleteFileData(
		long fileDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileDataLocalService.deleteFileData(fileDataId);
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileDataLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fileDataLocalService.dynamicQuery();
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
		return _fileDataLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fileDataLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sohlman.liferay.bffss.model.impl.FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _fileDataLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _fileDataLocalService.dynamicQueryCount(dynamicQuery);
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
		return _fileDataLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.sohlman.liferay.bffss.model.FileData fetchFileData(
		long fileDataId) {
		return _fileDataLocalService.fetchFileData(fileDataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _fileDataLocalService.getActionableDynamicQuery();
	}

	/**
	* Returns the file data with the primary key.
	*
	* @param fileDataId the primary key of the file data
	* @return the file data
	* @throws PortalException if a file data with the primary key could not be found
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData getFileData(long fileDataId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileDataLocalService.getFileData(fileDataId);
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
	*/
	@Override
	public java.util.List<com.sohlman.liferay.bffss.model.FileData> getFileDatas(
		int start, int end) {
		return _fileDataLocalService.getFileDatas(start, end);
	}

	/**
	* Returns the number of file datas.
	*
	* @return the number of file datas
	*/
	@Override
	public int getFileDatasCount() {
		return _fileDataLocalService.getFileDatasCount();
	}

	@Override
	public java.io.InputStream getFileInputStream(
		com.sohlman.liferay.bffss.model.FileData fileData)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileDataLocalService.getFileInputStream(fileData);
	}

	@Override
	public java.io.InputStream getFileInputStream(long fileDataId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _fileDataLocalService.getFileInputStream(fileDataId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _fileDataLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _fileDataLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _fileDataLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Updates the file data in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param fileData the file data
	* @return the file data that was updated
	*/
	@Override
	public com.sohlman.liferay.bffss.model.FileData updateFileData(
		com.sohlman.liferay.bffss.model.FileData fileData) {
		return _fileDataLocalService.updateFileData(fileData);
	}

	@Override
	public FileDataLocalService getWrappedService() {
		return _fileDataLocalService;
	}

	@Override
	public void setWrappedService(FileDataLocalService fileDataLocalService) {
		_fileDataLocalService = fileDataLocalService;
	}

	private FileDataLocalService _fileDataLocalService;
}