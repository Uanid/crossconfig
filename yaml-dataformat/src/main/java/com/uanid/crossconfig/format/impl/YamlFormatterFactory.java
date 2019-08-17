package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterFactory;
import com.uanid.crossconfig.format.FormatterType;

/**
 * @author uanid
 * @since 2019-08-17
 */
public class YamlFormatterFactory implements FormatterFactory {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultSnakeYAML", "SnakeYAML", "YAML");

    private YamlFormatterFactory() {
    }

    public static YamlFormatterFactory getInstance() {
        return SingletonHolder.INSTANCE;
    }

    @Override
    public Formatter newInstance() {
        return new DefaultFormatter(FORMATTER_TYPE, new YamlFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {
        private static final YamlFormatterFactory INSTANCE = new YamlFormatterFactory();
    }
}
