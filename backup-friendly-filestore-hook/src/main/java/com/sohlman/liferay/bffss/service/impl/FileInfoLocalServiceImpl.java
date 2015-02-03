/**
 * Copyright (c) 2000-present Liferay, Inc. and Sampsa Sohlman All rights 
 * reserved.
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
package com.sohlman.liferay.bffss.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sohlman.liferay.bffss.NoSuchFileInfoException;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.service.base.FileInfoLocalServiceBaseImpl;
import com.sohlman.liferay.bffss.util.FileInfoVersionComparator;

import java.io.InputStream;
import java.util.List;

/**
 * The implementation of the file info local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sohlman.liferay.bffss.service.FileInfoLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @author Shuyang Zhou
 * @author Sampsa Sohlman
 * 
 * @see com.sohlman.liferay.bffss.service.base.FileInfoLocalServiceBaseImpl
 * @see com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil
 */
public class FileInfoLocalServiceImpl extends FileInfoLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil} to access the
	 * file info local service.
	 */
	@Override
	public FileInfo addFileInfo(long companyId, long repositoryId, String path,
			String version, byte[] bytes) throws SystemException {

		InputStream inputStream = null;

		try {
			long fileInfoId = counterLocalService.increment(FileInfo.class
					.getName());

			FileInfo fileInfo = fileInfoPersistence.create(fileInfoId);

			fileInfo.setCompanyId(companyId);
			fileInfo.setRepositoryId(repositoryId);
			fileInfo.setPath(path);
			fileInfo.setVersion(version);

			UnsyncByteArrayInputStream unsyncByteArrayInputStream = 
				new UnsyncByteArrayInputStream(bytes);

			inputStream = new UnsyncByteArrayInputStream(bytes);
			storeFileInfo(fileInfo, bytes.length, inputStream);

			fileInfoPersistence.update(fileInfo);

			return fileInfo;
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	@Override
	public FileInfo addFileInfo(long companyId, long repositoryId, String path,
			String version, InputStream inputStream, long size)
			throws SystemException {

		long fileId = counterLocalService.increment(FileInfo.class.getName());

		FileInfo fileInfo = fileInfoPersistence.create(fileId);

		fileInfo.setCompanyId(companyId);
		fileInfo.setRepositoryId(repositoryId);
		fileInfo.setPath(path);
		fileInfo.setVersion(version);

		storeFileInfo(fileInfo, size, inputStream);

		fileInfoPersistence.update(fileInfo);

		return fileInfo;
	}

	protected void storeFileInfo(FileInfo fileInfo, long size,
			InputStream inputStream) throws SystemException {
		FileData fileData = fileDataLocalService.addFileData(
			fileInfo.getCompanyId(), size, inputStream);
		fileInfo.setFileDataId(fileData.getFileDataId());
	}

	@Override
	public void deleteFileInfo(long companyId, long repositoryId, String path,
			String version) throws PortalException, SystemException {

		FileInfo fileInfo = fileInfoPersistence.findByC_R_P_V(companyId,
				repositoryId, path, version);

		fileInfoPersistence.update(fileInfo);
	}

	@Override
	public void deleteFileInfos(long companyId, long repositoryId, String path)
			throws SystemException, PortalException {

		List<FileInfo> fileInfos = fileInfoPersistence.findByC_R_P(companyId,
				repositoryId, path);

		for (FileInfo fileInfo : fileInfos) {
			deleteFileInfo(fileInfo);
		}
	}

	@Override
	public void deleteFileInfosByDirectory(long companyId, long repositoryId,
			String dirName) throws SystemException, PortalException {

		if (!dirName.endsWith(StringPool.SLASH)) {
			dirName = dirName.concat(StringPool.SLASH);
		}

		dirName = dirName.concat(StringPool.PERCENT);

		List<FileInfo> fileInfos = fileInfoPersistence.findByC_R_LikeP(
				companyId, repositoryId, dirName);


		for (FileInfo fileInfo : fileInfos) {
			deleteFileInfo(fileInfo);
		}
	}

	@Override
	public FileInfo getFileInfo(long companyId, long repositoryId, String path)
			throws NoSuchFileInfoException, SystemException {

		OrderByComparator orderByComparator = new FileInfoVersionComparator();

		List<FileInfo> fileInfos = fileInfoPersistence.findByC_R_P(companyId,
				repositoryId, path, 0, 1, orderByComparator);

		if ((fileInfos == null) || fileInfos.isEmpty()) {
			throw new NoSuchFileInfoException(path);
		}

		return fileInfos.get(0);
	}

	@Override
	public FileInfo getFileInfo(long companyId, long repositoryId, String path,
			String version) throws NoSuchFileInfoException, SystemException {

		FileInfo fileInfo = fileInfoPersistence.findByC_R_P_V(companyId,
				repositoryId, path, version);

		return fileInfo;
	}

	@Override
	public List<FileInfo> getFileInfos(long companyId, long repositoryId)
			throws SystemException {

		return fileInfoPersistence.findByC_R(companyId, repositoryId);
	}

	@Override
	public List<FileInfo> getFileInfos(long companyId, long repositoryId,
			String path) throws SystemException {

		return fileInfoPersistence.findByC_R_P(companyId, repositoryId, path);
	}

	@Override
	public List<FileInfo> getFileInfosByDirectory(long companyId,
			long repositoryId, String dirName) throws SystemException {

		if (!dirName.endsWith(StringPool.SLASH)) {
			dirName = dirName.concat(StringPool.SLASH);
		}

		dirName = dirName.concat(StringPool.PERCENT);

		return fileInfoPersistence.findByC_R_LikeP(companyId, repositoryId,
				dirName);
	}

	@Override
	public InputStream getFileAsStream(long companyId, long repositoryId,
			String fileName) throws PortalException, SystemException {
		FileInfo fileInfo = getFileInfo(companyId, repositoryId, fileName);
		
		return fileDataLocalService.getFileInputStream(
			fileInfo.getFileDataId());
	}

	@Override
	public InputStream getFileAsStream(long companyId, long repositoryId,
			String fileName, String version) throws PortalException,
			SystemException {		
		
		FileInfo fileInfo = getFileInfo(companyId, repositoryId, fileName,
				version);
		
		return fileDataLocalService.getFileInputStream(
			fileInfo.getFileDataId());
	}

	@Override
	public boolean hasFileInfo(long companyId, long repositoryId, String path,
			String version) throws SystemException {

		int count = fileInfoPersistence.countByC_R_P_V(companyId, repositoryId,
			path, version);

		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateFileInfo(long companyId, long oldRepositoryId,
			long newRepositoryId, String oldPath, String newPath)
			throws SystemException {

		List<FileInfo> fileInfos = fileInfoPersistence.findByC_R_P(
			companyId, oldRepositoryId, oldPath);

		for (FileInfo fileInfo : fileInfos) {
			fileInfo.setRepositoryId(newRepositoryId);
			fileInfo.setPath(newPath);

			fileInfoPersistence.update(fileInfo);
		}
	}
}
