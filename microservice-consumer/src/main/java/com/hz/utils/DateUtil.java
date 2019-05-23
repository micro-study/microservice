package com.hz.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


/**
 *
 */
public class DateUtil {

    private static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /**
     * 时间单位
     */
    public static final String YEAR = "YEAR";
    public static final String MONTH = "MONTH";
    public static final String WEEK = "WEEK";
    public static final String DAY = "DAY";
    public static final String HOUR = "HOUR";
    public static final String MINUTE = "MINUTE";
    public static final String SECOND = "SECOND";

    /**
     * yyyyMMdd格式字符
     */
    public static final String dataFormatyyyyMMdd = "yyyyMMdd";

    /**
     * HHmmss格式字符
     */
    public static final String dataFormatHHmmss = "HHmmss";

    /**
     * yyyyMMddHHmmss格式字符
     */
    public static final String dataFormatyyyyMMddHHmmss = "yyyyMMddHHmmss";

    /**
     * yyyy-MM-dd格式字符
     */
    public static final String dataFormatyyyy_MM_dd = "yyyy-MM-dd";

    /**
     * HH:mm:ss格式字符
     */
    public static final String dataFormatHH_mm_ss = "HH:mm:ss";

    /**
     * 利用时间差来记录时间<br>
     * 平台时间比本地时间快多少(可能为负),<br>
     * 若没设置则span = 0,认为本地时间就是平台时间
     */
    private static long span = 0;

    /**
     * 取当前时间
     *
     * @return
     * @Author:Junjie.Lai weipeng@travelertech.com
     * @Since:2013-6-20
     * @Version:MCA2
     */
    public static Date getDate() {
        Date nowAndroid = new Date();
        long nowPlant = nowAndroid.getTime() + span;

        Date nowPlantDate = new Date(nowPlant);

        return nowPlantDate;
    }

    /**
     * @param
     * @title: getNowDate
     * @description: 获取当前日期（格式：yyyyMMdd）
     * @author liuzhongxian
     * @date 2017/11/22 10:03
     */
    public static String getNowDate() {
        return new SimpleDateFormat(dataFormatyyyyMMdd).format(new Date());
    }


    public Calendar getCalendar() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getDate());
        return cal;
    }

    /**
     * 根据format串返回当前日期串
     *
     * @param fomatString
     * @return
     * @Author:Junjie.Lai weipeng@travelertech.com
     * @Since:2013-6-24
     * @Version:Common
     */
    public static String getDateStringByFormatString(String fomatString) {
        Date date = getDate();
        SimpleDateFormat df = new SimpleDateFormat(fomatString);
        return df.format(date);
    }

    /**
     * 获取指定日期时间的增加偏移量后格式化的字符串
     *
     * @param value 分钟偏移量
     * @return 格式化的日期时间字符串
     */
    public String getSpecifyDateStringByMinuteOffset(int value) {
        Calendar calendar = getCalendar();
        calendar.add(Calendar.MINUTE, value);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:00");
        return df.format(calendar.getTime());
    }

    /**
     * Title: convertDateToString<br/>
     * Description: 把data转为制定格式的字符串<br/>
     *
     * @param date
     * @param format
     * @return
     * @author weipeng
     * @date 2014年12月17日下午3:31:14
     */
    public static String convertDateToString(Date date, String format) {
        if (date == null) {
            return null;
        }
        if (format == null) {
            format = "yyyyMMddHHmmss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        String result = sdf.format(date);
        return result;
    }

    /**
     * 将Date转换位14位紧凑型时间字符串
     *
     * @param date date
     * @return 14位紧密型时间字符串
     */
    public static String convertDateToCompactString(Date date) {
        return convertDateToString(date, null);
    }


    /**
     * @param date 传入的时间字符串, dateFormat 传入时间字符串的格式, format 需要转换的格式
     * @title: convertStringToString
     * @description: 这里用一句话描述这个方法的作用
     * @author liuzhongxian
     * @date 2018/4/8 10:38
     */
    public static String convertStringToString(String date, String dateFormat, String format) throws ParseException {
        if (format == null) {
            format = "yyyyMMddHHmmss";
        }
        if (date == null) {
            return null;
        }
        SimpleDateFormat formatter1 = new SimpleDateFormat(dateFormat);
        SimpleDateFormat formatter2 = new SimpleDateFormat(format);
        formatter2.setTimeZone(TimeZone.getTimeZone("GMT+8"));

        Date nowDate = formatter1.parse(date);
        String result = formatter2.format(nowDate);
        return result;
    }

    /**
     * 根据long类型的时间转出format的时间
     *
     * @param timeLongVal
     * @param descFormat
     * @return
     * @Author:Junjie.Lai weipeng@travelertech.com
     * @Since:2013-6-25
     * @Version:Common
     */
    public static String formatDateLongToString(Long timeLongVal,
                                                String descFormat) {
        Date date = new Date(timeLongVal);
        SimpleDateFormat df = new SimpleDateFormat(descFormat);
        return df.format(date);
    }

    /**
     * Title: convertFormatDataToString<br/>
     * Description: 从yyyy-MM-dd HH:mm:ss 格式的时间里面取出 ddHHmmss<br/>
     *
     * @param date
     * @return
     * @author weipeng
     * @date 2014年12月17日下午3:39:45
     */
    public String convertFormatDataToString(String date) {
        String[] datesplite = date.split(" ");
        String[] before = datesplite[0].split("-");
        String[] after = datesplite[1].split(":");

        StringBuilder builder = new StringBuilder();
        builder.append(before[2]).append(after[0]).append(after[1])
                .append(after[2]);
        return builder.toString();
    }

    /**
     * Title: convertStringDateToFormatString<br/>
     * Description: 时间字段转换<br/>
     *
     * @param srcDateStr 源时间字符
     * @param srcFormat  源时间格式
     * @param descFormat 目标时间格式
     * @return
     * @author weipeng
     * @date 2014年12月25日下午3:14:16
     */
    public static String convertStringDateToFormatString(String srcDateStr,
                                                         String srcFormat, String descFormat) {
        if (srcDateStr == null || "".equals(srcDateStr)) {
            return "";
        } else {
            long longTime = formatDateStringToLong(srcDateStr, srcFormat);
            return formatDateLongToString(longTime, descFormat);
        }
    }

    /**
     * 将formatStr的时间 转成 long
     *
     * @param date
     * @return
     */
    public static Long formatDateStringToLong(String date, String formatStr) {
        SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
        try {
            formatter.setTimeZone(TimeZone.getTimeZone("GMT+8"));
            return formatter.parse(date).getTime();
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }
        return 0l;
    }

    /**
     * 计算时间间隔
     *
     * @param lastEndTime      上一次结束时间
     * @param currentBeginTime 这一次开始时间
     * @param timeFormatStr    时间格式
     * @return
     * @Author:Junjie.Lai bpascal.cn@gmail.com
     * @Since:2013-2-24
     * @Version:Digi Portal Demo
     */
    public static long getIntervalSecond(String lastEndTime,
                                         String currentBeginTime, String timeFormatStr) {
        long dlast, dbegin, dInterval;
        SimpleDateFormat df = new SimpleDateFormat(timeFormatStr);
        try {
            dlast = df.parse(lastEndTime).getTime();
            dbegin = df.parse(currentBeginTime).getTime();
            dInterval = Math.abs((dbegin - dlast) / 1000);// 时间间隔
        } catch (Exception e) {
            dInterval = 0;
            logger.error(e.getMessage(), e);
        }
        return dInterval;
    }

    /**
     * 根据秒数，计算时间
     *
     * @param time
     * @return
     * @Author:Junjie.Lai bpascal.cn@gmail.com
     * @Since:2013-2-25
     * @Version:Digi Portal Demo
     */
    public String computSecond(long time) {
        long minute = time % 3600 / 60;// 分
        long second = time % 60;// 秒
        return String.valueOf((minute < 10 ? ("0" + minute) : minute) + ":"
                + (second < 10 ? ("0" + second) : second));
    }

    /**
     * 根据秒数，计算时间
     *
     * @param time
     * @return
     * @Author:Junjie.Lai bpascal.cn@gmail.com
     * @Since:2013-2-25
     * @Version:Digi Portal Demo
     */
    public String computSecondToFullTime(long time) {
        long hour = time / 3600;// 时
        long minute = time % 3600 / 60;// 分
        long second = time % 60;// 秒
        return String.valueOf((hour < 10 ? ("0" + hour) : hour) + ":"
                + (minute < 10 ? ("0" + minute) : minute) + ":"
                + (second < 10 ? ("0" + second) : second));
    }

    /**
     * 对日期进行计算
     *
     * @param date   日期
     * @param unit   计算单位
     * @param offset 偏移量
     * @return
     */
    public static String calculateDate(String date, String unit, int offset) {
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        Date beginDt = null;
        try {
            beginDt = sdf.parse(date);
        } catch (ParseException e) {


        }

        // 设置计算方式
        int type;
        if (unit.equals(DateUtil.YEAR)) {
            type = Calendar.YEAR;
        } else if (unit.equals(DateUtil.MONTH)) {
            type = Calendar.MONTH;
        } else if (unit.equals(DateUtil.WEEK)) {
            type = Calendar.WEEK_OF_MONTH;
        } else if (unit.equals(DateUtil.DAY)) {
            type = Calendar.DAY_OF_YEAR;
        } else {
            return "";
        }
        // 计算日期
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(beginDt);
        rightNow.add(type, offset);

        Date endDt = rightNow.getTime();
        String reStr = sdf.format(endDt);
        return reStr;
    }


    /**
     * 对日期进行计算
     *
     * @param date       日期
     * @param unit       计算单位
     * @param offset     偏移量
     * @param dataFormat 时间格式
     * @return
     */
    public static String calculateDate(String date, String unit, int offset, String dataFormat) {
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);

        Date beginDt = null;
        try {
            beginDt = sdf.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        // 设置计算方式
        int type;
        if (unit.equals(DateUtil.YEAR)) {
            type = Calendar.YEAR;
        } else if (unit.equals(DateUtil.MONTH)) {
            type = Calendar.MONTH;
        } else if (unit.equals(DateUtil.WEEK)) {
            type = Calendar.WEEK_OF_MONTH;
        } else if (unit.equals(DateUtil.DAY)) {
            type = Calendar.DAY_OF_YEAR;
        } else {
            return "";
        }
        // 计算日期
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(beginDt);
        rightNow.add(type, offset);

        Date endDt = rightNow.getTime();
        String reStr = sdf.format(endDt);
        return reStr;
    }

    /**
     * 对日期进行计算
     *
     * @param date   日期
     * @param unit   计算单位
     * @param offset 偏移量
     * @return
     */
    public static String calculateDateByYYYY_MM_DD(String date, String unit,
                                                   int offset) {
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date beginDt = null;
        try {
            beginDt = sdf.parse(date);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        // 设置计算方式
        int type;
        if (unit.equals(DateUtil.YEAR)) {
            type = Calendar.YEAR;
        } else if (unit.equals(DateUtil.MONTH)) {
            type = Calendar.MONTH;
        } else if (unit.equals(DateUtil.DAY)) {
            type = Calendar.DAY_OF_YEAR;
        } else {
            return "";
        }
        // 计算日期
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(beginDt);
        rightNow.add(type, offset);

        Date endDt = rightNow.getTime();
        String reStr = sdf.format(endDt);
        return reStr;
    }

    /**
     * Title: calculateTime<br/>
     * Description: 对时间进行计算<br/>
     *
     * @param time   时间
     * @param unit   单位
     * @param offset 偏移量
     * @return
     * @author weipeng
     * @date 2014年12月22日下午4:44:41
     */
    public static String calculateTime(String time, String unit, int offset) {
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");

        Date beginTm = null;
        try {
            beginTm = sdf.parse(time);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        // 设置计算方式
        int type;
        if (unit.equals(DateUtil.HOUR)) {
            type = Calendar.HOUR_OF_DAY;
        } else if (unit.equals(DateUtil.MINUTE)) {
            type = Calendar.MINUTE;
        } else if (unit.equals(DateUtil.SECOND)) {
            type = Calendar.SECOND;
        } else {
            return "";
        }

        // 计算日期
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(beginTm);
        rightNow.add(type, offset);

        Date endTm = rightNow.getTime();
        String reStr = sdf.format(endTm);
        return reStr;
    }

    /**
     * Title: calculateDateTime<br/>
     * Description: 日期时间计算 <br/>
     *
     * @param dateTime
     * @param unit
     * @param offset
     * @return
     * @author weipeng
     * @date 2014年12月22日下午4:53:10
     */
    public static String calculateDateTime(String dateTime, String unit,
                                           int offset) {
        // 设置日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

        Date beginTm = null;
        try {
            beginTm = sdf.parse(dateTime);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
        }

        // 设置计算方式
        int type;
        if (unit.equals(DateUtil.HOUR)) {
            type = Calendar.HOUR_OF_DAY;
        } else if (unit.equals(DateUtil.MINUTE)) {
            type = Calendar.MINUTE;
        } else if (unit.equals(DateUtil.SECOND)) {
            type = Calendar.SECOND;
        } else if (unit.equals(DateUtil.HOUR)) {
            type = Calendar.HOUR_OF_DAY;
        } else if (unit.equals(DateUtil.MINUTE)) {
            type = Calendar.MINUTE;
        } else if (unit.equals(DateUtil.SECOND)) {
            type = Calendar.SECOND;
        } else {
            return "";
        }

        // 计算日期
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(beginTm);
        rightNow.add(type, offset);

        Date endTm = rightNow.getTime();
        String reStr = sdf.format(endTm);
        return reStr;
    }

    /**
     * Title: judgeDate<br/>
     * Description: 传入固定格式的日期Str用于判断两者大小<br/>
     *
     * @param begDt
     * @param endDt
     * @param format
     * @return 1 0 -1 分别是 大于 等于 小于 -2出现异常
     * @author tangxiongpeng
     * @date 2015年8月26日下午8:39:27
     */
    public static int judgeDate(String begDt, String endDt, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date begDate = null;
        Date endDate = null;
        try {
            begDate = sdf.parse(begDt);
            endDate = sdf.parse(endDt);
        } catch (ParseException e) {
            logger.error(e.getMessage(), e);
            return -2;
        }

        if (begDate.before(endDate)) {
            return -1;
        } else if (begDate.after(endDate)) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * Title: calculateDateBetweenDays<br/>
     * Description: 判定两个日期相差多少天<br/>
     *
     * @param begDate
     * @param endDate
     * @param formatStr
     * @return
     * @author weipeng
     * @date 2016年1月25日下午5:45:49
     */
    public static int calculateDateBetweenDays(String begDate, String endDate,
                                               String formatStr) {
        long timeBeg = formatDateStringToLong(begDate, formatStr);
        long timeEnd = formatDateStringToLong(endDate, formatStr);
        return (int) ((timeEnd - timeBeg) / (86400 * 1000));
    }

    /**
     * Title: calculateDateBetweenDays<br/>
     * Description: 判定两个日期相差多少天<br/>
     *
     * @param begDate
     * @param endDate
     * @param formatStr
     * @return
     * @author weipeng
     * @date 2016年1月25日下午5:45:49
     */
    public static int calculateDateBetweenDaysAbs(String begDate, String endDate,
                                                  String formatStr) {
        long timeBeg = formatDateStringToLong(begDate, formatStr);
        long timeEnd = formatDateStringToLong(endDate, formatStr);
        long between = Math.abs(timeEnd - timeBeg);
        return (int) (between / (86400 * 1000));
    }

    /**
     * 获取当前为周几
     *
     * @return
     */
    public static String getWeeks() {
        String ret = "";
        Calendar c = Calendar.getInstance();
        c.setTime(new Date(System.currentTimeMillis()));
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case 1:
                ret = "7";
                break;
            case 2:
                ret = "1";
                break;
            case 3:
                ret = "2";
                break;
            case 4:
                ret = "3";
                break;
            case 5:
                ret = "4";
                break;
            case 6:
                ret = "5";
                break;
            case 7:
                ret = "6";
                break;
        }
        return ret;
    }


}
