package com.uanid.crossconfig.util;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author uanid
 * @since 2019-06-16
 */
public class StringUtils {

    public static String convertListToString(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static List<String> convertLowerCaseList(List<String> lines) {
        return lines.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
    }

    public static String withoutBlanks(String s) {
        return s.replace(" ", "");
    }

    public static String withoutNull(String s) {
        return s == null ? "" : s;
    }
}
