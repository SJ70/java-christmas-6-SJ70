package christmas.domain.visitDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

    @DisplayName("유효하지 않은 값으로 방문 날짜를 생성 시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 32})
    void createByInvalidDay(int day) {
        // when & then
        Assertions.assertThatThrownBy(() -> VisitDate.fromDay(day))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessages.NON_EXISTENT_DATE.getMessage());
    }

    @DisplayName("방문 날짜를 성공적으로 생성할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 31})
    void createByValidDay(int day) {
        // when & then
        Assertions.assertThat(VisitDate.fromDay(day))
                .isInstanceOf(VisitDate.class);
    }

}