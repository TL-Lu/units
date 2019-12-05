package com.lutenglong.cms.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Lu'TL
 *
 */
public class StringUtil {
	/**
	 * 获取所有的大写字符以及数字
	 */
	static char charArray[] = new char[36];
	static {
		for (int i = 0; i < 10; i++) {
			charArray[i]=(char) ('0'+i);
		}
		for (int i = 0; i < 26; i++) {
			charArray[i+10]=(char) ('A'+i);
		}
	}
	
	
	/**
	 * 判断字符串是否为空
	 * @author Lu'TL
	 * @return
	 * 
	 */
	public static boolean isBlank(String str) {
		return null==str||"".equals(str.trim());
	}
	
	
	/**
	 * 
	 * 判断是否有值
	 * @param str
	 * @return
	 */
	public static boolean haveValue(String str) {
		return !(null==str||"".equals(str.trim()));
	}
	
	/**
	 * 判断是否为手机号
	 * @param str
	 * @return
	 */
	
	public static boolean isMobile(String str) {
		String regex="^1[35678]\\d{9}$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher =compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	
	/**
	 * 随机字符串不包含数字
	 * @param n
	 * @return
	 */
	public static String getRandomStr(int n) {
		Random random = new Random();
		
		StringBuilder sb = new StringBuilder();		//StringBuilder执行效率高，因为方法是在一个线程内执行，不会出现线程安全问题，因此选择执行效率高的StringBuilder
		for (int i = 0; i < n; i++) {
			char  randomChar = (char) ('a'+random.nextInt(26));
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	/**
	 * 随机字符串包含数字
	 * @param n
	 * @return
	 */
	public static String getRandomStrAndNum(int n) {
		Random random = new Random();
		StringBuilder sb = new StringBuilder();		//StringBuilder执行效率高，因为方法是在一个线程内执行，不会出现线程安全问题，因此选择执行效率高的StringBuilder
		for (int i = 0; i < n; i++) {
			char  randomChar = (char)charArray[(random.nextInt(36))];
			sb.append(randomChar);
		}
		return sb.toString();
	}
}
