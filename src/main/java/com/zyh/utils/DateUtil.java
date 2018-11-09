package com.zyh.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil {

	public static String getCurrentTiem(){
		String time = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		time = sdf.format(date);
		return time;
	}
	
	public static String formatTime(String time) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
		Date date = sdf.parse(time);
		String result = sdf2.format(date);
		return result;
	}
	
	public static Date formatDate(String time)throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date =sdf.parse(time);
		return date;
	}
	
	public static String subYears(Date date1, Date date2) {
		long year = date1.getYear() - date2.getYear();
		return String.valueOf(year);
	}
	
	public static Date parseDate(String strDate) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat();
		dateFormat.applyPattern("yyyy-MM-dd");
		return dateFormat.parse(strDate);
	}
	
	public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
 
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
 
        int age = yearNow - yearBirth;
 
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
	}
}

