package com.leslie.weather;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

import com.leslie.weather.util.ParseUtil;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fr.arnaudguyon.xmltojsonlib.XmlToJson;
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
    //这个接口返回的是 XML 类型数据，解析前要先转换成 JSON 类型数据
    private static final String FREE_WEATHER_API_ADDRESS = "http://wthrcdn.etouch.cn/WeatherApi?city=济南";
    //这个接口返回的是 JSON 类型数据，是聚合数据提供的接口，但是免费使用只有 500 次
    private static final String JUHE_WEATHER_API_ADDRESS = "http://v.juhe.cn/weather/index?format=2&" +
            "cityname=%E8%8B%8F%E5%B7%9E&key=5bbdd4c61885e51fc50c58347601c5f4";
    //----------------------------------------------------------------------------------------------
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case WEATHER_DATA_SUCCESS:
                    String data = (String) msg.obj;
                    XmlToJson xmlToJson = new XmlToJson.Builder(data).build();
                    String jsonData = xmlToJson.toString();
                    tvWeatherInfo.setText(jsonData);
                    ParseUtil.parseJsonData(jsonData);
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
            request = new Request.Builder().url(FREE_WEATHER_API_ADDRESS).build();
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
