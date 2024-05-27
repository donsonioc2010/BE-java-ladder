package com.ladder.entity;

import com.ladder.config.AbstractIOTestConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderInputTest extends AbstractIOTestConfig {

    @DisplayName("높이를 입력시 문자를 입력한 경우 경우 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"'a, b, c', 'a'"})
    void of_HeightIsNotNumber_ExceptionThrown(String names, String height) {
        systemIn(String.join("\n", names, height));
        assertThatThrownBy(
            () -> {
                try (Scanner scanner = new Scanner(System.in)) {
                    LadderInput.of(new Scanner(System.in));
                }
            }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자를 입력하셔야죠 고객님...");
    }

    @DisplayName("높이를 입력시 숫자가 0이하인 경우 예외가 발생한다")
    @ParameterizedTest
    @CsvSource({"'a, b, c', '-1'"})
    void of_HeightIsNotPositiveNumber_ExceptionThrown(String names, String height) {
        systemIn(String.join("\n", names, height));
        assertThatThrownBy(
            () -> {
                try (Scanner scanner = new Scanner(System.in)) {
                    LadderInput.of(new Scanner(System.in));
                }
            }
        ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("0보다 큰 숫자를 입력해야 합니다.");
    }

    @DisplayName("높이를 입력시 양의 정수인 경우 정상통과한다")
    @ParameterizedTest
    @CsvSource({"'a, b, c', '5'"})
    void of_HeightIsPositiveNumber_Success(String names, String height) {
        // given
        systemIn(String.join("\n", names, height));

        // when
        LadderInput result = LadderInput.of(new Scanner(System.in));

        // then
        assertThat(result)
            .extracting("personNames", "height")
            .contains(names, Integer.valueOf(height));
    }
}