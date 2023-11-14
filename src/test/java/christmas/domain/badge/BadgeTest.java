package christmas.domain.badge;

import static christmas.domain.badge.ErrorMessages.INVALID_BENEFIT_AMOUNT;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BadgeTest {

    @DisplayName("혜택 금액이 음수인 경우 예외가 발생한다")
    @Test
    void getBadgeByMinusAmount() {
        // given
        int amount = -1;

        // when & then
        Assertions.assertThatThrownBy(() -> Badge.fromBenefitAmount(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_BENEFIT_AMOUNT.getMessage());
    }

    @DisplayName("혜택 금액에 대해 올바른 Badge를 찾을 수 있다.")
    @ParameterizedTest
    @MethodSource("ProvideAmountsAndBadges")
    void getBadgeFromBenefitAmounts(int benefitAmount, Badge expectedBadge) {
        // when
        Badge foundBadge = Badge.fromBenefitAmount(benefitAmount);

        // then
        Assertions.assertThat(foundBadge)
                .isEqualTo(expectedBadge);
    }

    private static Stream<Arguments> ProvideAmountsAndBadges() {
        return Stream.of(
                Arguments.of(0, Badge.NONE),
                Arguments.of(4999, Badge.NONE),
                Arguments.of(5000, Badge.STAR),
                Arguments.of(9999, Badge.STAR),
                Arguments.of(10000, Badge.TREE),
                Arguments.of(19999, Badge.TREE),
                Arguments.of(20000, Badge.SANTA)
        );
    }

}
