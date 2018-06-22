package com.cock.fastec.generators;

import com.cock.latte.annotations.EntryGenerator;
import com.cock.latte.core.wechat.templates.WXEntryTemplate;

@SuppressWarnings("unused")
@EntryGenerator(
        packageName = "com.cock.fastec",
        entryTemplete = WXEntryTemplate.class
)
public interface WeChatEntry {
}
