package com.sip.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static final String formatting1 = "yyyy-MM-dd";
	
	private static final String formatting2 = "yyyy-MM-dd HH:mm:ss";
	
	private static final String formatting3 = "yyyyMMddHHmmssSSS";
	
	/**
	 * 获取当前时间
	 * @return 返回字符串短时间格式 yyyy-MM-dd
	 */
	public static String getNowDateShort(){
		SimpleDateFormat formatter = new SimpleDateFormat(formatting1);
		String dateString = formatter.format(new Date());
		return dateString;
		
	}
	
	/**
	 * 获取当前时间
	 * @return 返回字符串格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate(){
		SimpleDateFormat formatter = new SimpleDateFormat(formatting2);
		String dateString = formatter.format(new Date());
		return dateString;
		
	}
	
	/**
     * 获取现在时间
     *
     * @return 返回字符串格式 yyyyMMddHHmmss
     */
    public static String getStringAllDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("formatting3");
        String dateString = formatter.format(new Date());
        return dateString;
    }
    
    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String dateToStrLong(java.util.Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("formatting2");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     *
     * @param dateDate
     * @param
     * @return
     */
    public static String dateToStr(java.util.Date dateDate) {
    	SimpleDateFormat formatter = new SimpleDateFormat("formatting1");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

}
