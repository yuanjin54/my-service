package fun.yuanjin.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description 时间工具类
 * @Author yuanjin
 * @Date 2020-11-05 14:48
 * @Version 1.0
 */
public class DateUtils {

    public static final String PATTERN_00 = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_01 = "yyyy-MM-dd";
    public static final String PATTERN_02 = "yyyy.M.d";

    public static Date getNowDate() {
        return new Date();
    }

    public static String getNowString() {
        return dateToString(getNowDate());
    }

    /**
     * long转date
     *
     * @param dateLong dateLong
     * @return date
     */
    public static Date longToDate(long dateLong) {
        return new Date(dateLong);
    }

    /**
     * date转long
     *
     * @param date date
     * @return long
     */
    public static long dateToLong(Date date) {
        return date.getTime();
    }

    /**
     * string转long
     *
     * @param s       string
     * @param pattern pattern
     * @return long
     * @throws ParseException exception
     */
    public static long stringToLong(String s, String pattern) throws ParseException {
        return stringToDate(s, pattern).getTime();
    }

    /**
     * string转long
     *
     * @param s string
     * @return long
     * @throws ParseException exception
     */
    public static long stringToLong(String s) throws ParseException {
        return stringToLong(s, PATTERN_00);
    }


    /**
     * string转date
     *
     * @param str     string
     * @param pattern pattern
     * @return date
     * @throws ParseException exception
     */
    public static Date stringToDate(String str, String pattern) throws ParseException {
        return new SimpleDateFormat(pattern).parse(str);
    }

    /**
     * string转date
     *
     * @param str string
     * @return date
     * @throws ParseException exception
     */
    public static Date stringToDate(String str) throws ParseException {
        return stringToDate(str, PATTERN_00);
    }

    /**
     * date转string
     *
     * @param date    date
     * @param pattern pattern
     * @return string
     */
    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    /**
     * date转string
     *
     * @param date date
     * @return string
     */
    public static String dateToString(Date date) {
        return dateToString(date, PATTERN_00);
    }

    public static Date getNextDay(Date now) {
        // 获取日历实例
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

    public static String getNextDay(String now) throws ParseException {
        return dateToString(getNextDay(stringToDate(now, PATTERN_01)), PATTERN_01);
    }

    public static Date getLastDay(Date now) {
        // 获取日历实例
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    public static String getLastDay(String now) throws ParseException {
        return dateToString(getLastDay(stringToDate(now, PATTERN_01)), PATTERN_01);
    }

    public static String convertDay(String date, String oldPattern, String newPattern) throws ParseException {
        return dateToString(new SimpleDateFormat(oldPattern).parse(date), newPattern);
    }

    public static void main(String[] args) throws ParseException {
        System.out.println(getLastDay("2019-01-01"));
        System.out.println(convertDay("2019-01-28", PATTERN_01, PATTERN_02));
    }
}
