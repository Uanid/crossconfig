package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonFormatterProvider implements FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultJacksonJson", "JacksonJson");

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