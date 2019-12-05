package com.lutenglong.cms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * 关于日期的工具类
 * 
 * Tool class for dates
 * 
 * @author Lu'TL
 *
 */
public class DateUtil {
		
	static final int millSecondsPerDay = 3600*24;
	
	
	
	
	/**
	 * 
	 * 计算年龄
	 * 
	 * Calculate the age
	 * 
	 * @param birthday
	 * @return 返回年龄
	 */
	public static int getAge(Date birthday) {
		
		Calendar instance = Calendar.getInstance();
		
		//计算出生的年月日
		instance.setTime(birthday);
		int year = instance.get(Calendar.YEAR);
		int month = instance.get(Calendar.MONTH);
		int day = instance.get(Calendar.DATE);
		
		
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDay = instance.get(Calendar.DATE);
		
		int age  = currentYear-year;
		if(currentMonth<month) {
			age--;
		}else if(currentMonth==month&&currentDay<day) {
			age--;
		}
		return age;
	}
	
	/**
	 * 获取剩余多少天
	 * 
	 * @param future
	 * @return
	 */
	public static int getRemainDays(Date future) {
		return (int) ((future.getTime()-new Date().getTime())/millSecondsPerDay);
	}

	/**
	 * 判断是否为当天
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		String current = simpleDateFormat.format(new Date());
		
		return format.equals(current);
	}
	
	
	/**
	 * 获取当月的月初
	 * @return
	 */
	public static Date  getBeginOfMonth() {
		//获取日历的实例
		Calendar instance = Calendar.getInstance();
		instance.setTime(new Date());
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.DATE, 1);
		instance.set(Calendar.AM_PM,Calendar.AM);
		
		return instance.getTime();
	}
}