package com.uanid.crossconfig.format;

public interface FormatterProvider {

    Formatter getFormatter();

    FormatterType getFormatterReturnType();
}
