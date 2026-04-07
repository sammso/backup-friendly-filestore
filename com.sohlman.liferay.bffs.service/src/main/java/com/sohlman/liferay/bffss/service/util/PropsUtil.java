/**
 * SPDX-FileCopyrightText: (c) 2026 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.sohlman.liferay.bffss.service.util;

import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.configuration.ConfigurationFactoryUtil;
import com.liferay.portal.kernel.configuration.Filter;

import java.util.Properties;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PropsUtil {

	public static boolean contains(String key) {
		return _instance._configuration.contains(key);
	}

	public static String get(String key) {
		return _instance._configuration.get(key);
	}

	public static String get(String key, Filter filter) {
		return _instance._configuration.get(key, filter);
	}

	public static String[] getArray(String key) {
		return _instance._configuration.getArray(key);
	}

	public static String[] getArray(String key, Filter filter) {
		return _instance._configuration.getArray(key, filter);
	}

	public static Properties getProperties() {
		return _instance._configuration.getProperties();
	}

	public static void set(String key, String value) {
		_instance._configuration.set(key, value);
	}

	private PropsUtil() {
		_configuration = ConfigurationFactoryUtil.getConfiguration(
			getClass().getClassLoader(), "service");
	}

	private static PropsUtil _instance = new PropsUtil();

	private Configuration _configuration;

}