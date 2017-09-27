package com.leslie.weather.presenter;

import com.leslie.weather.view.IFreedomView;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 */

public class BasePresenter<V extends IFreedomView> implements Presenter<V> {
    protected V mFreedomView;

    @Override
    public void attachView(V view) {
        mFreedomView = view;
    }

    @Override
    public void detachView(V view) {
        mFreedomView = null;
    }
}
