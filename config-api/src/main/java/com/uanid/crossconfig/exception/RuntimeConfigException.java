package com.uanid.crossconfig.exception;

/**
 * @author uanid
 * @since 2019-07-06
 */
public class RuntimeConfigException extends RuntimeException {
    public RuntimeConfigException() {
    }

    public RuntimeConfigException(String message) {
        super(message);
    }

    public RuntimeConfigException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeConfigException(Throwable cause) {
        super(cause);
    }

    public RuntimeConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
