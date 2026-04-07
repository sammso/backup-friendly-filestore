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
package com.sohlman.liferay.bffss.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.sohlman.liferay.bffss.model.FileData;
import com.sohlman.liferay.bffss.service.base.FileDataLocalServiceBaseImpl;
import com.sohlman.liferay.bffss.util.Util;

/**
 * The implementation of the file data local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sohlman.liferay.bffss.service.FileDataLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @author Sampsa Sohlman
 * @see com.sohlman.liferay.bffss.service.base.FileDataLocalServiceBaseImpl
 * @see com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil
 */
public class FileDataLocalServiceImpl extends FileDataLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * com.sohlman.liferay.bffss.service.FileDataLocalServiceUtil} to access the
	 * file data local service.
	 */

	public FileData addFileData(long companyId, InputStream inputStream) {
		OutputStream outputStream = null;

		File file = null;

		try {
			FileData fileData = fileDataPersistence.create(0);

			fileData.setCompanyId(companyId);
			fileData.setName(Util.generateUniqName());
			fileData.setCreateDate(new Date());

			file = getFile(fileData);

			outputStream = new FileOutputStream(file);

			int read = 0;
			byte[] bytes = new byte[1024];
			long size = 0;

			// TODO: Make fingerprint algorithm configurable.

			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);

				if (read > 0) {
					messageDigest.update(bytes, 0, read);
					size = size + read;
				}
			}

			String fingerprint = "MD5.".concat(
				Util.bytesToHexString(messageDigest.digest())).concat(".")
					.concat(String.valueOf(size));

			// There is always a chance that same file is added twice at the same
			// time and two fingerprints exist. It is an allowed condition. It is
			// better to have two same files on the filesystem than to do a file
			// name change, which would cause problems to the backup procedure.

			List<FileData> list = fileDataPersistence.findByFingerPrint(
				fingerprint);

			if (list.isEmpty()) {
				long fileDataId = counterLocalService.increment(
					FileData.class.getName());

				fileData.setFileDataId(fileDataId);
				fileData.setFingerprint(fingerprint);
				fileData = updateFileData(fileData);

				// Setting file to null prevents cleanup in finally block
				file = null;

				return fileData;
			}
			else {
				return list.get(0);
			}
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		finally {
			StreamUtil.cleanUp(false, outputStream);

			if (file != null) {
				deleteFile(companyId, file);
			}
		}
	}

	public InputStream getFileInputStream(long fileDataId)
		throws PortalException {

		FileData fileData = getFileData(fileDataId);

		return getFileInputStream(fileData);
	}

	public InputStream getFileInputStream(FileData fileData)
		throws PortalException {

		try {
			File file = getFile(fileData);

			return new FileInputStream(file);
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Called from {@link
	 * com.sohlman.liferay.bffss.BackupFriendlyFileSystemStore} on
	 * activation/modification to propagate the configured root directory.
	 */
	public static void setRootDir(File rootDir) {
		_rootDir = rootDir;
	}

	protected File getFile(FileData fileData) {
		String path1 = fileData.getName().substring(0, 2);
		String path2 = fileData.getName().substring(2, 4);

		File root = new File(getRootDir(fileData.getCompanyId()), path1);

		if (!root.exists()) {
			root.mkdirs();
		}

		root = new File(root, path2);

		if (!root.exists()) {
			root.mkdirs();
		}

		return new File(root, fileData.getName());
	}

	protected File getRootDir(long companyId) {
		if (_rootDir != null) {
			return _rootDir;
		}

		return initDefaultRootDir();
	}

	private synchronized File initDefaultRootDir() {
		if (_rootDir != null) {
			return _rootDir;
		}

		String rootDirPath = "data/document_library";

		File rootDir = new File(rootDirPath);

		if (!rootDir.isAbsolute()) {
			rootDir = new File(PropsUtil.get(PropsKeys.LIFERAY_HOME), rootDirPath);
		}

		FileUtil.mkdirs(rootDir);

		_rootDir = rootDir;

		return _rootDir;
	}

	protected void deleteFile(long companyId, File file) {
		if (file.equals(getRootDir(companyId))) {
			return;
		}

		if (file.isDirectory()) {
			if (file.list().length <= 0) {
				if (!file.delete()) {
					_log.error(
						"Could not delete directory " + file.getAbsolutePath());

					return;
				}
			}
			else {
				return;
			}
		}
		else {
			if (!file.delete()) {
				_log.error("Could not delete file " + file.getAbsolutePath());

				return;
			}
		}

		deleteFile(companyId, file.getParentFile());
	}

	private static volatile File _rootDir;

	private static final Log _log = LogFactoryUtil.getLog(
		FileDataLocalServiceImpl.class);

}
