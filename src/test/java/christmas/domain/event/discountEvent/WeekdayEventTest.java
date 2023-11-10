package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeekdayEventTest {

    private final WeekdayEvent WEEKDAY_EVENT = new WeekdayEvent();

    private final Order ORDER = Order.fromOrderItemDTOs(
            List.of(
                    new OrderItemDTO("양송이수프", 1),
                    new OrderItemDTO("티본스테이크", 2),
                    new OrderItemDTO("제로콜라", 3),
                    // 디저트
                    new OrderItemDTO("초코케이크", 1),
                    new OrderItemDTO("아이스크림", 2)
            )
    );
    private final int YEAR = 2023;
    private final int MONTH = 12;

    // 2023년 12월 3일 : 일요일
    // 6069 = 3 * 2023
    @DisplayName("평일 할인 금액을 올바르게 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "2,0", "3,6069", "4,6069", "5,6069", "6,6069", "7,6069"})
    void getDiscountAmount(int day, int expectedAmount) {
        // when
        LocalDate date = LocalDate.of(YEAR, MONTH, day);
        int discountAmount = WEEKDAY_EVENT.getDiscountAmount(ORDER, date);

        // then
        Assertions.assertThat(discountAmount)
                .isEqualTo(expectedAmount);
    }

}
