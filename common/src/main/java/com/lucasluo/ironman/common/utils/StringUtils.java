package com.lucasluo.ironman.common.utils;

public final class StringUtils {

    public static boolean isEmpty(String src) {
        return src == null || src.isEmpty();
    }

    public static boolean isNullOrWhitespace(String src) {
        return isEmpty(src) || isEmpty(src.trim());
    }
}
