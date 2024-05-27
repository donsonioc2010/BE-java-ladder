package com.ladder.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringUtilsTest {

    @DisplayName("참가자의 글자수가 5글자 이상인 경우 파싱이 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"abcdef", "꽁꽁얼어붙은한강위로 고양이가 걸어다닙니다", "abcdef, ghijkl"})
    void parseStringToList_InvalidMaxLength_ExceptionThrown(String names) {
        assertThrows(
            IllegalArgumentException.class,
            () -> StringUtils.parseStringToList(names),
            "이름은 5자 이하만 가능합니다."
        );
    }

    @DisplayName("참가자의 글자수가 공백으로 이뤄진경우 이상인 경우 파싱이 실패한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "나는, 정상이지만,     ", "  , 한강이, 깨졌다"})
    void parseStringToList_InvalidMinLength_ExceptionThrown(String names) {
        assertThrows(
            IllegalArgumentException.class,
            () -> StringUtils.parseStringToList(names),
            "이름은 공백일 수 없습니다."
        );
    }

    @DisplayName("참가자의 글자수가 5글자 이하인 경우 파싱이 성공한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde", "a, b, c, d, e"})
    void parseStringToList_ValidLength_Success(String names) {
        assertDoesNotThrow(() -> StringUtils.parseStringToList(names));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "abcde"})
    void testString(String names) {
        System.out.println("|" +StringUtils.getFixString(names)+ "|");
    }
}