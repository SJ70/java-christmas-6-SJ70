package christmas.view.outputView;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MoneyFormatterTest {

    @DisplayName("돈을 형식에 맞게 포맷한다.")
    @ParameterizedTest
    @CsvSource(
            value = {"999:999원", "1000:1,000원", "10000:10,000원", "1000000:1,000,000원", "1000000000:1,000,000,000원"},
            delimiter = ':'
    )
    void toStringTest(int amount, String expectedResult) {
        // when
        String result = MoneyFormatter.format(amount);

        // then
        Assertions.assertThat(result)
                .isEqualTo(expectedResult);
    }

}