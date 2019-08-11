package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.exception.ConfigException;

public class LoadFailException extends ConfigException {
    public LoadFailException() {
    }

    public LoadFailException(String message) {
        super(message);
    }

    public LoadFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadFailException(Throwable cause) {
        super(cause);
    }

    public LoadFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
