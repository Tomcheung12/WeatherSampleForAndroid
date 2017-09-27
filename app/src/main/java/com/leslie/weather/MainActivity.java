package com.leslie.weather;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.leslie.weather.bean.WeatherRequest;
import com.leslie.weather.bean.WeatherResponse;
import com.leslie.weather.presenter.ObtainWeatherDataPresenter;
import com.leslie.weather.util.TimeUtil;
import com.leslie.weather.view.IFreedomView;
import com.leslie.weather.view.SpinnerProgressDialoag;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.leslie.weather.constant.Constants.ACTION_URL;
import static com.leslie.weather.constant.Constants.BASE_URL;
import static com.leslie.weather.constant.Constants.CITY_KEY;

public class MainActivity extends Activity implements IFreedomView {
    private static final String TAG = "MainActivity";
    //----------------------------------------------------------------------------------------------
    @Bind(R.id.tv_tempture)
    TextView tvTempture;
    @Bind(R.id.tv_last_updata)
    TextView tvLastUpdata;
    @Bind(R.id.tv_weather_type)
    TextView tvWeatherType;
    @Bind(R.id.tv_aqi)
    TextView tvAqi;
    @Bind(R.id.tv_humidity)
    TextView tvHumidity;
    @Bind(R.id.tv_wind)
    TextView tvWind;
    @Bind(R.id.tv_sun_time)
    TextView tvSunTime;
    @Bind(R.id.tv_PM2_5)
    TextView tv2_5;
    @Bind(R.id.tv_CO)
    TextView tvCO;
    @Bind(R.id.tv_NO2)
    TextView tvNO2;
    @Bind(R.id.tv_SO2)
    TextView tvSO2;
    @Bind(R.id.tv_O3)
    TextView tvO3;
    //----------------------------------------------------------------------------------------------

    private ObtainWeatherDataPresenter weatherDataPresenter;
    private Context mContext;
    private SpinnerProgressDialoag dialoag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        mContext = this;
        dialoag = new SpinnerProgressDialoag(mContext, Color.BLUE);

    }

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onStart() {
        super.onStart();
        loadData();                                                                                 //界面可见时加载数据
    }

    //----------------------------------------------------------------------------------------------
    @Override
    protected void onStop() {
        super.onStop();
        weatherDataPresenter.detachView(this);
    }
    //----------------------------------------------------------------------------------------------
    //-------------以下是 IFreedomView 接口的实现方法------------------------------------------------

    @Override
    public void onSuccessView(Object response) {
        if (response instanceof WeatherResponse) {
            WeatherResponse weatherResponse = (WeatherResponse) response;
            WeatherResponse.RespBean respBean = weatherResponse.getResp();
            fillData(respBean);                                                                     //填充数据
        }
    }

    @Override
    public void onErrorView(String errorMsg) {
        Toast.makeText(mContext, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingView(SpinnerProgressDialoag loadingView) {
        loadingView.show();
    }

    @Override
    public void hideLoading(SpinnerProgressDialoag loadingView) {
        loadingView.dismiss();
    }
    //-------------以上是 IFreedomView 接口的实现方法------------------------------------------------

    //----------------------------------------------------------------------------------------------

    /**
     * 加载数据
     */
    private void loadData() {
        weatherDataPresenter = new ObtainWeatherDataPresenter(dialoag);
        weatherDataPresenter.attachView(this);
        WeatherRequest weatherRequest = new WeatherRequest(BASE_URL, ACTION_URL, CITY_KEY, "济南");
        weatherDataPresenter.getData(weatherRequest);
    }
    //----------------------------------------------------------------------------------------------

    /**
     * 填充数据
     *
     * @param respBean
     */
    private void fillData(WeatherResponse.RespBean respBean) {
        String wendu = respBean.getWendu() + "";
        String shidu = respBean.getShidu();
        String updatetime = respBean.getUpdatetime();
        String sunrise1 = respBean.getSunrise_1();
        String sunset1 = respBean.getSunset_1();
        WeatherResponse.RespBean.EnvironmentBean environment = respBean.getEnvironment();
        String time = environment.getTime();


        WeatherResponse.RespBean.ForecastBean forecast = respBean.getForecast();
        List<WeatherResponse.RespBean.ForecastBean.WeatherBean> weather =
                forecast.getWeather();
        WeatherResponse.RespBean.ForecastBean.WeatherBean todayWeather = weather.get(0);
        WeatherResponse.RespBean.ForecastBean.WeatherBean.DayBean todayWeatherDay = todayWeather.getDay();
        String type = todayWeatherDay.getType();
        String todayWeatherDayFengxiang = todayWeatherDay.getFengxiang();
        String todayWeatherDayFengli = todayWeatherDay.getFengli();

        int aqi = environment.getAqi();
        String quality = environment.getQuality();
        String pm25 = environment.getPm25() + "";
        String co = environment.getCo() + "";
        String no2 = environment.getNo2() + "";
        String so2 = environment.getSo2() + "";
        String o3 = environment.getO3() + "";

        tvTempture.setText(wendu + "°");
        tvLastUpdata.setText(TimeUtil.computeTimeDiff(TimeUtil.getTimeOfDay(), updatetime) + "前发布");
        tvWeatherType.setText(type);
        tvAqi.setText(aqi + " " + quality);
        tvHumidity.setText(shidu);
        tvWind.setText(todayWeatherDayFengxiang + todayWeatherDayFengli);
        tvSunTime.setText(sunrise1 + " ~ " + sunset1);

        tv2_5.setText(pm25);
        tvCO.setText(co);
        tvNO2.setText(no2);
        tvSO2.setText(so2);
        tvO3.setText(o3);
    }
    //----------------------------------------------------------------------------------------------
}
