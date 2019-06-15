package com.uanid.crossconfig.util;

import java.util.function.BinaryOperator;

public class CommonUtils {

    public static <T> BinaryOperator<T> getThrowingMerger() {
        return (k, v) -> {
            throw new IllegalStateException("duplicate key detected: " + k.toString());
        };
    }
}
