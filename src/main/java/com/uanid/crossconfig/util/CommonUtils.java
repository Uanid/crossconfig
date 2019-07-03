package com.uanid.crossconfig.util;

import com.uanid.crossconfig.common.FlexibleByteArray;

import java.io.IOException;
import java.io.InputStream;
import java.util.function.BinaryOperator;

public class CommonUtils {

    public static <T> BinaryOperator<T> getThrowingMerger() {
        return (k, v) -> {
            throw new IllegalStateException("duplicate key detected: " + k.toString());
        };
    }

    public static byte[] toByteArray(InputStream is) throws IOException {
        FlexibleByteArray flexibleByteArray = new FlexibleByteArray();
        byte[] buffer = new byte[1024];
        int r;
        while ((r = is.read(buffer)) != -1) {
            flexibleByteArray.append(buffer, 0, r);
        }
        is.close();
        return flexibleByteArray.toByteArray();
    }
}
