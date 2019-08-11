package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

public class CannotFindFormatterException extends ConfigException {
    public CannotFindFormatterException() {
    }

    public CannotFindFormatterException(String message) {
        super(message);
    }

    public CannotFindFormatterException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotFindFormatterException(Throwable cause) {
        super(cause);
    }

    public CannotFindFormatterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
