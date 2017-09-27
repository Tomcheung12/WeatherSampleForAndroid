package com.leslie.weather.presenter;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 */

public interface Presenter<V> {

    void attachView(V view);

    void detachView(V view);


}
