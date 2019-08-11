package com.uanid.crossconfig.exception;

/**
 * @author uanid
 * @since 2019-07-06
 */
public class DuplicatedKeyException extends RuntimeConfigException {
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
