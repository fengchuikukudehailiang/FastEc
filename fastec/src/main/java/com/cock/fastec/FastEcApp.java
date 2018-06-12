package com.cock.fastec;

import android.app.Application;

import com.cock.latte.core.app.Latte;
import com.cock.latte.ec.icon.FontEcModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class FastEcApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())
                .withApiHost("http://www.baidu.com")
                .withLoaderDelayed(3000)
                .configure();
    }
}
