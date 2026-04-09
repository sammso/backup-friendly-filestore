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
package com.sohlman.liferay.bfdms;

import java.io.InputStream;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.document.library.kernel.store.Store;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.sohlman.liferay.bfdms.model.FileData;
import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.service.FileDataLocalService;
import com.sohlman.liferay.bfdms.service.FileInfoLocalService;

/**
 * @author Sampsa Sohlman
 */
@Component(
	property = {
			"ct.aware=true",
			"store.type=com.sohlman.liferay.bfdms.BackupFriendlyFileSystemStore"
	},
	service = Store.class
)
public class BackupFriendlyFileSystemStore implements Store {

	@Override
	public void addFile(
			long companyId, long repositoryId, String fileName,
			String versionLabel, InputStream inputStream)
		throws PortalException {

		if (_fileInfoLocalService.hasFileInfo(
				companyId, repositoryId, fileName, versionLabel)) {

			throw new PortalException(
				"Duplicate file: " + repositoryId + "/" + fileName + "/" +
					versionLabel);
		}

		_fileInfoLocalService.addFileInfo(
			companyId, repositoryId, fileName, versionLabel, inputStream);
	}

	@Override
	public void deleteDirectory(
		long companyId, long repositoryId, String dirName) {

		try {
			_fileInfoLocalService.deleteFileInfosByDirectory(
				companyId, repositoryId, dirName);
		}
		catch (PortalException pe) {
			_log.error(pe);
		}
	}

	@Override
	public void deleteFile(
		long companyId, long repositoryId, String fileName,
		String versionLabel) {

		try {
			_fileInfoLocalService.deleteFileInfo(
				companyId, repositoryId, fileName, versionLabel);
		}
		catch (PortalException pe) {
			_log.error(pe);
		}
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
	public String[] getFileNames(
		long companyId, long repositoryId, String dirName) {

		List<FileInfo> fileInfos =
			_fileInfoLocalService.getFileInfosByDirectory(
				companyId, repositoryId, dirName);

		String[] fileNames = new String[fileInfos.size()];

		for (int i = 0; i < fileInfos.size(); i++) {
			fileNames[i] = fileInfos.get(i).getPath();
		}

		return fileNames;
	}

	@Override
	public long getFileSize(
			long companyId, long repositoryId, String fileName,
			String versionLabel)
		throws PortalException {

		FileInfo fileInfo = _fileInfoLocalService.getFileInfo(
			companyId, repositoryId, fileName, versionLabel);

		FileData fileData = _fileDataLocalService.getFileData(
			fileInfo.getFileDataId());

		return fileData.getSize();
	}

	@Override
	public String[] getFileVersions(
		long companyId, long repositoryId, String fileName) {

		List<FileInfo> fileInfos = _fileInfoLocalService.getFileInfos(
			companyId, repositoryId, fileName);

		String[] versions = new String[fileInfos.size()];

		for (int i = 0; i < fileInfos.size(); i++) {
			versions[i] = fileInfos.get(i).getVersion();
		}

		return versions;
	}

	@Override
	public boolean hasFile(
		long companyId, long repositoryId, String fileName,
		String versionLabel) {

		return _fileInfoLocalService.hasFileInfo(
			companyId, repositoryId, fileName, versionLabel);
	}

	@Reference
	private FileDataLocalService _fileDataLocalService;

	@Reference
	private FileInfoLocalService _fileInfoLocalService;

	private static final Log _log =
		LogFactoryUtil.getLog(BackupFriendlyFileSystemStore.class);

}
