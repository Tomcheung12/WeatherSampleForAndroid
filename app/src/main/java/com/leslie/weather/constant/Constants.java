package com.leslie.weather.constant;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 */

public interface Constants {

    //这个接口返回的是 XML 类型数据，解析前要先转换成 JSON 类型数据
    String FREE_WEATHER_API_ADDRESS = "http://wthrcdn.etouch.cn/WeatherApi?city=济南";
    //这个接口返回的是 JSON 类型数据，是聚合数据提供的接口，但是免费使用只有 500 次
    String JUHE_WEATHER_API_ADDRESS = "http://v.juhe.cn/weather/index?format=2&" +
            "cityname=%E8%8B%8F%E5%B7%9E&key=5bbdd4c61885e51fc50c58347601c5f4";

    String BASE_URL = "http://wthrcdn.etouch.cn/";

    String ACTION_URL = "WeatherApi";

    String CITY_KEY = "city";
}
