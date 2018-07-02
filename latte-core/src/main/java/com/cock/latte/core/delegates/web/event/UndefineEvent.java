package com.cock.latte.core.delegates.web.event;

import com.cock.latte.core.utils.log.LatteLogger;

public class UndefineEvent extends Event {
    @Override
    public String execute(String params) {
        LatteLogger.e("UndefineEvent", params);
        return null;
    }
}
