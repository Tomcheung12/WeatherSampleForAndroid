package com.leslie.weather.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created date: 2017/8/28
 * Author:  Leslie
 */

public class TimeUtil {
    private static SimpleDateFormat simpleDateFormat;
    private static final String TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取时间，是一天当中的某一时间
     *
     * @return
     */
    public static String getTimeOfDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        String minuteStr;
        String hourStr;
        String secondStr;
        if (minute < 10) {
            minuteStr = "0" + minute;
        } else {
            minuteStr = "" + minute;
        }
        if (hour < 10) {
            hourStr = "0" + hour;
        } else {
            hourStr = "" + hour;
        }
        if (second < 10) {
            secondStr = "0" + second;
        } else {
            secondStr = "" + second;
        }
        return hourStr + ":" + minuteStr;
    }

    public static String stampToTime(String timeStamp) {
        String res;
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        }
        Long lt = new Long(timeStamp);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static long timeStr2Stamp(String timeStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_FORMAT);
        Date date = null;
        long timeStemp = 0;
        try {
            date = simpleDateFormat.parse(timeStr);
            timeStemp = date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return timeStemp;
    }

    /**
     * 计算时间差，返回的是分钟
     *
     * @param refreshTime 14:55 获取天气数据时的时间，24 小时制，精确到分钟
     * @param updatetime  14:40 天气预报接口提供数据的最新时间，24 小时制，精确到分钟
     */
    public static String computeTimeDiff(String refreshTime, String updatetime) {
        String[] refreshTimeAttr = refreshTime.split(":");
        String[] updataTimeAttr = updatetime.split(":");

        int refreshTimeMinutes = 0;
        int updataTimeMinutes = 0;
        for (int i = 0; i < refreshTimeAttr.length; i++) {
            if (i == 0) {
                refreshTimeMinutes += Integer.parseInt(refreshTimeAttr[i]) * 60;
            }
            if (i == 1) {
                refreshTimeMinutes += Integer.parseInt(refreshTimeAttr[i]);
            }
        }
        for (int i = 0; i < updataTimeAttr.length; i++) {
            if (i == 0) {
                updataTimeMinutes += Integer.parseInt(updataTimeAttr[i]) * 60;
            }
            if (i == 1) {
                updataTimeMinutes += Integer.parseInt(updataTimeAttr[i]);
            }
        }
        int diffMinutes = refreshTimeMinutes - updataTimeMinutes;
        if (diffMinutes >= 60) {
            int hour = diffMinutes / 60;
            int minute = diffMinutes % 60;
            return hour + "小时" + minute + "分钟";
        } else {
            return diffMinutes + "分钟";
        }
    }

}
