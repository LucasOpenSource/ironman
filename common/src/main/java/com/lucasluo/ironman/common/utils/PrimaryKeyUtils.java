package com.lucasluo.ironman.common.utils;

import java.util.Random;

public class PrimaryKeyUtils {

    public static long generatePrimaryKey() {
        String keyPartOne = String.valueOf(System.currentTimeMillis());
        String keyPartTwo = String.valueOf(new Random().nextInt(900) + 100);
        return Long.parseLong(keyPartOne + keyPartTwo);
    }
}
