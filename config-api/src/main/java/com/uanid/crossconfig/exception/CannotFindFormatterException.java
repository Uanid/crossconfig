package com.uanid.crossconfig.exception;

import com.uanid.crossconfig.exception.RuntimeConfigException;

public class CannotFindFormatterException extends RuntimeConfigException {
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
