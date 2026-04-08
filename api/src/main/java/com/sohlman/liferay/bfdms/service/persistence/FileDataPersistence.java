/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.sohlman.liferay.bfdms.exception.NoSuchFileDataException;
import com.sohlman.liferay.bfdms.model.FileData;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the file data service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
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
	public java.util.List<FileData> findByFingerPrint(String fingerprint);

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
	public java.util.List<FileData> findByFingerPrint(
		String fingerprint, int start, int end);

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
	public java.util.List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator);

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
	public java.util.List<FileData> findByFingerPrint(
		String fingerprint, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	public FileData findByFingerPrint_First(
			String fingerprint,
			com.liferay.portal.kernel.util.OrderByComparator<FileData>
				orderByComparator)
		throws NoSuchFileDataException;

	/**
	 * Returns the first file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching file data, or <code>null</code> if a matching file data could not be found
	 */
	public FileData fetchByFingerPrint_First(
		String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator);

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data
	 * @throws NoSuchFileDataException if a matching file data could not be found
	 */
	public FileData findByFingerPrint_Last(
			String fingerprint,
			com.liferay.portal.kernel.util.OrderByComparator<FileData>
				orderByComparator)
		throws NoSuchFileDataException;

	/**
	 * Returns the last file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching file data, or <code>null</code> if a matching file data could not be found
	 */
	public FileData fetchByFingerPrint_Last(
		String fingerprint,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator);

	/**
	 * Returns the file datas before and after the current file data in the ordered set where fingerprint = &#63;.
	 *
	 * @param fileDataId the primary key of the current file data
	 * @param fingerprint the fingerprint
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next file data
	 * @throws NoSuchFileDataException if a file data with the primary key could not be found
	 */
	public FileData[] findByFingerPrint_PrevAndNext(
			long fileDataId, String fingerprint,
			com.liferay.portal.kernel.util.OrderByComparator<FileData>
				orderByComparator)
		throws NoSuchFileDataException;

	/**
	 * Removes all the file datas where fingerprint = &#63; from the database.
	 *
	 * @param fingerprint the fingerprint
	 */
	public void removeByFingerPrint(String fingerprint);

	/**
	 * Returns the number of file datas where fingerprint = &#63;.
	 *
	 * @param fingerprint the fingerprint
	 * @return the number of matching file datas
	 */
	public int countByFingerPrint(String fingerprint);

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
	 * Returns the file data with the primary key or throws a <code>NoSuchFileDataException</code> if it could not be found.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FileDataModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of file datas
	 * @param end the upper bound of the range of file datas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of file datas
	 */
	public java.util.List<FileData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator);

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
	public java.util.List<FileData> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<FileData>
			orderByComparator,
		boolean useFinderCache);

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

}