package com.leslie.weather.modle;

import com.leslie.weather.bean.WeatherResponse;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 * 天气结果回调接口
 */

public interface WeatherResultCallback {

    void onSuccess(WeatherResponse weatherResponse);

    void onError(String errorMsg);
}
