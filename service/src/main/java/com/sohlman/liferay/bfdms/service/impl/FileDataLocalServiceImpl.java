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
package com.sohlman.liferay.bfdms.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.sohlman.liferay.bfdms.model.FileData;
import com.sohlman.liferay.bfdms.model.FileInfo;
import com.sohlman.liferay.bfdms.service.base.FileDataLocalServiceBaseImpl;
import com.sohlman.liferay.bfdms.store.BinaryStore;
import com.sohlman.liferay.bfdms.store.BinaryStoreCache;
import com.sohlman.liferay.bfdms.store.FolderFile;
import com.sohlman.liferay.bfdms.store.impl.StorageNamingStrategyRegistry;
import com.sohlman.liferay.bfdms.util.Util;

import org.bouncycastle.crypto.digests.Blake3Digest;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 * @author Sampsa Sohlman
 * @see com.sohlman.liferay.bfdms.service.base.FileDataLocalServiceBaseImpl
 * @see com.sohlman.liferay.bfdms.service.FileDataLocalServiceUtil
 */
@Component(
	property = "model.class.name=com.sohlman.liferay.bfdms.model.FileData",
	service = AopService.class
)
public class FileDataLocalServiceImpl extends FileDataLocalServiceBaseImpl {

	public FileData addFileData(FileInfo fileInfo, InputStream inputStream) {
		long companyId = fileInfo.getCompanyId();

		File tempFile = null;
		OutputStream outputStream = null;

		try {
			tempFile = File.createTempFile("bfdms", null);
			outputStream = new FileOutputStream(tempFile);

			int read = 0;
			byte[] bytes = new byte[8192];
			long size = 0;

			Blake3Digest digest = new Blake3Digest(32);

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
				digest.update(bytes, 0, read);
				size += read;
			}

			StreamUtil.cleanUp(false, outputStream);
			outputStream = null;

			byte[] hash = new byte[32];
			digest.doFinal(hash, 0);
			String fingerprint =
				"BLAKE3." + Util.bytesToHexString(hash) + "." + size;

			// There is always a chance that the same file is added twice at the
			// same time and two fingerprints exist. It is an allowed condition.
			// It is better to have two copies than to coordinate a rename, which
			// would cause problems for the backup procedure.

			List<FileData> list = fileDataPersistence.findByFingerPrint(
				fingerprint);

			if (!list.isEmpty()) {
				return list.get(0);
			}
			FolderFile folderFile = _namingStrategyRegistry.generate(
				fileInfo, fingerprint);

			long fileDataId = counterLocalService.increment(
				FileData.class.getName());

			FileData fileData = fileDataPersistence.create(fileDataId);

			fileData.setCompanyId(companyId);
			fileData.setName(folderFile.getName());
			fileData.setCreateDate(new Date());
			fileData.setSize(size);
			fileData.setFingerprint(fingerprint);

			try (InputStream tempStream = new FileInputStream(tempFile)) {
				_binaryStore.store(companyId, folderFile.getPath(), tempStream);
			}

			fileData = updateFileData(fileData);

			tempFile.delete();
			tempFile = null;

			return fileData;
		}
		catch (IOException e) {
			throw new RuntimeException(e);
		}
		finally {
			StreamUtil.cleanUp(false, outputStream);

			if (tempFile != null) {
				tempFile.delete();
			}
		}
	}

	public InputStream getFileInputStream(long fileDataId)
		throws PortalException {

		return getFileInputStream(getFileData(fileDataId));
	}

	public InputStream getFileInputStream(FileData fileData)
		throws PortalException {

		String path = _namingStrategyRegistry.resolvePath(
			fileData.getName(), fileData.getFingerprint());

		long companyId = fileData.getCompanyId();

		try {
			InputStream cached = _binaryStoreCache.get(companyId, path);

			if (cached != null) {
				return cached;
			}

			return _binaryStoreCache.wrap(
				companyId, path, _binaryStore.retrieve(companyId, path));
		}
		catch (IOException e) {
			throw new PortalException(e);
		}
	}

	@Reference
	private volatile BinaryStoreCache _binaryStoreCache;

	@Reference
	private volatile BinaryStore _binaryStore;

	@Reference
	private volatile StorageNamingStrategyRegistry _namingStrategyRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		FileDataLocalServiceImpl.class);

}
