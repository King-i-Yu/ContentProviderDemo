package com.example.contentproviderdemo;

import android.app.Application;
import android.util.Log;

/**
 * Author wangyu1
 * Data 2018/12/27
 * Description
 **/
public class MyApplication extends Application {

    private static MyApplication mInstance = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }


    public static MyApplication getInstance() {
        return mInstance;
    }
}
