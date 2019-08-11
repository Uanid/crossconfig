package com.uanid.crossconfig.exception;

/**
 * @author uanid
 * @since 2019-07-06
 */
public class NotEqualException extends RuntimeConfigException {
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
