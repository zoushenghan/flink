package com.zoush.flinkutils.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期工具类
 * @author zoushenghan
 */

public final class DateUtil {
	
	/**
	 * 增加天数
	 * 返回格式 yyyymmdd
	 * @param date
	 * @param n
	 * @return
	 */
	public static String addDays(String date, int n) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		d.add(Calendar.DAY_OF_MONTH, n);
		return new SimpleDateFormat("yyyyMMdd").format(d.getTime());
	}

	/**
	 * 根据传入的日期，对日期进行进行加、减天数
	 *
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addDays(Date date, int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		return calendar.getTime();
	}
	
	/**
	 * 增加天数
	 * 返回格式 yyyy-mm-dd
	 * @param date
	 * @param n
	 * @return
	 */
	public static String addDaysLong(String date, int n) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		d.add(Calendar.DAY_OF_MONTH, n);
		return new SimpleDateFormat("yyyy-MM-dd").format(d.getTime());
	}
	
	/**
	 * 增加月份
	 * 返回格式 yyyymmdd
	 * @param date
	 * @param n
	 * @return
	 */
	public static String addMonths(String date, int n) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		d.add(Calendar.MONTH, n);
		return new SimpleDateFormat("yyyyMMdd").format(d.getTime());
	}

	/**
	 * 根据传入的日期，对日期进行进行加、减月份
	 *
	 * @param date
	 * @param months
	 * @return
	 */
	public static Date addMonths(Date date, int months) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, months);
		return calendar.getTime();
	}
	
	/**
	 * 增加月份
	 * 返回格式 yyyy-mm-dd
	 * @param date
	 * @param n
	 * @return
	 */
	public static String addMonthsLong(String date, int n) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		d.add(Calendar.MONTH, n);
		return new SimpleDateFormat("yyyy-MM-dd").format(d.getTime());
	}

	/**
	 * 将日期格式化成指定格式字符串
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String format(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * 根据指定格式字符串转换成日期
	 *
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date parseDate(String dateStr, String pattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 指定日期当月1号
	 * 返回格式 yyyymmdd
	 * @param date
	 * @return
	 */
	public static String getMonFirstDay(String date) {
		return date.replaceAll("-", "").substring(0, 6)+"01";
	}
	
	/**
	 * 指定日期当月最后1天
	 * 返回格式 yyyymmdd
	 * @param date
	 * @return
	 */
	public static String getMonLastDay(String date) {
		return addDays(addMonths(date, 1).substring(0, 6)+"01", -1);
	}
	
	/**
	 * 今天日期
	 * 返回格式  yyyymmdd
	 * @return
	 */
	public static String getCurrDay() {
		return new SimpleDateFormat("yyyyMMdd").format(new Date());
	}
	
	/**
	 * 今天日期
	 * 返回格式  yyyy-mm-dd
	 * @return
	 */
	public static String getCurrDayLong() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}
	
	/**
	 * 昨天日期
	 * 返回格式  yyyymmdd
	 * @return
	 */
	public static String getYesterday() {
		return addDays(getCurrDay(), -1);
	}
	
	/**
	 * 昨天日期
	 * 返回格式  yyyy-mm-dd
	 * @return
	 */
	public static String getYesterdayLong() {
		return addDaysLong(getCurrDay(), -1);
	}
	
	/**
	 * 当前月份
	 * 返回格式 yyyymm
	 * @return
	 */
	public static String getCurrMonth() {
		return new SimpleDateFormat("yyyyMM").format(new Date());
	}
	
	/**
	 * 前1月
	 * 返回格式 yyyymm
	 * @return
	 */
	public static String getBef1Month() {
		return addMonths(new SimpleDateFormat("yyyyMMdd").format(new Date()), -1).substring(0, 6);
	}
	
	/**
	 * 前2月
	 * 返回格式 yyyymm
	 * @return
	 */
	public static String getBef2Month() {
		return addMonths(new SimpleDateFormat("yyyyMMdd").format(new Date()), -2).substring(0, 6);
	}
	
	/**
	 * 前3月
	 * 返回格式 yyyymm
	 * @return
	 */
	public static String getBef3Month() {
		return addMonths(new SimpleDateFormat("yyyyMMdd").format(new Date()), -3).substring(0, 6);
	}
	
	/**
	 * 当前系统时间
	 * 返回格式 yyyy-mm-dd hh:mm:ss
	 * @return
	 */
	public static String getCurrTime() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	/**
	 * 明天
	 * 返回格式 yyyymmdd
	 * @return
	 */
	public static String getTomorrow() {
		return addDays(getCurrDay(), 1);
	}

	/**
	 * 明天
	 * @return yyyy-mm-dd
	 */
	public static String getTomorrowLong() {
		return addDaysLong(getCurrDayLong(), 1);
	}
	
	/**
	 * 获取最近6周对应的起始日期和结束日期
	 * @param date yyyymmdd
	 * @return Map
	 */
	public static Map<String, String> getPre6Week(String date) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		
		int dayOfWeek=d.get(Calendar.DAY_OF_WEEK); //1,2,3,4,5,6,7分别表示周日、周一、周二、周三、周四、周五、周六
		
		int diffDays=0;
		if(dayOfWeek==1) { //如果参数是周日
			diffDays=6;
		}
		else {
			diffDays=dayOfWeek-2;
		}
		
		Map<String, String> map=new HashMap<>();
		
		//当周
		if(dayOfWeek==1) { //如果参数是周日
			map.put("w5StartDate", "2099-12-31");
			map.put("w5EndDate", "2099-12-31");
			
			d.add(Calendar.DAY_OF_MONTH, 1);
		}
		else {
			d.add(Calendar.DAY_OF_MONTH, (-1)*diffDays); //当周周一对应的日期
			
			map.put("w5StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
			map.put("w5EndDate", date.length()==10?date:date.substring(0, 4)+"-"+date.substring(4, 6)+"-"+date.substring(6, 8));
		}
		
		//第4周
		d.add(Calendar.DAY_OF_MONTH, -1);
		map.put("w4EndDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		d.add(Calendar.DAY_OF_MONTH, -6);
		map.put("w4StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		//第3周
		d.add(Calendar.DAY_OF_MONTH, -1);
		map.put("w3EndDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		d.add(Calendar.DAY_OF_MONTH, -6);
		map.put("w3StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		//第2周
		d.add(Calendar.DAY_OF_MONTH, -1);
		map.put("w2EndDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		d.add(Calendar.DAY_OF_MONTH, -6);
		map.put("w2StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		//第1周
		d.add(Calendar.DAY_OF_MONTH, -1);
		map.put("w1EndDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		d.add(Calendar.DAY_OF_MONTH, -6);
		map.put("w1StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		//第0周
		d.add(Calendar.DAY_OF_MONTH, -1);
		map.put("w0EndDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		d.add(Calendar.DAY_OF_MONTH, -6);
		map.put("w0StartDate", new SimpleDateFormat("yyyy-MM-dd").format(d.getTime()));
		
		return map;
	}
	
	/**
	 * 判断日期是否是周日
	 * @param date
	 * @return
	 */
	public static boolean isSunday(String date) {
		int year=0;
		int month=0;
		int day=0;
		
		if(date.length()==8) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(4, 6))-1;
			day=Integer.parseInt(date.substring(6, 8));
		}
		else if(date.length()==10) {
			year=Integer.parseInt(date.substring(0, 4));
			month=Integer.parseInt(date.substring(5, 7))-1;
			day=Integer.parseInt(date.substring(8, 10));
		}
		else {
			throw new RuntimeException("parameter error, date="+date);
		}
		
		GregorianCalendar d=new GregorianCalendar(year,month,day);
		
		int dayOfWeek=d.get(Calendar.DAY_OF_WEEK); //1,2,3,4,5,6,7分别表示周日、周一、周二、周三、周四、周五、周六
		
		if(dayOfWeek==1) { //如果参数是周日
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 判断日期是否是月底最后1天
	 * @param date
	 * @return
	 */
	public static boolean isMonLastDay(String date) {
		if(DateUtil.addDays(date, 1).substring(0, 6).equals(date.replaceAll("-", "").substring(0, 6))) {
			return false;
		}
		return true;
	}

	/**
	 * 获取两天后对应的时间戳
	 * @return
	 */
	public static long getAfter2Day() {
		GregorianCalendar d=new GregorianCalendar(); //当前时间
		d.add(Calendar.DAY_OF_MONTH, 2); //加2天
		return d.getTimeInMillis();
	}

	//120天后的日期
	public static long getAfter120Day() {
		GregorianCalendar d=new GregorianCalendar(); //当前时间
		d.add(Calendar.DAY_OF_MONTH, 120); //加120天
		return d.getTimeInMillis();
	}

	/**
	 * 获取1天后对应的时间戳
	 * @return
	 */
	public static long getAfter1Day() {
		GregorianCalendar d=new GregorianCalendar(); //当前时间
		d.add(Calendar.DAY_OF_MONTH, 1); //加1天
		return d.getTimeInMillis();
	}

	/**
	 * 获取下月2号0点对应的时间戳
	 * @return
	 */
	public static long getAfter1MonthSecondDayZero() {
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(addMonthsLong(getCurrDayLong(), 1).substring(0, 7)+"-02 00:00:00").getTime();
		}
		catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("translate date error");
		}
	}

	/**
	 * 转换时间戳为字符串形式日期
	 * 返回格式: yyyy-mm-dd hh:mm:ss
	 * @param timestamp
	 * @return
	 */
	public static String timestamp2String(long timestamp){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
	}

	/**
	 * 转换时间戳为日期
	 * @param timestamp
	 * @return
	 */
	public static Date timestamp2Date(long timestamp){
		return new Date(timestamp);
	}

	/**
	 * 转换字符串日期为时间戳，the number of milliseconds since January 1, 1970, 00:00:00 GMT
	 * @param date 格式: yyyy-mm-dd hh:mm:ss
	 * @return
	 */
	public static long string2Timestamp(String date){
		try {
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date).getTime();
		}
		catch (Exception e){
			e.printStackTrace();
			throw new RuntimeException("translate date error");
		}
	}

	/**
	 * 转换日期为时间戳
	 * @param date
	 * @return
	 */
	public static long date2Timestamp(Date date){
		return date.getTime();
	}
	
	public static void main(String[] args) throws ParseException {
		/*Map<String, String> map=DateUtil.getPre6Week("2019-03-31");
		for(Map.Entry<String, String> entry:map.entrySet()) {
			System.out.println(entry.getKey()+"="+entry.getValue());
		}*/
		/*long t=DateUtil.getAfter1MonthFirstDayZero();
		System.out.println(t);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(t)));*/
		//System.out.println(new GregorianCalendar().getTimeInMillis());
		//System.out.println(new Date().getTime());
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(getAfter1MonthSecondDayZero()));
		//System.out.println(timestamp2String(1566382731919L));

		System.out.println(string2Timestamp("2019-09-02 00:00:00"));
		//System.out.println(string2Timestamp("2019-12-01 00:00:00"));
		//System.out.println(string2Timestamp("2020-01-01 00:00:00"));
		//System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(new Date(1575129600000L))); //1237518660
	}
}
