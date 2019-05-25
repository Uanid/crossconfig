package com.uanid.crossconfig.format;

import com.uanid.crossconfig.exception.ConfigException;

/**
 * @author uanid
 * @since 2019-05-19
 */
public class DumpFailException extends ConfigException {
    public DumpFailException(String s) {
        super(s);
    }

    public DumpFailException(String s, Throwable th) {
        super(s, th);
    }
}
