package com.uanid.crossconfig.util;

import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {

    public static String convertListToString(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static List<String> convertLowerCaseList(List<String> lines){
        return lines.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
    }
}
