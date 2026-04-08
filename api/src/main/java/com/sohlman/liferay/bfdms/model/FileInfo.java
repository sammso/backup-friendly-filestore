/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FileInfo service. Represents a row in the &quot;bfdms_FileInfo&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfoModel
 * @generated
 */
@ImplementationClassName("com.sohlman.liferay.bfdms.model.impl.FileInfoImpl")
@ProviderType
public interface FileInfo extends FileInfoModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sohlman.liferay.bfdms.model.impl.FileInfoImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FileInfo, Long> FILE_INFO_ID_ACCESSOR =
		new Accessor<FileInfo, Long>() {

			@Override
			public Long get(FileInfo fileInfo) {
				return fileInfo.getFileInfoId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FileInfo> getTypeClass() {
				return FileInfo.class;
			}

		};

}