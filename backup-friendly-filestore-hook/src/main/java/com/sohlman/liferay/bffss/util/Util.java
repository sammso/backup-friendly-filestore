/**
 * Copyright (c) 2015-present Sampsa Sohlman All rights reserved.
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

import com.liferay.portal.kernel.security.RandomUtil;

import java.util.UUID;

public abstract class Util {
	/**
	 * Converts the bytes to Hexadecimal String
	 */
	public static String bytesToHexString(byte[] bytes) { 
		char[] chars = new char[bytes.length * 2];
		for (int i = 0; i < bytes.length; i++) {
			int j = bytes[i] & 0xFF;
			chars[i * 2] = _charArray[j >>> 4];
			chars[i * 2 + 1] = _charArray[j & 0x0F];
		}
		return new String(chars);
	}
	
	/**
	 * Generates 16-bit number at Hexformat
	 * @return String containing random 16-bit hex value
	 */
	public static String get16BitRandomHex() {
		return prefixZero(Integer.toHexString(RandomUtil.nextInt(65535)));
	}

	/**
	 * Add's zeros to front of String, but still so that Max lenght of string is
	 * 4
	 * @return See method description
	 */	
	public static String prefixZero(String numberString) {
		numberString = 
			numberString.length() <= 4 ? numberString : numberString.substring(
				0, 4);
		
		return _ZEROS[numberString.length() - 1].concat(numberString);
	}

	/**
	 * Generates globally unique file name.
	 * @return See method description
	 */		
	public static String generateUniqName() {
		return get16BitRandomHex()
				.concat(UUID.randomUUID().toString()).replaceAll("[-]", "")
					.toUpperCase();
	}
	
	final private static String[] _ZEROS = {"000", "00", "0", "" };
	
	final private static char[] _charArray = "0123456789ABCDEF".toCharArray();
}
