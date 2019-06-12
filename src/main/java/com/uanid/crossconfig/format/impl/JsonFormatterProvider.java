package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProvider;
import com.uanid.crossconfig.format.FormatterType;

public class JsonFormatterProvider implements FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultJacksonJson", "JacksonJson");

    static {
        System.out.println("JSON 제공자 초기화됨");
    }

    public static JsonFormatterProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private JsonFormatterProvider() {
    }

    @Override
    public Formatter getFormatter() {
        return new DefaultFormatter(FORMATTER_TYPE, new JsonFormatHandler());
    }

    @Override
    public FormatterType getFormatterReturnType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final JsonFormatterProvider INSTANCE = new JsonFormatterProvider();
    }
}