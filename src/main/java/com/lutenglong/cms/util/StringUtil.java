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
	 * 获取所有的大写字符以及数字，放到数组里
	 */
	static char charArray[] = new char[36];
	static {
		for (int i = 0; i < 10; i++) {
			charArray[i]=(char) ('0'+i);					//添加数字到数组中	
		}
		for (int i = 0; i < 26; i++) {
			charArray[i+10]=(char) ('A'+i);			//添加大写字母到数组中
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
		Random random = new Random();				//获取随机数字
		
		StringBuilder sb = new StringBuilder();		//	StringBuilder执行效率高，因为方法是在一个线程内执行，不会出现线程安全问题，因此选择执行效率高的StringBuilder
		for (int i = 0; i < n; i++) {																	//循环n次，获取n次随机字母
			char  randomChar = (char) ('a'+random.nextInt(26));			//随机数定义范围，用ASCII码来表示字母
			sb.append(randomChar);																//把字母添加到StringBuilder中
		}
		return sb.toString();											//返回StringBuilder中的值
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
			char  randomChar = (char)charArray[(random.nextInt(36))];						//随机获取到的数字作为数组的下标，把数组中的字符取出来存放在StringBuilder中
			sb.append(randomChar);																			
		}
		return sb.toString();
	}
}
