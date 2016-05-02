/**
 * Copyright (c) 2000-present Liferay, Inc. and Sampsa Sohlman All rights reserved.
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
package com.sohlman.liferay.bffss;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.exception.DuplicateFileException;
import com.liferay.document.library.kernel.store.BaseStore;
import com.liferay.document.library.kernel.store.Store;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.sohlman.liferay.bffss.configuration.BackupFriendlyFileSystemStoreConfiguration;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.service.FileDataLocalService;
import com.sohlman.liferay.bffss.service.FileInfoLocalService;

/**
 * @author Shuyang Zhou
 * @author Tina Tian
 * @author Sampsa Sohlman
 */
@Component(
		configurationPid = "com.sohlman.liferay.bffss.configuration.BackupFriendlyFileSystemStoreConfiguration",
		property = "store.type=com.sohlman.liferay.bffss.BackupFriendlyFileSystemStore",
		service = Store.class
	)
public class BackupFriendlyFileSystemStore extends BaseStore {

	@Override
	public void addDirectory(
		long companyId, long repositoryId, String dirName) {
	}

	@Override
	public void addFile(
			long companyId, long repositoryId, String fileName, byte[] bytes)
		throws PortalException, SystemException {

		updateFile(
			companyId, repositoryId, fileName, Store.VERSION_DEFAULT, bytes);
	}

	@Override
	public void addFile(
			long companyId, long repositoryId, String fileName, File file)
		throws PortalException, SystemException {

		updateFile(
			companyId, repositoryId, fileName, Store.VERSION_DEFAULT, file);
	}

	@Override
	public void addFile(
			long companyId, long repositoryId, String fileName,
			InputStream inputStream)
		throws PortalException, SystemException {

		updateFile(
			companyId, repositoryId, fileName, Store.VERSION_DEFAULT,
			inputStream);
	}

	@Override
	public void checkRoot(long companyId) {
	}

	@Override
	public void deleteDirectory(
			long companyId, long repositoryId, String dirName)
		throws SystemException {

		try {
			_fileInfoLocalService.deleteFileInfosByDirectory(
				companyId, repositoryId, dirName);
		} catch (PortalException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void deleteFile(long companyId, long repositoryId, String fileName) {
		
		try {
			_fileInfoLocalService.deleteFileInfos(
				companyId, repositoryId, fileName);
		} catch (PortalException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void deleteFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel) {

		try {
			_fileInfoLocalService.deleteFileInfo(
				companyId, repositoryId, fileName, versionLabel);
		} catch (PortalException e) {
			throw new SystemException(e);
		}		
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName)
		throws PortalException {

		return _fileInfoLocalService.getFileAsStream(
			companyId, repositoryId, fileName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName, 
			String versionLabel)
		throws PortalException {
		
		return _fileInfoLocalService.getFileAsStream(
				companyId, repositoryId, fileName, versionLabel);
	}

	@Override
	public String[] getFileNames(long companyId, long repositoryId)
		throws SystemException {

		List<FileInfo> FileInfos = 
			_fileInfoLocalService.getFileInfos(
				companyId, repositoryId);

		String[] fileNames = new String[FileInfos.size()];

		for (int i = 0; i < FileInfos.size(); i++) {
			FileInfo FileInfo = FileInfos.get(i);

			fileNames[i] = FileInfo.getPath();
		}

		return fileNames;
	}

	@Override
	public String[] getFileNames(
			long companyId, long repositoryId, String dirName)
		throws SystemException {

		List<FileInfo> FileInfos =
			_fileInfoLocalService.getFileInfosByDirectory(
				companyId, repositoryId, dirName);

		String[] fileNames = new String[FileInfos.size()];

		for (int i = 0; i < FileInfos.size(); i++) {
			FileInfo FileInfo = FileInfos.get(i);

			fileNames[i] = FileInfo.getPath();
		}

		return fileNames;
	}

	@Override
	public long getFileSize(long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		FileInfo fileInfo = _fileInfoLocalService.getFileInfo(
			companyId, repositoryId, fileName);

		FileData fileData = _fileDataLocalService.getFileData(
			fileInfo.getFileDataId());
		
		return fileData.getSize();
	}

	@Override
	public boolean hasDirectory(
		long companyId, long repositoryId, String dirName) {

		return true;
	}

	@Override
	public boolean hasFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel)
		throws SystemException {

		return _fileInfoLocalService.hasFileInfo(
			companyId, repositoryId, fileName, versionLabel);
	}

	@Override
	public void move(String srcDir, String destDir) {
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, long newRepositoryId,
			String fileName)
		throws SystemException {

		_fileInfoLocalService.updateFileInfo(
			companyId, repositoryId, newRepositoryId, fileName, fileName);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String newFileName)
		throws SystemException {

		_fileInfoLocalService.updateFileInfo(
			companyId, repositoryId, repositoryId, fileName, newFileName);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, byte[] bytes)
		throws PortalException, SystemException {

		if (_fileInfoLocalService.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new DuplicateFileException(fileName);
		}

		_fileInfoLocalService.addFileInfo(
			companyId, repositoryId, fileName, versionLabel, 
			new UnsyncByteArrayInputStream(bytes));
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, File file)
		throws PortalException, SystemException {

		if (_fileInfoLocalService.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new DuplicateFileException(fileName);
		}

		InputStream inputStream = null;

		try {
			inputStream = new FileInputStream(file);
		}
		catch (FileNotFoundException fnfe) {
			throw new SystemException(fnfe);
		}

		_fileInfoLocalService.addFileInfo(
			companyId, repositoryId, fileName, versionLabel, inputStream);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, InputStream inputStream)
		throws PortalException, SystemException {

		if (_fileInfoLocalService.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new DuplicateFileException(fileName);
		}

		_fileInfoLocalService.addFileInfo(
				companyId, repositoryId, fileName, versionLabel, inputStream);
	}

	@Reference
	private FileDataLocalService _fileDataLocalService;
	
	@Reference
	private FileInfoLocalService _fileInfoLocalService;
	
	private static volatile BackupFriendlyFileSystemStoreConfiguration
		_backupFriendlyFileSystemStoreConfiguration;
	private static Log _log = 
		LogFactoryUtil.getLog(BackupFriendlyFileSystemStore.class);
	
}
