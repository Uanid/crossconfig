package com.uanid.crossconfig.util;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.Enumeration;
import java.util.List;

/**
 * @author uanid
 * @since 2019-06-23
 */
public class ClassProvider {

    public static boolean loadClassCode(String className) {
        try {
            Class.forName(className).getName();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
