package com.example.dell.lotteryplan.base;

import android.app.Application;

/**
 * Created by dell on 2017/3/15.
 */

public class CustomApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler mCrashHandler = new CrashHandler();
        mCrashHandler.init(getApplicationContext());
    }
}
