package com.fc.v2.util;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * 日期处理
 * @ClassName: DateUtils
 * 
 * @date 2019-06-23 00:53
 * @version V1.0
 */
public class DateUtils  extends org.apache.commons.lang3.time.DateUtils{
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }
	/**
	 * 时间转换
	 * @param date
	 * @param pattern
	 * @return
	 */
    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }
    
    
    
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     * 
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }

    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + " D " + hour + " H " + min + " M";
    }
    public static Date parseTradeMeDate(String tradeMeString) {
    	Date tradeMeDate=null;
    	if (tradeMeString!=null&& (tradeMeString.endsWith("am")||tradeMeString.endsWith("pm"))) {
    		/*input Demo
    		 * Tue 31st Aug, 8:00pm
    		//2:4 days, 23 hours, 19 minutes
    		//Thu 26th Aug, 10:35am
    		//Thu 2nd Sep, 8:00pm
    		//6 days, 23 hours, 19 minutes
    		*/
    		//1.去除掉日期的后缀。
    		tradeMeString =tradeMeString.substring(tradeMeString.indexOf(" ")+1);
    		tradeMeString=tradeMeString.replace("nd", "").replace("st", "").replace("th", "").replace("rd", "");
//    		tradeMeString=tradeMeString.replace("st", "");
//    		tradeMeString=tradeMeString.replace("th", "");
    		String APM="";
    		if(tradeMeString.endsWith("am")) {
    			tradeMeString=tradeMeString.replace("am", "");
    			APM="am";
    		}else if(tradeMeString.endsWith("pm")) {
    			tradeMeString=tradeMeString.replace("pm", "");
    			APM="pm";
    		}
    		
    		
    		System.out.println(tradeMeString);
    		
    		
    		
    		
    		tradeMeDate=  DateUtils.dateTime("dd MMM, HH:mm", tradeMeString);
    		
    		Calendar calender = Calendar.getInstance();
    		calender.setTime(tradeMeDate);
    		calender.set(Calendar.YEAR, Calendar.getInstance().get(Calendar.YEAR));
    		 
    		 
    		
    		if(APM.equals("pm")) {    		 
    			calender.add(Calendar.HOUR, 12);
    		}
    		
    		
    		if (calender.before(Calendar.getInstance())&&calender.get(Calendar.MONTH)==0&&Calendar.getInstance().get(Calendar.MONTH)==11) {
    			calender.add(Calendar.YEAR,1);
			}
    		
    	 System.out.println(calender.get(Calendar.MONTH));
    		
    		tradeMeDate= calender.getTime();
    		System.out.println("-------"+format(tradeMeDate,DATE_TIME_PATTERN));
    		
    	}
     
    	return tradeMeDate;
    	
    }
    
}
