package com.uanid.crossconfig.format;

import java.util.List;

public abstract class FormatterFactory {

    public abstract Formatter getFormatter();

    public abstract String getFormatterName();

    public abstract List<String> getFormatterAlias();
}
