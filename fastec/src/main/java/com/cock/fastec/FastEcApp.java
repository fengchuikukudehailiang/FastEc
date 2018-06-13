package com.cock.fastec;

import android.app.Application;

import com.cock.latte.core.app.Latte;
import com.cock.latte.core.net.interceptors.DebugInterceptor;
import com.cock.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class FastEcApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://127.0.0.1/")
                .withLoaderDelayed(3000)
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .configure();
    }
}
