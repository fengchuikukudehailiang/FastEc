package com.cock.fastec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.cock.latte.core.delegates.LatteDelegate;
import com.cock.latte.core.net.RestClient;
import com.cock.latte.core.net.callback.IError;
import com.cock.latte.core.net.callback.IFailure;
import com.cock.latte.core.net.callback.ISuccess;
import com.cock.latte.core.ui.LoaderStyle;

public class FastEcDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_fastec;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {
        testRestClient();
    }

    private void testRestClient() {
        RestClient.builder()
                .url("http://www.baidu.com")
                .params("", "")
                .load(getContext(), LoaderStyle.BallPulseIndicator)
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {
                        Toast.makeText(getContext(), response, Toast.LENGTH_SHORT).show();
                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .build()
                .get();
    }
}
