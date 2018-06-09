package com.cock.fastec;

import android.app.Application;

import com.cock.latte.core.app.Latte;

public class FastEcApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://www.baidu.com")
                .configure();
    }
}
