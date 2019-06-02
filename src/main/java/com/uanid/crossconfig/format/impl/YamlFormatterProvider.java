package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProvider;
import com.uanid.crossconfig.format.FormatterType;

public class YamlFormatterProvider implements FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultSnakeYAML", "SnakeYaml");

    public static YamlFormatterProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private YamlFormatterProvider() {
    }

    @Override
    public Formatter getFormatter() {
        return new DefaultFormatter(FORMATTER_TYPE, new YamlFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final YamlFormatterProvider INSTANCE = new YamlFormatterProvider();
    }
}
