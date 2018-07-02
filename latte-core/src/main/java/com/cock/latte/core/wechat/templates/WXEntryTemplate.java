package com.cock.latte.core.wechat.templates;


import com.cock.latte.core.wechat.BaseWXEntryActivity;
import com.cock.latte.core.wechat.LatteWeChat;

public class WXEntryTemplate extends BaseWXEntryActivity {

    @Override
    protected void onResume() {
        super.onResume();
       // finish();
        //overridePendingTransition(0, 0);
    }

    @Override
    protected void onSignInSuccess(String userInfo) {
        LatteWeChat.getInstance().getSignInCallback().onSignInSuccess(userInfo);
    }
}
