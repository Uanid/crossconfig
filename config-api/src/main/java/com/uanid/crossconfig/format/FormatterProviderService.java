package com.uanid.crossconfig.format;

public interface FormatterProviderService {

    FormatterFactory getFormatterFactory();

    FormatterType getFormatterType();
}
