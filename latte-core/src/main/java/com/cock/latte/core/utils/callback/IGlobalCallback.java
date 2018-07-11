package com.cock.latte.core.utils.callback;

import android.support.annotation.Nullable;

public interface IGlobalCallback<T> {
    void executeCallback(@Nullable T args);
}
