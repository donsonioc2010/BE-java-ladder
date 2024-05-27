package com.ladder.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {
    private static final String SPLIT_DELIMITER = ",";
    private static final int MAX_NAME_LENGTH = 5;

    private StringUtils() {}

    public static List<String> parseStringToList(String value) {
        return Arrays.stream(value.split(SPLIT_DELIMITER))
            .map(String::trim)
            .peek(StringUtils::isValid)
            .toList();
    }

    private static void isValid(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }

        validNameLength(value);
    }

    public static String getFixString(String value) {
        int valueLength = value.length();
        validNameLength(value);

        if ( valueLength == MAX_NAME_LENGTH) {
            return value;
        }

        return String.format("%-5s", value);
    }

    // Padding을 계산시, 뒤 글자가 4글자인 경우 : 뒤 1칸, 3글자 : 앞뒤 1칸, 2글자 : 앞1뒤2칸
    public static String getApplyPaddingString(String value) {
        int valueLength = value.length();
        validNameLength(value);

        if ( valueLength == MAX_NAME_LENGTH) {
            return value;
        }

        int padding = MAX_NAME_LENGTH - valueLength;
        int frontPadding = padding / 2;
        int backPadding = padding - frontPadding;
        return " ".repeat(frontPadding) + value + " ".repeat(backPadding);
    }
    private static void validNameLength(String value) {
        if (value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }
}
