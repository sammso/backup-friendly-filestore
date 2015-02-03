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
package com.sohlman.liferay.bffss.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sohlman.liferay.bffss.model.FileInfo;

/**
 * @author Shuyang Zhou
 * @author Sampsa Sohlman
 */
public class FileInfoVersionComparator extends OrderByComparator {


	public static final String ORDER_BY_ASC = "FileInfo.version ASC";

	public static final String ORDER_BY_DESC = "FileInfo.version DESC";

	public static final String[] ORDER_BY_FIELDS = {"version"};

	public FileInfoVersionComparator() {
		this(false);
	}

	public FileInfoVersionComparator(boolean ascending) {
		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {
		FileInfo fileInfo1 = (FileInfo)obj1;
		FileInfo fileInfo2 = (FileInfo)obj2;

		String version1 = fileInfo1.getVersion();
		String version2 = fileInfo2.getVersion();

		int value = version1.compareTo(version2);

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {
		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {
		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {
		return _ascending;
	}

	private boolean _ascending;

}
