package com.cock.latte.core.delegates;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cock.latte.core.activities.ProxyActivity;

import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

public abstract class BaseDelegate extends SwipeBackFragment {


    private View mRootView = null;

    public abstract Object setLayout();

    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    public <T extends View> T $(@IdRes int viewId) {
        if (mRootView != null) {
            return mRootView.findViewById(viewId);
        }
        throw new NullPointerException("rootView is null");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
        mRootView = rootView;
        onBindView(savedInstanceState, rootView);

        return rootView;
    }

    public final ProxyActivity getProxyActivity() {
        return (ProxyActivity) _mActivity;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
