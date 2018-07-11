package com.cock.fastec;

import android.app.Application;
import android.support.annotation.Nullable;

import com.cock.fastec.event.ShareEvent;
import com.cock.latte.core.app.Latte;
import com.cock.latte.core.delegates.web.event.TestEvent;
import com.cock.latte.core.net.interceptors.DebugInterceptor;
import com.cock.latte.core.net.rx.AddCookieInterceptor;
import com.cock.latte.core.utils.callback.CallbackManager;
import com.cock.latte.core.utils.callback.CallbackType;
import com.cock.latte.core.utils.callback.IGlobalCallback;
import com.cock.latte.ec.icon.FontEcModule;
import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.mob.MobSDK;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import cn.jpush.android.api.JPushInterface;

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
                .withWeChatAppId("wxfcdcecd9df8e0faa")
                .withWeChatAppScript("a0560f75335b06e3ebea70f29ff219bf")
                .withJavascriptInterface("latte")
                .withWebEvent("test", new TestEvent())
                .withWebHost("https://www.baidu.com/")
                .withWebEvent("share", new ShareEvent())
                //添加Cookie同步拦截器
                .withInterceptor(new AddCookieInterceptor())
                .configure();
        //初始化数据库
        // DatabaseManager.getInstance().init(this);
        //log初始化
        Logger.addLogAdapter(new AndroidLogAdapter());
        //数据库查看工具
        initStetho();

        //开启极光推送
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        CallbackManager.getInstance()
                .addCallback(CallbackType.TAG_OPEN_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            //开启极光推送
                            JPushInterface.setDebugMode(true);
                            JPushInterface.resumePush(Latte.getApplicationContext());
                        }
                    }
                })
                .addCallback(CallbackType.TAG_STOP_PUSH, new IGlobalCallback() {
                    @Override
                    public void executeCallback(@Nullable Object args) {
                        if (!JPushInterface.isPushStopped(Latte.getApplicationContext())) {
                            JPushInterface.stopPush(Latte.getApplicationContext());
                        }
                    }
                });
        MobSDK.init(this);
    }

    private void initStetho() {
        Stetho.initializeWithDefaults(this);
    }

}
