package com.lutenglong.cms.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		String regex="^1[3,5,6,7,8]\\d{9}$";
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
	
	
	
	/**
	 * 
	 * 判断是否为邮箱
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmail(String str) {
		String regex="^\\s*\\w+(?:\\.{0,1}[\\w-]+)*@[a-zA-Z0-9]+(?:[-.][a-zA-Z0-9]+)*\\.[a-zA-Z]+\\s*$";
		Pattern compile = Pattern.compile(regex);
		Matcher matcher =compile.matcher(str);
		boolean find = matcher.find();
		return find;
	}
	
	/**
	 * 判断是否含有数字
	 * @param str
	 * @return
	 */
	public static boolean haveNumber(String str) {
		char[] c = str.toCharArray();
		for (char d : c) {
			if(d>='0'&&d<='9') {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 验证是否是URL
	 * @param url
	 * @return
	 */
	public static boolean isHttpUrl(String str){
		 //转换为小写
        str = str.toLowerCase();
        String regex = "^((https|http|ftp|rtsp|mms)?://)"  //https、http、ftp、rtsp、mms
                + "?(([0-9a-z_!~*'().&=+$%-]+: )?[0-9a-z_!~*'().&=+$%-]+@)?" //ftp的user@  
               + "(([0-9]{1,3}\\.){3}[0-9]{1,3}" // IP形式的URL- 例如：199.194.52.184               
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "[0-9a-z]*"  // 或单域名
                 + "|" // 允许IP和DOMAIN（域名） 或单域名
                 + "([0-9a-z_!~*'()-]+\\.)*" // 域名- www.  
                 + "([0-9a-z][0-9a-z-]{0,61})?[0-9a-z]\\." // 二级域名  
                + "[a-z]{2,6})" // first level domain- .com or .museum  
                + "(:[0-9]{1,5})?" // 端口号最大为65535,5位数
                + "((/?)|" // a slash isn't required if there is no file name  
                + "(/[0-9a-z_!~*'().;?:@&=+$,%#-]+)+/?)$";  
        return  str.matches(regex);	
	}
	
	
	/**
	 * 根据经纬度计算环线
	 * @param x
	 * @param y
	 * @return
	 */
	public static int cal(int x,int y) {

		long round = Math.round(Math.sqrt(Math.pow(x-39, 2))+Math.pow(y-116, 2));
		
		if(round>=0&&round<=15) {
			return 2;
		}else if(round>15&&round<=30){
			return 3;
		}else if(round>30&&round<=40){
			return 4;
		}else if(round>40&&round<=60){
			return 5;
		}else if(round>60&&round<=70){
			return 6;
		}else {
			return 0;
		}
	}
	
	/**
	 * 计算距离
	 * @param x
	 * @param y
	 * @return
	 */
	public static long position (int x,int y) {
		return  Math.round(Math.sqrt(Math.pow(x-39, 2))+Math.pow(y-116, 2));
	}
	
	public static String  isPassyn(int week,String carId,long cal,String type) {
		String substring = carId.substring(0,1);
		String substring2 = carId.substring(6);
		if(type.equals("A")&&cal<15) {
			return carId+"进入2环";
		}
		if(type.equals("B")&&cal<40) {
			return  carId+"进入4环";
		}
		if(type.equals("C")&&cal<60&&!substring.equals("京")) {
			return  "外地车不能进入5环";
		}
		if(type.equals("C")&&substring.equals("京")) {
			if(week%2==0) {
					if(Integer.valueOf(substring2)%2!=0) {
						return "限号！";
					}
			}else {
				if(Integer.valueOf(substring2)%2==0) {
					return "限号！";
				}
			}
		}
		return "未违规";
	}
	
	
	
	
	
	
	
	
	/**
	 * 返回周几
	 * @param date
	 * @return
	 * @throws ParseException 
	 */
	public static int week(String date)  {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parse;
		try {
			parse = simpleDateFormat.parse(date);
			int date2 = parse.getDate();
			return date2-15;
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
	
	
}
