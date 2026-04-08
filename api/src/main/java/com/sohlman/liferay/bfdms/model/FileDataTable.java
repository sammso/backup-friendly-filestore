/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bfdms.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;bfdms_FileData&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see FileData
 * @generated
 */
public class FileDataTable extends BaseTable<FileDataTable> {

	public static final FileDataTable INSTANCE = new FileDataTable();

	public final Column<FileDataTable, Long> fileDataId = createColumn(
		"fileDataId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<FileDataTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileDataTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<FileDataTable, String> name = createColumn(
		"name", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<FileDataTable, Long> size = createColumn(
		"size_", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<FileDataTable, String> fingerprint = createColumn(
		"fingerprint", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private FileDataTable() {
		super("bfdms_FileData", FileDataTable::new);
	}

}