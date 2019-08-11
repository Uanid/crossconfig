package com.uanid.crossconfig.util;

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
