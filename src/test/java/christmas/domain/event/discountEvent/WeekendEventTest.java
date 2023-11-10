package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeekendEventTest {

    private final WeekendEvent WEEKEND_EVENT = new WeekendEvent();

    private final Order ORDER = Order.fromOrderItemDTOs(
            List.of(
                    new OrderItemDTO("양송이수프", 1),
                    new OrderItemDTO("초코케이크", 2),
                    new OrderItemDTO("제로콜라", 3),
                    // 메인
                    new OrderItemDTO("티본스테이크", 1),
                    new OrderItemDTO("바비큐립", 2)
            )
    );
    private final int YEAR = 2023;
    private final int MONTH = 12;

    // 2023년 12월 2일 : 토요일
    // 6069 = 3 * 2023
    @DisplayName("주말 할인 금액을 올바르게 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,6069", "2,6069", "3,0", "4,0", "5,0", "6,0", "7,0"})
    void getDiscountAmount(int day, int expectedAmount) {
        // when
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        int discountAmount = WEEKEND_EVENT.getDiscountAmount(ORDER, date);

        // then
        Assertions.assertThat(discountAmount)
                .isEqualTo(expectedAmount);
    }

}
