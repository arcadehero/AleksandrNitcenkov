package com.epam.tc.nitcenkov.hw4.util;

import io.qameta.allure.Attachment;

public class AttachmentsUtil {
    @Attachment(type = "image/png", value = "Page screenshot")
    public static byte[] screenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
