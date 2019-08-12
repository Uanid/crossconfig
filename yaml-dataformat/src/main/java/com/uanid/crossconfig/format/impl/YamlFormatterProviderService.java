package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProviderService;
import com.uanid.crossconfig.format.FormatterType;

public class YamlFormatterProviderService implements FormatterProviderService {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultSnakeYAML", "SnakeYaml");
    
    private YamlFormatterProviderService() {
    }

    public static YamlFormatterProviderService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Formatter getFormatterFactory() {
        return new DefaultFormatter(FORMATTER_TYPE, new YamlFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final YamlFormatterProviderService INSTANCE = new YamlFormatterProviderService();
    }
}
