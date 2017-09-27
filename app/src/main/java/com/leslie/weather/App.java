package com.leslie.weather;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import com.leslie.weather.util.NetRequestManager;

/**
 * Created date: 2017/9/27
 * Author:  Leslie
 */

public class App extends Application {

    private static App appInstance;
    private Activity currentActivity;

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = (App) getApplicationContext();

        appInstance.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                currentActivity = activity;
            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }

    public static App getInstance(){
        return appInstance;
    }

    public Activity getCurrentActivity(){
        return currentActivity;
    }

    public NetRequestManager getNetRequestInstance(){
        return NetRequestManager.getInstance(appInstance);
    }

}
