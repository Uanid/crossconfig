package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

/**
 * @author uanid
 * @since 2019-05-19
 */
public class ParseFailException extends ConfigException {
    public ParseFailException() {
    }

    public ParseFailException(String message) {
        super(message);
    }

    public ParseFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParseFailException(Throwable cause) {
        super(cause);
    }

    public ParseFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
