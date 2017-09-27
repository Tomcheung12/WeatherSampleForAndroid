package com.leslie.weather.bean;

/**
 * Created date: 2017/9/26
 * Author:  Leslie
 */

public class WeatherRequest {

    private String baseUrl;
    private String actionUrl;
    private String cityName;
    private String cityKey;

    public WeatherRequest(String baseUrl, String actionUrl, String cityKey, String cityName) {
        this.baseUrl = baseUrl;
        this.actionUrl = actionUrl;
        this.cityName = cityName;
        this.cityKey = cityKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getActionUrl() {
        return actionUrl;
    }

    public void setActionUrl(String actionUrl) {
        this.actionUrl = actionUrl;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityKey() {
        return cityKey;
    }

    public void setCityKey(String cityKey) {
        this.cityKey = cityKey;
    }
}
