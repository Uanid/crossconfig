package com.uanid.crossconfig.util;

import java.util.InputMismatchException;
import java.util.Objects;

public class Validate {
    public static void notNull(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
    }

    public static void equal(Object o1, Object o2) {
        if (o1 != o2) {
            throw new InputMismatchException(o1 + " != " + o2);
        }
    }
}
