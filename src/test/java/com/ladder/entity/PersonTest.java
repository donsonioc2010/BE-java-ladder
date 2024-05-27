package com.ladder.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonTest {

    @DisplayName("참가자를 정상적으로 입력시에, 참가자의 리스트를 출력하는 문자열을 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "'a', 'a     \n'",
        "'b, c', 'b     c     \n'"
    })
    void getPersonToString(String names, String expected) {
        // given
        Person person = Person.of(names);

        // when
        String result = person.toString();

        // then
        Assertions.assertThat(result).isEqualTo(expected);

    }


}