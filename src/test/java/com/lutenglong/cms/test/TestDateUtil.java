package com.lutenglong.cms.test;

import java.util.Date;

import org.junit.Test;

import com.lutenglong.cms.util.DateUtil;

public class TestDateUtil {
	
	@Test
	public void testAge() {
		Date now = new Date();
		int age = DateUtil.getAge(now);
		System.out.println(age);
	}
}
