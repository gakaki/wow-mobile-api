package com.wow.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期操作工具类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月13日 上午10:58:01 Exp $
 */
public class DateUtil {

    private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);

    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * 将unix时间戳转换为日期
     */
    public static Date convertToDate(long timestamp) {
        return new Date(timestamp);
    }

    /**
     * 格式化日期与时间
     */
    public static String formatDatetime(long timestamp) {
        return datetimeFormat.format(new Date(timestamp));
    }

    /**
     * 格式化日期
     */
    public static String formatDate(long timestamp) {
        return dateFormat.format(new Date(timestamp));
    }

    /**
     * 格式化时间
     */
    public static String formatTime(long timestamp) {
        return timeFormat.format(new Date(timestamp));
    }

    /**
     * 格式化日期与时间
     */
    public static String formatDatetime(Date timestamp) {
        if (timestamp == null) {
            return "";
        }
        return datetimeFormat.format(timestamp);
    }

    /**
     * 格式化日期
     */
    public static String formatDate(Date timestamp) {
        return dateFormat.format(timestamp);
    }

    /**
     * 格式化时间
     */
    public static String formatTime(Date timestamp) {
        return timeFormat.format(timestamp);
    }

    /**
     * 获取当前日期与时间
     */
    public static String getCurrentDatetime() {
        return datetimeFormat.format(new Date());
    }

    /**
     * 获取当前日期
     */
    public static String getCurrentDate() {
        return dateFormat.format(new Date());
    }

    /**
     * 获取当前时间
     */
    public static String getCurrentTime() {
        return timeFormat.format(new Date());
    }

    /**
     * 解析日期与时间
     */
    public static Date parseDatetime(String str) {
        Date date = null;
        try {
            date = datetimeFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd HH:mm:ss", e);
        }
        return date;
    }

    /**
     * 解析日期
     */
    public static Date parseDate(String str) {
        Date date = null;
        try {
            date = dateFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：yyyy-MM-dd", e);
        }
        return date;
    }

    /**
     * 解析时间
     */
    public static Date parseTime(String str) {
        Date date = null;
        try {
            date = timeFormat.parse(str);
        } catch (ParseException e) {
            logger.error("解析日期字符串出错！格式：HH:mm:ss", e);
        }
        return date;
    }

    /**
     * 获取当前日期
     * 
     * @return
     */
    public static Date currentDate() {
        return new Date();
    }

    /**
     * 设置日期查找范围段内的开始日期
     * 
     * @return
     */
    public static Date setBeginDate(String beginDate) {
        if (StringUtil.isEmpty(beginDate)) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(parseDate(beginDate));

        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        return calendar.getTime();
    }

    /**
     * 设置日期查找范围段内的开始日期
     * 
     * @return
     */
    public static Date setEndDate(String endDate) {
        if (StringUtil.isEmpty(endDate)) {
            return null;
        }

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(parseDate(endDate));

        calendar.set(Calendar.HOUR, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);

        return calendar.getTime();
    }

    /**
    * 判断开始日期是否大于结束日期
    * 
    * @param startDate 开始日期
    * @param endDate  结束日期
    * @return
    */
    public static boolean isLessThanOrEquals(Date startDate, Date endDate) {
        int compareValue = startDate.compareTo(endDate);

        return compareValue <= 0 ? true : false;
    }
}
