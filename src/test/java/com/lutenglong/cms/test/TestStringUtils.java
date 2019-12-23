package com.lutenglong.cms.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.lutenglong.cms.util.StringUtil;

public class TestStringUtils {
	
	static StringUtil stringUtil;
	
	@BeforeClass
	public static void init() {
		 stringUtil= new StringUtil();
		 
	}
	
	
	@Test
	public void testIsBlank() {
		boolean blank = StringUtil.isBlank("11");
		System.out.println("blank is "+blank);
		Assert.assertTrue(blank==false);
		
	}
	@Test
	public void testIsBlank2() {
		boolean blank = StringUtil.isBlank("   ");
		System.out.println("blank is "+blank);
		Assert.assertTrue(blank==true);
	}
	
	@Test
	public void testisMobile() {
		String mobile = "13525255555";
		Assert.assertTrue("错误一",  StringUtil.isMobile(mobile));
	}
	@Test
	public void testgetRandomStr() {
		String randomStr = StringUtil.getRandomStr(20);
		System.out.println("randomStr is"+randomStr);
		Assert.assertTrue(randomStr.length()==20);
	}
	
	@Test
	public void testgetRandomStrAndNum() {
		String randomStrAndNum = StringUtil.getRandomStrAndNum(15);
		System.out.println("randomStr is"+randomStrAndNum);
		Assert.assertTrue(randomStrAndNum.length()==15);
	}
	
	@Test
	public void testRandomJianHan() throws Exception {
		String randomStr = StringUtil.randomJianHan(2);
		System.out.println(randomStr);
	}
	@Test
	public void testIsEmail(){
		boolean email = StringUtil.isEmail("w123@163.com");
		System.out.println(email);
	}
	
	
	@Test
	public  void testhaveNumber() {
		boolean haveNumber = StringUtil.haveNumber("a1");
		System.out.println(haveNumber);
	}
}
