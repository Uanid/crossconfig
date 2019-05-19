package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

public class CannotFindFormatterException extends ConfigException {
    public CannotFindFormatterException(String message) {
        super(message);
    }
}
