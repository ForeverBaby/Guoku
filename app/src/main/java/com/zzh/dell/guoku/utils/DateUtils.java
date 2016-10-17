package com.zzh.dell.guoku.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DELL on 2016/10/15.
 */
public final class DateUtils {


//    private static int TIME = 86400000;
    public static SimpleDateFormat formatL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    public static SimpleDateFormat formatM = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static SimpleDateFormat formatS = new SimpleDateFormat("yyyy-MM-dd");
//    public static SimpleDateFormat formatsingle = new SimpleDateFormat("dd");

    /**
     * @param paramDate
     * @return yyyy-MM-dd HH;mm:ss
     */
    public static String formatDate(Date paramDate) {
        return formatL.format(paramDate);
    }

    /**
     * 输入获得的时间，得到距现在的时间
     *
     * @param paramString double字符串
     * @return 时间描述
     */
    public static String getStandardDate(String paramString) {
        StringBuffer localStringBuffer = new StringBuffer();
        long l1 = 1000L * (long) Double.parseDouble(paramString);
        long l2 = System.currentTimeMillis() - l1;
        //秒数
        long l3 = (long) Math.ceil(l2 / 1000L);
        //分钟数
        long l4 = (long) Math.ceil((float) (l2 / 60L) / 1000.0F);
        //小时数
        long l5 = (long) Math.ceil((float) (l2 / 60L / 60L) / 1000.0F);
        //天数
        long l6 = (long) Math.ceil((float) (l2 / 24L / 60L / 60L) / 1000.0F);
        //大于100天
        if (l6 / 7L > 100L) {
            localStringBuffer.append("很久很久以前");
        } else if (l6 / 7L > 0L) {
            localStringBuffer.append(l6 / 7L + "周前");
        } else if (l6 - 1L > 2L) {
            localStringBuffer.append(l6 - 1L + "天前");
        } else if (l6 - 1L > 1L) {
            localStringBuffer.append("前天");
        } else if (l6 - 1L > 0L) {
            localStringBuffer.append("昨天");
        } else {
            if (l5 - 1L > 0L) {
                if (l5 >= 24L) {
                    localStringBuffer.append("1天");
                } else {
                    localStringBuffer.append(l5 + "小时前");
                }
            } else if (l4 - 1L > 0L) {
                if (l4 == 60L) {
                    localStringBuffer.append("1小时");
                } else {
                    localStringBuffer.append(l4 + "分钟前");
                }
            } else if (l3 - 1L > 0L) {
                if (l3 == 60L) {
                    localStringBuffer.append("1分钟");
                } else {
                    localStringBuffer.append(l3 + "秒前");
                }
            } else {
                localStringBuffer.append("刚刚");
            }
        }
        return localStringBuffer.toString();
    }

    /**
     * 通过输入的时间字符串获得当前星期
     * @param paramString
     * @return
     */
    public static String getWeek(String paramString) {
        String str = "";
        Calendar localCalendar = Calendar.getInstance();
        try {
            localCalendar.setTime(formatS.parse(paramString));
            int day_of_week = localCalendar.get(Calendar.DAY_OF_WEEK);
            if (day_of_week == 1) {
                str = str + "Sun";
            } else if (day_of_week == 2) {
                str = str + "Mon";
            } else if (day_of_week == 3) {
                str = str + "Tue";
            } else if (day_of_week == 4) {
                str = str + "Wed";
            } else if (day_of_week == 5) {
                str = str + "Thu";
            } else if (day_of_week == 6) {
                str = str + "Fri";
            } else if (day_of_week == 7) {
                str = str + "Sat";
            }
            return str;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

}
