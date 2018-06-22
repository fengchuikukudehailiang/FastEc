package com.cock.fastec.generators;

import com.cock.latte.annotations.AppRegisterGenerator;
import com.cock.latte.core.wechat.templates.WXPayEntryTemplate;

@SuppressWarnings("unused")
@AppRegisterGenerator(
        packageName = "com.cock.fastec",
        registerTemplate = WXPayEntryTemplate.class
)
public interface AppRegister {
}
