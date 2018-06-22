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
                .withApiHost("http://114.67.229.240/rest/api/")
                .withLoaderDelayed(1000)
                .withInterceptor(new DebugInterceptor("text", R.raw.test))
                .withWeChatAppId("")
                .withWeChatAppScript("")
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
