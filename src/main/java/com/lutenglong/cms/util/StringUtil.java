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
	 * 
	 * Get all the uppercase characters and Numbers and put them in the array
	 * 
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
	 * 
	 * Determines if the string is empty
	 * 
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
	 * 
	 * Determine if there is a value
	 * 
	 * @param str
	 * @return
	 */
	public static boolean haveValue(String str) {
		return !(null==str||"".equals(str.trim()));
	}
	
	/**
	 * 判断是否为数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		String regex="^\\d+$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher =compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	
	
	
	
	/**
	 * 判断是否为手机号
	 * 
	 * Determine if it is a mobile phone number
	 * 
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
	 * 
	 * Random strings don't contain number
	 * 
	 * 
	 * 使用StringBuilder效率比String和StringBuffer要高，函数只在一个线程中执行，不会触发线程安全问题，所以本次使用StringBuilder是最合适的
	 * 
	 * StringBuilder is more efficient than String and StringBuffer, and the function only 
	 * executes in one thread without triggering thread-safety issues, so StringBuilder is best used this time
	 * 
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
	 * Random strings contain number
	 * 
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
	
	
	
	/**
	 * 
	 * @param len
	 * @return	返回随机获取的汉字字符串
	 * @throws Exception
	 */
	public static String randomJianHan(int len) throws Exception {
		String ret = "";
		for (int i = 0; i < len; i++) {
				
				Random random = new Random();		
				
				byte[] b = new byte[2];				
				
				b[0] =  (byte) (0xA1+0x10+ random.nextInt(36)); // 获取高位值	
				
				b[1] = (byte) (0xA1+ random.nextInt(94)); 	// 获取高位值	
						
				String 	str = new String(b, "GBK"); 						//		转成中文
				
				ret += str;
			}
				return ret;
	}
}
