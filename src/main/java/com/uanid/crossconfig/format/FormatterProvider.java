package com.uanid.crossconfig.format;

import java.util.List;

public abstract class FormatterProvider {

    public abstract Formatter getFormatter();

    public abstract FormatterType getFormatterType();
}
