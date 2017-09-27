package com.leslie.weather.modle;

import com.leslie.weather.bean.WeatherRequest;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 * 模型抽象类
 * 模型实现类通常是对本地数据库的操作或者是通过网络请求获取网络数据的操作.
 */

public interface WeatherDataSource {

    /**
     * 请求天气数据
     * @param weatherRequest 请求对象，包含地址和参数
     * @param callback 请求结果回调
     */
    void requestWeatherData(WeatherRequest weatherRequest,WeatherResultCallback callback);
}
