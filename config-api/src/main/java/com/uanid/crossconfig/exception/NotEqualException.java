package com.uanid.crossconfig.exception;

public class NotEqualException extends ConfigException {
    public NotEqualException() {
    }

    public NotEqualException(String message) {
        super(message);
    }

    public NotEqualException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEqualException(Throwable cause) {
        super(cause);
    }

    public NotEqualException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
