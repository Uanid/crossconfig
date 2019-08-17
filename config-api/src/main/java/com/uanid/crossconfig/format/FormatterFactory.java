package com.uanid.crossconfig.format;

public interface FormatterFactory {
    Formatter newInstance();

    FormatterType getFormatterType();

}
