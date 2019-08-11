package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProvider;
import com.uanid.crossconfig.format.FormatterType;

public class YamlFormatterProvider implements FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultSnakeYAML", "SnakeYaml");
    
    private YamlFormatterProvider() {
    }

    public static YamlFormatterProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Formatter getFormatter() {
        return new DefaultFormatter(FORMATTER_TYPE, new YamlFormatHandler());
    }

    @Override
    public FormatterType getFormatterReturnType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final YamlFormatterProvider INSTANCE = new YamlFormatterProvider();
    }
}
