package com.leslie.weather.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import com.leslie.weather.R;


public class SpinnerProgressDialoag extends ProgressDialog {


    private SpinnerLoader loader;
    private Context mContext;
    private int dodgerBlue = 0x2003199;
    private int pointColor;


    public SpinnerProgressDialoag(Context context,int pointColor) {
        super(context, R.style.NoBackgroundProgressDialog);
        this.mContext = context;
        this.pointColor = pointColor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressdialoag);

        loader = (SpinnerLoader) findViewById(R.id.loader);
        loader.setPointcolor(pointColor);
        setCanceledOnTouchOutside(true);
        setCancelable(true);

    }

}
