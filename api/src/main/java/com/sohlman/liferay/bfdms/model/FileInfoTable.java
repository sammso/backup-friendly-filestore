/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

/**
 * The table class for the &quot;bfdms_FileInfo&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileInfo
 * @generated
 */
public class FileInfoTable extends BaseTable<FileInfoTable> {

	public static final FileInfoTable INSTANCE = new FileInfoTable();

	public final Column<FileInfoTable, Long> fileInfoId = createColumn(
		"fileInfoId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileInfoTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileInfoTable, Long> repositoryId = createColumn(
		"repositoryId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileInfoTable, String> path = createColumn(
		"path_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileInfoTable, String> version = createColumn(
		"version", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileInfoTable, Long> fileDataId = createColumn(
		"fileDataId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);

	private FileInfoTable() {
		super("bfdms_FileInfo", FileInfoTable::new);
	}

}