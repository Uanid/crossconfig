package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

/**
 * @author uanid
 * @since 2019-05-19
 */
public class NotDumpableException extends ConfigException {
    public NotDumpableException(String s) {
        super(s);
    }

    public NotDumpableException(String s, Throwable th) {
        super(s, th);
    }
}
