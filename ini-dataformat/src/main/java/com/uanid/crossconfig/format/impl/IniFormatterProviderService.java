package com.uanid.crossconfig.format.impl;

import com.uanid.crossconfig.format.DefaultFormatter;
import com.uanid.crossconfig.format.Formatter;
import com.uanid.crossconfig.format.FormatterProviderService;
import com.uanid.crossconfig.format.FormatterType;

public class IniFormatterProviderService implements FormatterProviderService {
    private static final FormatterType FORMATTER_TYPE = new FormatterType("DefaultIni4J", "Ini4J", "INI");

    static {
        System.out.println("INI 제공자 초기화됨");
    }

    public static IniFormatterProviderService getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private IniFormatterProviderService() {
    }

    @Override
    public Formatter getFormatterFactory() {
        return new DefaultFormatter(FORMATTER_TYPE, new IniFormatHandler());
    }

    @Override
    public FormatterType getFormatterType() {
        return FORMATTER_TYPE;
    }

    private static class SingletonHolder {

        private static final IniFormatterProviderService INSTANCE = new IniFormatterProviderService();
    }
}
