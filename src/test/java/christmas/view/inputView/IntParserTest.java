package christmas.view.inputView;

import static christmas.view.inputView.ErrorMessages.NOT_A_NUMBER;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IntParserTest {

    @DisplayName("숫자가 아닌 문자열을 숫자로 변환 시 예외가 발생한다.")
    @Test
    void parseIntWithNotANumber() {
        // given
        String value = "a";

        // when & then
        Assertions.assertThatThrownBy(() -> IntParser.parseInt(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_A_NUMBER.getMessage());
    }

    @DisplayName("문자열을 숫자로 올바르게 변환할 수 있다.")
    @Test
    void parseIntWithANumber() {
        // given
        String value = "1";

        // when
        int number = IntParser.parseInt(value);
        int expectedNumber = 1;

        // then
        Assertions.assertThat(number)
                .isEqualTo(expectedNumber);
    }

}