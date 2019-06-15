package com.uanid.crossconfig.exception;

public class DuplicatedKeyException extends ConfigException {
    public DuplicatedKeyException() {
    }

    public DuplicatedKeyException(String message) {
        super(message);
    }

    public DuplicatedKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicatedKeyException(Throwable cause) {
        super(cause);
    }

    public DuplicatedKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
