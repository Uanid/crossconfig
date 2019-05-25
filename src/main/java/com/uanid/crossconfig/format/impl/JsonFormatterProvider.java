package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProvider;
import com.uanid.crossconfig.format.FormatterType;

import java.util.ArrayList;
import java.util.List;

public class JsonFormatterProvider extends FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultJacksonJson", "JacksonJson");

    public static JsonFormatterProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private JsonFormatterProvider() {
    }

    @Override
    public Formatter getFormatter() {
        return new Formatter(FORMATTER_TYPE, new JsonFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final JsonFormatterProvider INSTANCE = new JsonFormatterProvider();
    }
}