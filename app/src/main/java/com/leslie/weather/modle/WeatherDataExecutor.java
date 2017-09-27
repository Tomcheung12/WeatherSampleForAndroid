package com.leslie.weather.modle;

import com.leslie.weather.App;
import com.leslie.weather.bean.WeatherRequest;
import com.leslie.weather.util.NetRequestManager;
import com.leslie.weather.util.ParseUtil;

import java.util.HashMap;

import fr.arnaudguyon.xmltojsonlib.XmlToJson;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 * module 层，请求天气数据并且处理数据。
 */

public class WeatherDataExecutor implements WeatherDataSource {
    @Override
    public void requestWeatherData(final WeatherRequest weatherRequest, final WeatherResultCallback callback) {
        //开启网络请求，成功后回调到 presenter 层中
        new Thread(new Runnable() {
            @Override
            public void run() {
                NetRequestManager requestInstance = App.getInstance().getNetRequestInstance();
                HashMap<String, String> map = new HashMap<>();
                map.put(weatherRequest.getCityKey(), weatherRequest.getCityName());
                requestInstance.requestAsyn(weatherRequest.getActionUrl(), NetRequestManager.TYPE_POST_JSON, map
                        , new NetRequestManager.ReqCallBack<Object>() {
                            @Override
                            public void onReqSuccess(final Object result) {
                                //由于此接口返回的是 XML 类型数据，所以要先转化成 JSON 类型数据
                                String xmlData = result.toString();
                                XmlToJson xmlToJson = new XmlToJson.Builder(xmlData).build();
                                String jsonData = xmlToJson.toString();
                                callback.onSuccess(ParseUtil.parseJsonData(jsonData));

                            }

                            @Override
                            public void onReqFailed(final String errorMsg) {
                                callback.onError(errorMsg);

                            }
                        });
            }
        }).start();
    }
}
