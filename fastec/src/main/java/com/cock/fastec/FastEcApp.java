package com.cock.fastec;

import android.app.Application;

import com.cock.latte.core.app.Latte;
import com.cock.latte.core.net.interceptors.DebugInterceptor;
import com.cock.latte.ec.database.DatabaseManager;
import com.cock.latte.ec.icon.FontEcModule;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class FastEcApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withLoaderDelayed(1000)
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
        //初始化数据库
        DatabaseManager.getInstance().init(this);
        //log初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
        //数据库查看工具
        initStetho();
    }

    private void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

}
