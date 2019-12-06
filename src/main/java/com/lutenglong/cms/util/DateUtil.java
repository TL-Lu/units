package com.lutenglong.cms.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
		
	static final int millSecondsPerDay = 3600*24*1000;
	
	
	
	
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
		instance.setTime(birthday);				//获取出生的年月日
		int year = instance.get(Calendar.YEAR);			
		int month = instance.get(Calendar.MONTH);	
		int day = instance.get(Calendar.DATE);				
		
		
		instance.setTime(new Date());
		int currentYear = instance.get(Calendar.YEAR);			//获取当前的年月日
		int currentMonth = instance.get(Calendar.MONTH);
		int currentDay = instance.get(Calendar.DATE);
		
		int age  = currentYear-year;								//当前年份减去出生的年份
		if(currentMonth<month) {							//判断当前月份是否小于出生的月份，如果小于出生月份代表要小一岁
			age--;
		}else if(currentMonth==month&&currentDay<day) {		//判断月份相等时，当前的时间是否小于出生的时间
			age--;
		}
		return age;
	}
	
	/**
	 * 获取剩余多少天
	 * 
	 * Get the remaining days
	 * 
	 * @param future
	 * @return 返回剩余的天数
	 */
	public static int getRemainDays(Date future) {
		return (int) ((future.getTime()-new Date().getTime())/millSecondsPerDay);	//获取将来的时间 再获取当前时间 相减 除以一天的秒数
	}

	/**
	 * 判断是否为当天
	 * 
	 * Determine if it is the same day
	 * 
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");				//格式化传来的时间
		String format = simpleDateFormat.format(date);						
		String current = simpleDateFormat.format(new Date());													//格式化当前时间
		
		return format.equals(current);
	}
	
	
	/**
	 * 获取当月的月初
	 * 
	 * Gets the beginning of the month
	 * 
	 * @return
	 */
	public static Date  getBeginOfMonth() {
		//获取日历的实例
		Calendar instance = Calendar.getInstance();	
		
		//设置当前时间
		instance.setTime(new Date());
		
		//初始化秒
		instance.set(Calendar.SECOND, 0);
		
		//初始化分钟
		instance.set(Calendar.MINUTE, 0);
		
		//初始化小时
		instance.set(Calendar.HOUR, 0);
		
		//初始化天
		instance.set(Calendar.DATE, 1);
		
		//初始化上午下午
		instance.set(Calendar.AM_PM,Calendar.AM);
		
		//返回当前月初
		return instance.getTime();
	}
	
	
	
	public static Date getEndOfMonth() {
		Calendar instance = Calendar.getInstance();
		
		instance.setTime(new Date());
		instance.add(Calendar.MONTH, 1);
		
		//初始化秒
		instance.set(Calendar.SECOND, 0);
		
		//初始化分钟
		instance.set(Calendar.MINUTE, 0);
		
		//初始化小时
		instance.set(Calendar.HOUR, 0);
		
		//初始化天
		instance.set(Calendar.DATE, 1);
		
		//初始化上午下午
		instance.set(Calendar.AM_PM,Calendar.AM);
		
		instance.add(Calendar.SECOND, -1);
		
		return instance.getTime();
	}
	/**
	 * 
	 * @param date
	 * @return
	 */
	public static boolean  isThisWeek(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		Calendar firstDayOfWeek = Calendar.getInstance(Locale.getDefault());

		firstDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		int day = firstDayOfWeek.get(Calendar.DAY_OF_WEEK);

		firstDayOfWeek.add(Calendar.DATE, -day+1+1);// 后面的+1是因为从周日开始

		// 本周一的日期

		System.out.println(format.format(firstDayOfWeek.getTime()));

		Calendar lastDayOfWeek = Calendar.getInstance(Locale.getDefault());

		lastDayOfWeek.setFirstDayOfWeek(Calendar.MONDAY);

		day = lastDayOfWeek.get(Calendar.DAY_OF_WEEK);

		lastDayOfWeek.add(Calendar.DATE, 7-day+1);

		// 本周星期天的日期

		System.out.println(format.format(lastDayOfWeek.getTime()));
		
		return (date.getTime()<lastDayOfWeek.getTime().getTime() &&
				date.getTime()>firstDayOfWeek.getTime().getTime() );

	}
}