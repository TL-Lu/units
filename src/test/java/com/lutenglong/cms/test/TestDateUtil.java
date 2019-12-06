package com.lutenglong.cms.test;

import java.util.Date;

import org.junit.Test;

import com.lutenglong.cms.util.DateUtil;

public class TestDateUtil {
	
	@Test								//测试获取当前年龄
	public void testAge() {
		Date now = new Date();
		int age = DateUtil.getAge(now);
		System.out.println(age);
	}
	
	@Test
	public void testGetBeginOfMonth() {				//测试获取月初
		Date beginOfMonth = DateUtil.getBeginOfMonth();
		System.out.println(beginOfMonth);
	}
	
	@Test
	public void testGetRemainDays() {				//获取还剩多少天
		int days = DateUtil.getRemainDays(new Date(120,0,1));
		System.out.println(days);
	}
	@Test
	public void testIsToday() {				//测试是否当天
		boolean isToday = DateUtil.isToday(new Date(119,11,5));
		System.out.println(isToday);
	}
	
	@Test
	public void getEndOfMonth() {				//测试是否当天
		Date endOfMonth = DateUtil.getEndOfMonth();
		System.out.println(endOfMonth);
	}
}
