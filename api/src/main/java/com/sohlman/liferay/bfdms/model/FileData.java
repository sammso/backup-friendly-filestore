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
 * The extended model interface for the FileData service. Represents a row in the &quot;bfdms_FileData&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see FileDataModel
 * @generated
 */
@ImplementationClassName("com.sohlman.liferay.bfdms.model.impl.FileDataImpl")
@ProviderType
public interface FileData extends FileDataModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.sohlman.liferay.bfdms.model.impl.FileDataImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FileData, Long> FILE_DATA_ID_ACCESSOR =
		new Accessor<FileData, Long>() {

			@Override
			public Long get(FileData fileData) {
				return fileData.getFileDataId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<FileData> getTypeClass() {
				return FileData.class;
			}

		};

}