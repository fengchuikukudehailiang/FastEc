package com.cock.fastec.generators;

import com.cock.latte.annotations.PayEntryGenerator;
import com.cock.latte.core.wechat.templates.WXPayEntryTemplate;

@SuppressWarnings("unused")
@PayEntryGenerator(
        packageName = "com.cock.fastec",
        payEntryTemplate = WXPayEntryTemplate.class
)
public interface WeChatPayEntry {
}
