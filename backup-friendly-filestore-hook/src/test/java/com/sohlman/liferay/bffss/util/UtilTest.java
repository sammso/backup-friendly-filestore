package com.sohlman.liferay.bffss.util;

import org.junit.Assert;
import org.junit.Test;


public class UtilTest {
	@Test
	public void testPrefixZero() {
		Assert.assertEquals("000A", Util.prefixZero("A"));
		Assert.assertEquals("00AA", Util.prefixZero("AA"));
		Assert.assertEquals("0AAA", Util.prefixZero("AAA"));
		Assert.assertEquals("AAAA", Util.prefixZero("AAAA"));
		Assert.assertEquals("AAAA", Util.prefixZero("AAAAA"));
	}
	
	
	public void testGenerateName() {
		for(int i=0; i<10 ; i++) {
			System.out.println(Util.generateUniqName());
		}
	}
}
