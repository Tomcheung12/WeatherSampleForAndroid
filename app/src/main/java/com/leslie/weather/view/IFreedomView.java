package com.leslie.weather.view;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 * 这个其实不是一个视图，这个是告诉活动要展示什么样的视图的接口
 */

public interface IFreedomView<T> {

    void onSuccessView(T response);

    void onErrorView(String errorMsg);

    void showLoadingView(SpinnerProgressDialoag loadingView);

    void hideLoading(SpinnerProgressDialoag loadingView);
}
