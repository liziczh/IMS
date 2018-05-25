package com.liziczh.ims.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
	/**
	 * 获取当前年
	 * @return
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	
	/**
	 * 获取今年第一天
	 * @param str
	 * @return
	 */
	public static String firstdayByYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year + "-01-01";
	}
	
	/**
	 * 获取今年最后一天
	 * @param str
	 * @return
	 */
	public static String lastdayByYear() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		return year + "-12-31";
	}	
	
	/**
	 * 把字符串转换成java.sql.Date
	 * @param str
	 * @return
	 */
	public static java.sql.Date toSQLDate(String str) {
		return new java.sql.Date(string2Date(str).getTime());
	}
	
	/**
	 * 获取当前时间表示的字符串
	 * @return
	 */
	public static String today() {
		return date2String(new java.util.Date());
	}
	
	/**
	 * 把Date类型转换成字符串类型
	 * @param date
	 * @return
	 */
	public static String date2String(java.util.Date date) {
		return String.format("%tF", date);
	}
	
	/**
	 * 把字符串类型转换成Date类型
	 * @param str
	 * @return
	 */
	public static java.util.Date string2Date(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			throw new RuntimeException("日期字符格式错误：" + str);
		}
	}
	
	/**
	 * 返回本月第一天
	 * @return
	 */
	public static java.util.Date getFirstDayOfMethod() {
		Calendar c = Calendar.getInstance();//获取当前日期对象
		c.set(Calendar.DAY_OF_MONTH, 1);//设置日期为1
		return c.getTime();
	}
	/**
	 * 返回本月最后一天
	 * @return
	 */
	public static java.util.Date getLastDayOfMethod() {
		Calendar c = Calendar.getInstance();//获取当前日期对象
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));//设置日期为1
		return c.getTime();
	}
}
