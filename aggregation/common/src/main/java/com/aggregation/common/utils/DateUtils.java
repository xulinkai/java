package com.aggregation.common.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * 日期utils
 *
 * @author liyingjie
 */
public class DateUtils {
    public final static String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public final static String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public final static String FORMAT_YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    // 北京时间时区
    private static TimeZone TIMEZONE = TimeZone.getTimeZone("GMT+8");

    private DateUtils() {
    }

    /**
     * 获取当前时间的毫秒精度
     *
     * @return yyyy-MM-dd HH:mm:ss.SSS格式
     */
    public static String currentTimeMillis() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS_SSS);
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间的秒精度
     *
     * @return yyyy-MM-dd HH:mm:ss格式
     */
    public static String currentTimeSecond() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        return sdf.format(new Date());
    }

    /**
     * 获取当前时间的日精度
     *
     * @return yyyy-MM-dd HH:mm:ss格式
     */
    public static String currentTimeDay() {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        return sdf.format(new Date());
    }

    /**
     * @Desc dayFormat
     */
    public static String dayFormat(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        return sdf.format(date);
    }

    public static String format(Date date, String format) {
        Preconditions.checkArgument(date != null, "Param date must be not null");
        Preconditions.checkArgument(StringUtils.isNotBlank(format), "Param format must be not null or empty");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String defaultFormat(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        return sdf.format(date);
    }

    public static String defaultFormat1(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        return sdf.format(date);
    }

    public static Date formatDateShort(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        ParsePosition pos = new ParsePosition(8);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    public static Date parse(String date, String format) {
        Preconditions.checkArgument(StringUtils.isNotBlank(date), "Param date must be not null");
        Preconditions.checkArgument(StringUtils.isNotBlank(format), "Param format must be not null or empty");
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * 比较两个Date日期大小
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return 1表示date1大于date2, 0表示date1和date2的日期完全相等,-1表示date1小于date2
     */
    public static int compare(Date date1, Date date2) {
        Preconditions.checkArgument(date1 != null, "Param date1 must be not null");
        Preconditions.checkArgument(date2 != null, "Param date2 must be not null");

        if (date1.after(date2)) {
            return 1;
        } else if (date1.before(date2)) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * 计算两个日期之间相差的月份
     *
     * @param date1
     * @param date2
     * @return 如果是同一月返回0，如果date1小于date2返回正数，否则返回负数
     */
    public static int calculateDiffMonth(String date1, String date2) {
        return calculateDiff(date1, date2, DiffType.MONTH);
    }

    /**
     * 计算两个日期之间相差的年
     *
     * @param date1
     * @param date2
     * @return 如果是同一年返回0，如果date1小于date2返回正数，否则返回负数
     */
    public static int calculateDiffYear(String date1, String date2) {
        return calculateDiff(date1, date2, DiffType.YEAR);
    }

    /**
     * @Desc
     * @created by xlk on 2022/4/21 19:51
     */
    public static int dayDiff(Date fDate, Date oDate) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YYYY_MM_DD);
        return calculateDiffDay(sdf.format(fDate), sdf.format(oDate));
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1
     * @param date2
     * @return 如果是同一天返回0，如果date1小于date2返回正数，否则返回负数
     */
    public static int calculateDiffDay(String date1, String date2) {
        return calculateDiff(date1, date2, DiffType.DAY);
    }

    enum DiffType {
        DAY, MONTH, YEAR
    }

    /**
     * 计算两个日期之间相差的天数
     *
     * @param date1    需要比较的时间
     * @param date2    被比较的时间
     * @param diffType
     * @return 如果两个日期比对的数值相同，则返回0，如果date1小于date2返回正数，否则返回负数
     */
    private static int calculateDiff(String date1, String date2, DiffType diffType) {
        Preconditions.checkArgument(StringUtils.isNotBlank(date1), "Param date1 must be not null");
        Preconditions.checkArgument(StringUtils.isNotBlank(date2), "Param date2 must be not null");

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(parse(date1, FORMAT_YYYY_MM_DD));
        c2.setTime(parse(date2, FORMAT_YYYY_MM_DD));

        //日期相同
        if (diffType == DiffType.DAY && c1.compareTo(c2) == 0) {
            return 0;
        }

        //同一年，月份相同
        if (diffType == DiffType.MONTH && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH)) {
            return 0;
        }

        //同一年
        if (diffType == DiffType.YEAR && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
            return 0;
        }

        Calendar min = c1.before(c2) ? c1 : c2;
        Calendar max = c1.before(c2) ? c2 : c1;

        //正负标识
        boolean flag = c1.before(c2);

        int n = 0;
        while (min.before(max)) {
            if (DiffType.DAY == diffType) {
                min.add(Calendar.DATE, 1);
            } else if (DiffType.MONTH == diffType) {
                min.add(Calendar.MONTH, 1);
            } else {
                min.add(Calendar.YEAR, 1);
            }
            n++;
        }
        return flag ? n : -n;
    }

    public static Date addYear(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.YEAR, n);
        date = calendar.getTime();
        return date;
    }

    public static Date addMonth(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, n);
        date = calendar.getTime();
        return date;
    }


    /**
     * 将日期+n天  整数往后推,负数往前移动
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addDay(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE, n);//把日期往后增加n天.整数往后推,负数往前移动
        date = calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }

    /**
     * @Desc 获取 getAfterDayStr
     */
    public static String getAfterDayStr(Date date, int afterDay) {
        return new SimpleDateFormat(FORMAT_YYYY_MM_DD).format(addDay(date, afterDay));
    }

    public static String getAfterDayStr(int afterDay) {
        return getAfterDayStr(new Date(), afterDay);
    }

    /**
     * 将日期+n小时  整数往后推,负数往前移动
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addHour(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.HOUR, n);//把日期往后增加n小时.整数往后推,负数往前移动
        date = calendar.getTime();   //这个时间就是日期往后推n小时的结果
        return date;
    }

    /**
     * 将日期+n分钟  整数往后推,负数往前移动
     *
     * @param date
     * @param n
     * @return
     */
    public static Date addMinute(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.MINUTE, n);//把日期往后增加n分钟.整数往后推,负数往前移动
        date = calendar.getTime();   //这个时间就是日期往后推n分钟的结果
        return date;
    }

    public static Date addSecond(Date date, int n) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.SECOND, n);//把日期往后增加n分钟.整数往后推,负数往前移动
        date = calendar.getTime();   //这个时间就是日期往后推n分钟的结果
        return date;
    }


    /**
     * 得到当前系统日期
     *
     * @return 得到系统当前日期
     */
    public static Date getCurrentDate() {
        return new Date(System.currentTimeMillis());
    }


    /**
     * 格式化Date日期为 20160415112036 格式
     *
     * @param date 日期
     * @return long
     */
    public static long format2Long(Date date) {
        return format2Long(date, false);
    }

    public static String format2String(Date date) {
        return String.valueOf(format2Long(date));
    }

    /**
     * 格式化Date日期为 20160415112036 格式 或 20160415112036007 格式
     *
     * @param date           日期
     * @param hasMillisecond 是否包含毫秒
     * @return long
     */
    public static long format2Long(Date date, boolean hasMillisecond) {
        Calendar calendar = Calendar.getInstance(TIMEZONE);
        calendar.setTime(date);
        String year = String.format("%04d", calendar.get(Calendar.YEAR));
        String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        String day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        String hour = String.format("%02d", calendar.get(Calendar.HOUR_OF_DAY));
        String minute = String.format("%02d", calendar.get(Calendar.MINUTE));
        String second = String.format("%02d", calendar.get(Calendar.SECOND));
        String str = year + month + day + hour + minute + second;
        if (hasMillisecond) {
            String millisecond = String.format("%03d", calendar.get(Calendar.MILLISECOND));
            str = str.concat(millisecond);
        }
        return Long.parseLong(str);
    }


    public static boolean compareHour(Date d1, Date d2) {
        long dd1 = Long.parseLong(format2String(d1).substring(8));
        long dd2 = Long.parseLong(format2String(d2).substring(8));
        return dd1 - dd2 >= 0;
    }

    public static boolean compareStrHour(Date d1, String d2) {
        try {
            long dd1 = Long.parseLong(format2String(d1).substring(8));
            long dd2 = Long.parseLong(d2.replaceAll(":", "") + "00");
            return dd1 - dd2 >= 0;
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 格式化Date日期为 20160415 格式
     *
     * @param date 日期
     * @return int
     */
    public static int format2Int(Date date) {
        Calendar calendar = Calendar.getInstance(TIMEZONE);
        calendar.setTime(date);
        String year = String.format("%04d", calendar.get(Calendar.YEAR));
        String month = String.format("%02d", calendar.get(Calendar.MONTH) + 1);
        String day = String.format("%02d", calendar.get(Calendar.DAY_OF_MONTH));
        return Integer.parseInt(year + month + day);
    }

    /**
     * 当前时间格式化为 20160415112036 格式
     *
     * @return long
     */
    public static long formatNow2Long() {
        return format2Long(new Date());
    }

    /**
     * 当前时间加上指定秒数后格式化为 20160415112036 格式
     *
     * @return long
     */
    public static long formatNowAddSecond2Long(int second) {
        Calendar calendar = Calendar.getInstance(TIMEZONE);
        calendar.add(Calendar.SECOND, second);
        return format2Long(calendar.getTime());
    }

    /**
     * 数字型可视化时间转换为Date
     *
     * @param format 数字时间
     * @return date
     */
    public static Date parse(long format) {
        String str = String.valueOf(format);
        if (str.length() >= 8) {
            Calendar calendar = Calendar.getInstance(TIMEZONE);
            calendar.clear();
            calendar.set(Calendar.YEAR, Integer.parseInt(str.substring(0, 4)));
            calendar.set(Calendar.MONTH, Integer.parseInt(str.substring(4, 6)) - 1);
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(str.substring(6, 8)));
            if (str.length() >= 14) {
                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(str.substring(8, 10)));
                calendar.set(Calendar.MINUTE, Integer.parseInt(str.substring(10, 12)));
                calendar.set(Calendar.SECOND, Integer.parseInt(str.substring(12, 14)));
            }
            if (str.length() == 17) {
                calendar.set(Calendar.MILLISECOND, Integer.parseInt(str.substring(14, 17)));
            }
            return calendar.getTime();
        }
        return null;
    }


    /**
     * 数字型可视化时间转换为小时分钟
     *
     * @param format 数字时间
     * @return date
     */
    public static String parseHM(long format) {
        String str = String.valueOf(format);
        if (str.length() >= 14) {
            return str.substring(8, 10) + ":" + str.substring(10, 12);
        }
        return "";
    }


    /**
     * 比较是否为一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compareSameDay(Date date1, Date date2) {
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        return fmt.format(date1).equals(fmt.format(date2));
    }

    /**
     * @Desc 是否是同一天 忽略月份
     */
    public static boolean isSameDayOfMonth(Date date1, Date date2) {
        Calendar instance1 = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance1.setTime(date1);
        instance2.setTime(date2);
        return instance1.get(Calendar.DAY_OF_MONTH) == instance2.get(Calendar.DAY_OF_MONTH);
    }



    /**
     * @Desc startDate 在 endDate 之前，或是同一天
     */
    public static boolean beforeOrSameDay(Date startDate, Date endDate) {
        return DateUtils.justDay(startDate).before(DateUtils.justDay(endDate)) || DateUtils.compareSameDay(startDate, endDate);
    }

    /**
     * @Desc 是否是月初
     */
    public static boolean isFistDayOfMonth(Date acContractStartTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(acContractStartTime);
        return 1 == calendar.get(Calendar.DAY_OF_MONTH);
    }


    /**
     * @Desc 是否是月末
     */
    public static Boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    /**
     * @Desc 返回月末
     */
    public static Date getLastDayOfMonth(Date date) {
        Date finalDate = date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) != 1) {
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            finalDate = calendar.getTime();
        }
        return finalDate;
    }

    /**
     * 获取次日00:00时间
     */
    public static Date getNextDate() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.HOUR_OF_DAY, 0);
        ca.set(Calendar.MINUTE, 0);
        ca.set(Calendar.SECOND, 0);
        ca.set(Calendar.MILLISECOND, 0);
        ca.add(Calendar.DAY_OF_MONTH, 1);
        return ca.getTime();
    }


    /**
     * 日期时分秒清零
     *
     * @return
     */
    public static Date justDay(Date date) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date);
        // 将时分秒,毫秒域清零
        cal1.set(Calendar.HOUR_OF_DAY, 0);
        cal1.set(Calendar.MINUTE, 0);
        cal1.set(Calendar.SECOND, 0);
        cal1.set(Calendar.MILLISECOND, 0);
        return cal1.getTime();
    }


}
