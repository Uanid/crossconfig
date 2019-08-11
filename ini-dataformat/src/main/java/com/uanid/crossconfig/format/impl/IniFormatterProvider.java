package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProvider;
import com.uanid.crossconfig.format.FormatterType;

public class IniFormatterProvider implements FormatterProvider {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultIni4J", "Ini4J", "INI");

    static {
        System.out.println("INI 제공자 초기화됨");
    }

    public static IniFormatterProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private IniFormatterProvider() {
    }

    @Override
    public Formatter getFormatter() {
        return new DefaultFormatter(FORMATTER_TYPE, new IniFormatHandler());
    }

    @Override
    public FormatterType getFormatterReturnType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {

        private static final IniFormatterProvider INSTANCE = new IniFormatterProvider();
    }
}
