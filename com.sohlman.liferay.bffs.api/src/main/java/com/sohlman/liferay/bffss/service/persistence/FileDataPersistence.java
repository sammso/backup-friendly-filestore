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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sohlman.liferay.bffss.exception.NoSuchFileDataException;
import com.sohlman.liferay.bffss.model.FileData;

/**
 * The persistence interface for the file data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.sohlman.liferay.bffss.service.persistence.impl.FileDataPersistenceImpl
 * @see FileDataUtil
 * @generated
 */
@ProviderType
public interface FileDataPersistence extends BasePersistence<FileData> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link FileDataUtil} to access the file data persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the file datas where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @return the matching file datas
	*/
	public java.util.List<FileData> findByFingerPrint(
		java.lang.String fingerprint);

	/**
	* Returns a range of all the file datas where fingerprint = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fingerprint the fingerprint
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @return the range of matching file datas
	*/
	public java.util.List<FileData> findByFingerPrint(
		java.lang.String fingerprint, int start, int end);

	/**
	* Returns an ordered range of all the file datas where fingerprint = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fingerprint the fingerprint
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching file datas
	*/
	public java.util.List<FileData> findByFingerPrint(
		java.lang.String fingerprint, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator);

	/**
	* Returns an ordered range of all the file datas where fingerprint = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param fingerprint the fingerprint
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching file datas
	*/
	public java.util.List<FileData> findByFingerPrint(
		java.lang.String fingerprint, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first file data in the ordered set where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file data
	* @throws NoSuchFileDataException if a matching file data could not be found
	*/
	public FileData findByFingerPrint_First(java.lang.String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException;

	/**
	* Returns the first file data in the ordered set where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching file data, or <code>null</code> if a matching file data could not be found
	*/
	public FileData fetchByFingerPrint_First(java.lang.String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator);

	/**
	* Returns the last file data in the ordered set where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file data
	* @throws NoSuchFileDataException if a matching file data could not be found
	*/
	public FileData findByFingerPrint_Last(java.lang.String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException;

	/**
	* Returns the last file data in the ordered set where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching file data, or <code>null</code> if a matching file data could not be found
	*/
	public FileData fetchByFingerPrint_Last(java.lang.String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator);

	/**
	* Returns the file datas before and after the current file data in the ordered set where fingerprint = &#63;.
	*
	* @param fileDataId the primary key of the current file data
	* @param fingerprint the fingerprint
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next file data
	* @throws NoSuchFileDataException if a file data with the primary key could not be found
	*/
	public FileData[] findByFingerPrint_PrevAndNext(long fileDataId,
		java.lang.String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator)
		throws NoSuchFileDataException;

	/**
	* Removes all the file datas where fingerprint = &#63; from the database.
	*
	* @param fingerprint the fingerprint
	*/
	public void removeByFingerPrint(java.lang.String fingerprint);

	/**
	* Returns the number of file datas where fingerprint = &#63;.
	*
	* @param fingerprint the fingerprint
	* @return the number of matching file datas
	*/
	public int countByFingerPrint(java.lang.String fingerprint);

	/**
	* Caches the file data in the entity cache if it is enabled.
	*
	* @param fileData the file data
	*/
	public void cacheResult(FileData fileData);

	/**
	* Caches the file datas in the entity cache if it is enabled.
	*
	* @param fileDatas the file datas
	*/
	public void cacheResult(java.util.List<FileData> fileDatas);

	/**
	* Creates a new file data with the primary key. Does not add the file data to the database.
	*
	* @param fileDataId the primary key for the new file data
	* @return the new file data
	*/
	public FileData create(long fileDataId);

	/**
	* Removes the file data with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param fileDataId the primary key of the file data
	* @return the file data that was removed
	* @throws NoSuchFileDataException if a file data with the primary key could not be found
	*/
	public FileData remove(long fileDataId) throws NoSuchFileDataException;

	public FileData updateImpl(FileData fileData);

	/**
	* Returns the file data with the primary key or throws a {@link NoSuchFileDataException} if it could not be found.
	*
	* @param fileDataId the primary key of the file data
	* @return the file data
	* @throws NoSuchFileDataException if a file data with the primary key could not be found
	*/
	public FileData findByPrimaryKey(long fileDataId)
		throws NoSuchFileDataException;

	/**
	* Returns the file data with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param fileDataId the primary key of the file data
	* @return the file data, or <code>null</code> if a file data with the primary key could not be found
	*/
	public FileData fetchByPrimaryKey(long fileDataId);

	@Override
	public java.util.Map<java.io.Serializable, FileData> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the file datas.
	*
	* @return the file datas
	*/
	public java.util.List<FileData> findAll();

	/**
	* Returns a range of all the file datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @return the range of file datas
	*/
	public java.util.List<FileData> findAll(int start, int end);

	/**
	* Returns an ordered range of all the file datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of file datas
	*/
	public java.util.List<FileData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator);

	/**
	* Returns an ordered range of all the file datas.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link FileDataModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of file datas
	* @param end the upper bound of the range of file datas (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of file datas
	*/
	public java.util.List<FileData> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the file datas from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of file datas.
	*
	* @return the number of file datas
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}