package com.cock.fastec;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.cock.latte.core.delegates.LatteDelegate;

public class FastEcDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_fastec;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView) {

    }
}
