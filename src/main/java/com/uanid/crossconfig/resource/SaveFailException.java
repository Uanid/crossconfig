package com.uanid.crossconfig.resource;

import com.uanid.crossconfig.exception.ConfigException;

public class SaveFailException extends ConfigException {
    public SaveFailException() {
    }

    public SaveFailException(String message) {
        super(message);
    }

    public SaveFailException(String message, Throwable cause) {
        super(message, cause);
    }

    public SaveFailException(Throwable cause) {
        super(cause);
    }

    public SaveFailException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
