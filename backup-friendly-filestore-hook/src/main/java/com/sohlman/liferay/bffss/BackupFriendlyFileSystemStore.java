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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.store.BaseStore;
import com.liferay.portlet.documentlibrary.store.Store;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.model.FileInfo;
import com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil;
import com.sohlman.liferay.bffss.service.FileInfoLocalServiceUtil;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.util.List;

/**
 * @author Shuyang Zhou
 * @author Tina Tian
 * @author Sampsa Sohlman
 */
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
			FileInfoLocalServiceUtil.deleteFileInfosByDirectory(
				companyId, repositoryId, dirName);
		} catch (PortalException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void deleteFile(long companyId, long repositoryId, String fileName)
		throws SystemException {
		
		try {
			FileInfoLocalServiceUtil.deleteFileInfos(
				companyId, repositoryId, fileName);
		} catch (PortalException e) {
			throw new SystemException(e);
		}
	}

	@Override
	public void deleteFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel)
		throws PortalException, SystemException {

		FileInfoLocalServiceUtil.deleteFileInfo(
			companyId, repositoryId, fileName, versionLabel);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName)
		throws PortalException, SystemException {

		return FileInfoLocalServiceUtil.getFileAsStream(
			companyId, repositoryId, fileName);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public InputStream getFileAsStream(
			long companyId, long repositoryId, String fileName, 
			String versionLabel)
		throws PortalException, SystemException {
		
		return FileInfoLocalServiceUtil.getFileAsStream(
				companyId, repositoryId, fileName, versionLabel);
	}

	@Override
	public String[] getFileNames(long companyId, long repositoryId)
		throws SystemException {

		List<FileInfo> FileInfos = 
			FileInfoLocalServiceUtil.getFileInfos(
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
			FileInfoLocalServiceUtil.getFileInfosByDirectory(
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

		FileInfo fileInfo = FileInfoLocalServiceUtil.getFileInfo(
			companyId, repositoryId, fileName);

		FileData fileData = FileDataLocalServiceUtil.getFileData(fileInfo.getFileDataId());
		
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

		return FileInfoLocalServiceUtil.hasFileInfo(
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

		FileInfoLocalServiceUtil.updateFileInfo(
			companyId, repositoryId, newRepositoryId, fileName, fileName);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String newFileName)
		throws SystemException {

		FileInfoLocalServiceUtil.updateFileInfo(
			companyId, repositoryId, repositoryId, fileName, newFileName);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, byte[] bytes)
		throws PortalException, SystemException {

		if (FileInfoLocalServiceUtil.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new DuplicateFileException(fileName);
		}

		FileInfoLocalServiceUtil.addFileInfo(
			companyId, repositoryId, fileName, versionLabel, bytes);
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, File file)
		throws PortalException, SystemException {

		if (FileInfoLocalServiceUtil.hasFileInfo(
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

		FileInfoLocalServiceUtil.addFileInfo(
			companyId, repositoryId, fileName, versionLabel, inputStream,
			file.length());
	}

	@Override
	public void updateFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, InputStream inputStream)
		throws PortalException, SystemException {

		if (FileInfoLocalServiceUtil.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new DuplicateFileException(fileName);
		}

		long length = -1;

		if (inputStream instanceof ByteArrayInputStream) {
			ByteArrayInputStream byteArrayInputStream =
				(ByteArrayInputStream)inputStream;

			length = byteArrayInputStream.available();
		}
		else if (inputStream instanceof FileInputStream) {
			FileInputStream fileInputStream = (FileInputStream)inputStream;

			FileChannel fileChannel = fileInputStream.getChannel();

			try {
				length = fileChannel.size();
			}
			catch (IOException ioe) {
				if (_log.isWarnEnabled()) {
					_log.warn(
						"Unable to detect file size from file channel", ioe);
				}
			}
		}
		else if (inputStream instanceof UnsyncByteArrayInputStream) {
			UnsyncByteArrayInputStream unsyncByteArrayInputStream =
				(UnsyncByteArrayInputStream)inputStream;

			length = unsyncByteArrayInputStream.available();
		}

		if (length >= 0) {
			FileInfoLocalServiceUtil.addFileInfo(
				companyId, repositoryId, fileName, versionLabel, inputStream,
				length);
		}
		else {
			if (_log.isWarnEnabled()) {
				_log.warn(
					"Unable to detect length from input stream. Reading " +
						"entire input stream into memory as a last resort.");
			}

			byte[] bytes = null;

			try {
				bytes = FileUtil.getBytes(inputStream);
			}
			catch (IOException ioe) {
				throw new SystemException(ioe);
			}

			FileInfoLocalServiceUtil.addFileInfo(
				companyId, repositoryId, fileName, versionLabel, bytes);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(BackupFriendlyFileSystemStore.class);

}
