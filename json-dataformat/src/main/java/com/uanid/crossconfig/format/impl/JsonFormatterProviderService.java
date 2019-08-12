package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProviderService;
import com.uanid.crossconfig.format.FormatterType;

/**
 * @author uanid
 * @since 2019-06-15
 */
public class JsonFormatterProviderService implements FormatterProviderService {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultJacksonJson", "JacksonJson");

    public static JsonFormatterProviderService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private JsonFormatterProviderService() {
    }

    @Override
    public Formatter getFormatterFactory() {
        return new DefaultFormatter(FORMATTER_TYPE, new JsonFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final JsonFormatterProviderService INSTANCE = new JsonFormatterProviderService();
    }
}