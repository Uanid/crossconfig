package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

/**
 * @author uanid
 * @since 2019-05-19
 */
public class NotParsableException extends ConfigException {
    public NotParsableException(String s, Throwable th) {
        super(s, th);
    }
}
