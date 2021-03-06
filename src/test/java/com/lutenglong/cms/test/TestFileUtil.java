package com.lutenglong.cms.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.lutenglong.cms.util.FileUtil;

/**
 * 测试文件的工具类
 * @author Lu'TL
 *
 */
public class TestFileUtil {
	
	@Test
	public void testGetSuffix() {
		
		String suffix = FileUtil.getSuffixName("D:\\program\\nodejs\\node_cache\\anonymous-cli-metrics.json");
		System.out.println("suffix = " + suffix);
		
	}
	
	@Test
	public void testDelFile() {
		FileUtil.delFile("D:\\mvntest - 副本zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz	");
	}
	
	@Test
	public void testGetpro() {
		FileUtil.getProperty("");
		
	}
	
	
	@Test 
	public void testGetEvn() {
		System.out.println( "java_home is " +  FileUtil.getEnv("JAVA_HOME"));
	}
	
	
	@Test
	public void testCompare() throws FileNotFoundException, IOException {
		System.out.println("比较开始");
		FileUtil.comparePath("D:\\project\\07b", "D:\\project\\07b - 副本");
		System.out.println("比较结束");
	}
	
	/*
	 * @Test public void testReadLines() throws IOException {
	 * 
	 * List<String> lines = FileUtil.readByLines("D:\\project\\07b - 副本\\" +
	 * "src\\main\\java\\test\\com\\zhu" + "zg\\unit15\\TestJoinTest.java");
	 * 
	 * lines.forEach(x->{System.out.println(" x is " + x);}); }
	 */
	
	
	/*
	 * @Test public void testCopy() throws IOException { String
	 * src="D:\\project\\07b\\07b.zip"; String dst="D:\\project\\07b\\07b2.zip"; }
	 */
	
	
	
}