package com.uanid.crossconfig.util;

import java.util.Objects;

public class Validate {
    public static void notNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }
}
