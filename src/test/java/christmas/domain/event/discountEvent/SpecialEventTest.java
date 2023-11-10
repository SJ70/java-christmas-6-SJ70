package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SpecialEventTest {

    private final SpecialEvent SPECIAL_EVENT = new SpecialEvent();

    private final Order ORDER = Order.fromOrderItemDTOs(
            List.of(
                    new OrderItemDTO("양송이수프", 10)
            )
    );
    private final int YEAR = 2023;
    private final int MONTH = 12;

    // 2023년 12월 3일 : 일요일
    // 2023년 12월 25일 : 크리스마스
    // 6069 = 3 * 2023
    @DisplayName("평일 할인 금액을 올바르게 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,1000", "4,0", "5,0", "6,0", "7,0", "25,1000"})
    void getDiscountAmount(int day, int expectedAmount) {
        // when
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        int discountAmount = SPECIAL_EVENT.getDiscountAmount(ORDER, date);

        // then
        Assertions.assertThat(discountAmount)
                .isEqualTo(expectedAmount);
    }

}
