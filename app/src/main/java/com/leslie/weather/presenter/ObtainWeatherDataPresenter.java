package com.leslie.weather.presenter;

import com.leslie.weather.bean.WeatherRequest;
import com.leslie.weather.bean.WeatherResponse;
import com.leslie.weather.modle.WeatherDataExecutor;
import com.leslie.weather.modle.WeatherResultCallback;
import com.leslie.weather.view.SpinnerProgressDialoag;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 * 绑定 View 层和 Model 层
 */

public class ObtainWeatherDataPresenter extends BasePresenter {
    private WeatherDataExecutor weatherDataExecutor;
    private final SpinnerProgressDialoag dialoag;

    public ObtainWeatherDataPresenter(SpinnerProgressDialoag loadingDialog) {
        this.weatherDataExecutor = new WeatherDataExecutor();
        dialoag = loadingDialog;
    }
    public void getData(WeatherRequest weatherRequest){
        mFreedomView.showLoadingView(dialoag);
        weatherDataExecutor.requestWeatherData(weatherRequest, new WeatherResultCallback() {
            @Override
            public void onSuccess(WeatherResponse weatherResponse) {
                mFreedomView.hideLoading(dialoag);
                mFreedomView.onSuccessView(weatherResponse);
            }

            @Override
            public void onError(String errorMsg) {
                mFreedomView.hideLoading(dialoag);
                mFreedomView.onErrorView(errorMsg);
            }
        });
    }
}
