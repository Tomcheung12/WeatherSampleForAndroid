package com.leslie.weather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";
    //----------------------------------------------------------------------------------------------
    @Bind(R.id.bt_get_weather_info)
    Button btGetWeatherInfo;
    @Bind(R.id.tv_weather_info)
    TextView tvWeatherInfo;
    //----------------------------------------------------------------------------------------------
    private OkHttpClient client;
    private FormBody body;
    private Request request;
    //----------------------------------------------------------------------------------------------
    private static final int WEATHER_DATA_SUCCESS = 1001;
    //----------------------------------------------------------------------------------------------
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WEATHER_DATA_SUCCESS:
                    String xmlData = (String) msg.obj;
                    tvWeatherInfo.setText(xmlData);
                    //解析 XML 数据
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.bt_get_weather_info)
    public void onViewClicked() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                getDataByOKHttp();
            }
        }).start();

    }
    private void getDataByOKHttp() {
        try {
            client = new OkHttpClient();
            request = new Request.Builder().url("http://wthrcdn.etouch.cn/WeatherApi?city=济南").build();
            Response response = client.newCall(request).execute();
            String responseData = response.body().string();
            Message message = mHandler.obtainMessage();
            message.obj = responseData;
            message.what = WEATHER_DATA_SUCCESS;
            mHandler.sendMessage(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
