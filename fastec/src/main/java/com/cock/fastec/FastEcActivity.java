package com.cock.fastec;

import com.cock.latte.core.activities.ProxyActivity;
import com.cock.latte.core.delegates.LatteDelegate;

public class FastEcActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new FastEcDelegate();
    }
}
