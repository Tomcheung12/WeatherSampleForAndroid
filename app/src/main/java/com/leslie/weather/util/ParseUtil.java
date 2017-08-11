package com.leslie.weather.util;

import android.util.Log;

import com.google.gson.Gson;
import com.leslie.weather.bean.WeatherData;
import com.leslie.weather.bean.WeatherDataJuhe;

import java.util.List;

/**
 * Created date: 2017/8/11
 * Author:  Leslie
 */

public class ParseUtil {
    private static final String TAG = "ParseUtil";

    /**
     * 解析 http://wthrcdn.etouch.cn/WeatherApi?city=济南 免费接口返回的 XML 类型数据转换成的 JSON 数据字符串
     *
     * @param jsonData
     */
    public static void parseJsonData(String jsonData) {
        Gson gson = new Gson();
        WeatherData weatherData = gson.fromJson(jsonData, WeatherData.class);
        //1.获取内部类 RespBean，然后获取其的属性值
        WeatherData.RespBean resp = weatherData.getResp();
        String city = resp.getCity();
        String fengli = resp.getFengli();
        String fengxiang = resp.getFengxiang();
        String shidu = resp.getShidu();
        String sunrise_1 = resp.getSunrise_1();
        String sunrise_2 = resp.getSunrise_2();
        String sunset_1 = resp.getSunset_1();
        String sunset_2 = resp.getSunset_2();
        String updatetime = resp.getUpdatetime();
        int wendu = resp.getWendu();
        Log.d(TAG, "handleMessage: ---城市：" + city);
        Log.d(TAG, "handleMessage: ---温度：" + wendu);
        Log.d(TAG, "handleMessage: ---风力：" + fengli);
        Log.d(TAG, "handleMessage: ---风向：" + fengxiang);
        Log.d(TAG, "handleMessage: ---湿度：" + shidu);
        Log.d(TAG, "handleMessage: ---日出1：" + sunrise_1);
        Log.d(TAG, "handleMessage: ---日出2：" + sunrise_2);
        Log.d(TAG, "handleMessage: ---日落1：" + sunset_1);
        Log.d(TAG, "handleMessage: ---日落2：" + sunset_2);
        Log.d(TAG, "handleMessage: ---更新时间：" + updatetime);
        //获取内部类 指数
        WeatherData.RespBean.ZhishusBean zhishus = resp.getZhishus();
        List<WeatherData.RespBean.ZhishusBean.ZhishuBean> zhishu = zhishus.getZhishu();
        for (WeatherData.RespBean.ZhishusBean.ZhishuBean zhishuBean : zhishu) {
            String name = zhishuBean.getName();
            String detail = zhishuBean.getDetail();
            String value = zhishuBean.getValue();
            Log.d(TAG, "handleMessage: ---指数：" + name + "---详情：" + detail + "---值：" + value);
        }
        //获取内部类 RespBean 的内部类 EnvironmentBean，并且获取其属性值
        WeatherData.RespBean.EnvironmentBean environment = resp.getEnvironment();
        int aqi = environment.getAqi();
        int co = environment.getCo();
        String majorPollutants = environment.getMajorPollutants();
        int no2 = environment.getNo2();
        int pm10 = environment.getPm10();
        int pm25 = environment.getPm25();
        String quality = environment.getQuality();
        int so2 = environment.getSo2();
        String suggest = environment.getSuggest();
        String time = environment.getTime();
        Log.d(TAG, "handleMessage: 空气质量指数：" + aqi);
        Log.d(TAG, "handleMessage: 一氧化碳：" + co);
        Log.d(TAG, "handleMessage: 主要污染物：" + majorPollutants);
        Log.d(TAG, "handleMessage: 二氧化氮：" + no2);
        Log.d(TAG, "handleMessage: PM10：" + pm10);
        Log.d(TAG, "handleMessage: pm25：" + pm25);
        Log.d(TAG, "handleMessage: 二氧化硫：" + so2);
        Log.d(TAG, "handleMessage: 空气质量：" + quality);
        Log.d(TAG, "handleMessage: 时间：" + time);
        Log.d(TAG, "handleMessage: 建议：" + suggest);


        WeatherData.RespBean.ForecastBean forecast = resp.getForecast();
        List<WeatherData.RespBean.ForecastBean.WeatherBean> weather = forecast.getWeather();
        String data;
        String high;
        String low;
        String fengliDay;
        String fengxiangDay;
        String typeDay;
        String nightFengli;
        String nightFengxiang;
        String nightType;
        for (WeatherData.RespBean.ForecastBean.WeatherBean weatherBean : weather) {
            data = weatherBean.getDate();
            high = weatherBean.getHigh();
            low = weatherBean.getLow();
            //白天情况
            WeatherData.RespBean.ForecastBean.WeatherBean.DayBean day = weatherBean.getDay();
            fengliDay = day.getFengli();
            fengxiangDay = day.getFengxiang();
            typeDay = day.getType();
            //夜间情况
            WeatherData.RespBean.ForecastBean.WeatherBean.NightBean night = weatherBean.getNight();
            nightFengli = night.getFengli();
            nightFengxiang = night.getFengxiang();
            nightType = night.getType();

            Log.d(TAG, "handleMessage: 日期：" + data);
            Log.d(TAG, "handleMessage: 最高温度：" + high);
            Log.d(TAG, "handleMessage: 最低温度：" + low);
            Log.d(TAG, "handleMessage: 白天风力：" + fengliDay);
            Log.d(TAG, "handleMessage: 白天风向：" + fengxiangDay);
            Log.d(TAG, "handleMessage: 白天状况：" + typeDay);
            Log.d(TAG, "handleMessage: 夜间风力：" + nightFengli);
            Log.d(TAG, "handleMessage: 夜间风向：" + nightFengxiang);
            Log.d(TAG, "handleMessage: 夜间类型：" + nightType);
        }
    }

    /**
     * 解析聚合数据的天气预报接口 JSON 字符串
     * @param jsonData
     */
    public static void parseJuheWeatherData(String jsonData){
        Gson gson = new Gson();
        WeatherDataJuhe weatherDataJuhe = gson.fromJson(jsonData, WeatherDataJuhe.class);
        WeatherDataJuhe.ResultBean result = weatherDataJuhe.getResult();
        //获取三个内部类对象
        List<WeatherDataJuhe.ResultBean.FutureBean> future = result.getFuture();
        WeatherDataJuhe.ResultBean.SkBean sk = result.getSk();
        WeatherDataJuhe.ResultBean.TodayBean today = result.getToday();
        //分别处理 future 属性值
        String futureBeanDate;
        String futureBeanTemperature;
        String futureBeanWeek;
        String futureBeanWeather;
        String futureBeanWind;
        for (WeatherDataJuhe.ResultBean.FutureBean futureBean : future) {
            futureBeanDate = futureBean.getDate();
            futureBeanTemperature = futureBean.getTemperature();
            futureBeanWeather = futureBean.getWeather();
            futureBeanWeek = futureBean.getWeek();
            futureBeanWind = futureBean.getWind();
            Log.d(TAG, "handleMessage: ---未来日期：" + futureBeanDate);
            Log.d(TAG, "handleMessage: ---未来天气温度：" + futureBeanTemperature);
            Log.d(TAG, "handleMessage: ---未来周：" + futureBeanWeek);
            Log.d(TAG, "handleMessage: ---未来天气：" + futureBeanWeather);
            Log.d(TAG, "handleMessage: ---未来风：" + futureBeanWind);
        }
        //分别处理 sk 属性值
        String humidity = sk.getHumidity();
        String temp = sk.getTemp();
        String time = sk.getTime();
        String windDirection = sk.getWind_direction();
        String windStrength = sk.getWind_strength();
        Log.d(TAG, "handleMessage: ---相对湿度：" + humidity);
        Log.d(TAG, "handleMessage: ---温度：" + temp);
        Log.d(TAG, "handleMessage: ---时间：" + time);
        Log.d(TAG, "handleMessage: ---风向：" + windDirection);
        Log.d(TAG, "handleMessage: ---风力：" + windStrength
        );
        //分别处理 today 属性值
        String city = today.getCity();
        String temperature = today.getTemperature();
        String wind = today.getWind();
        String weather = today.getWeather();
        String week = today.getWeek();
        String comfort_index = today.getComfort_index();
        String date_y = today.getDate_y();
        String dressing_advice = today.getDressing_advice();
        String dressing_index = today.getDressing_index();
        String uv_index = today.getUv_index();
        String wash_index = today.getWash_index();
        String travel_index = today.getTravel_index();
        String exercise_index = today.getExercise_index();
        Log.d(TAG, "handleMessage: ---城市：" + city);
        Log.d(TAG, "handleMessage: ---温度：" + temperature);
        Log.d(TAG, "handleMessage: ---风：" + wind);
        Log.d(TAG, "handleMessage: ---天气：" + weather);
        Log.d(TAG, "handleMessage: ---星期：" + week);
        Log.d(TAG, "handleMessage: ---日期：" + date_y);
        Log.d(TAG, "handleMessage: ---舒适指数：" + comfort_index);
        Log.d(TAG, "handleMessage: ---穿衣指数：" + dressing_index);
        Log.d(TAG, "handleMessage: ---穿衣建议：" + dressing_advice);
        Log.d(TAG, "handleMessage: ---紫外线强度：" + uv_index);
        Log.d(TAG, "handleMessage: ---外出指数：" + travel_index);
        Log.d(TAG, "handleMessage: ---洗衣指数：" + wash_index);
        Log.d(TAG, "handleMessage: ---运动指数：" + exercise_index);
    }
}
