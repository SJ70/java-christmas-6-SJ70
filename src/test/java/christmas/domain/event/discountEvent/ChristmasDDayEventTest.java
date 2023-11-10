package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ChristmasDDayEventTest {

    private final ChristmasDDayEvent CHRISTMAS_D_DAY_EVENT = new ChristmasDDayEvent();

    private final Order ORDER = Order.fromOrderItemDTOs(
            List.of(
                    new OrderItemDTO("양송이수프", 10)
            )
    );
    private final int YEAR = 2023;
    private final int MONTH = 12;

    @DisplayName("크리스마스 디데이 할인 금액을 올바르게 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,1000", "2,1100", "25,3400", "26,0", "31,0"})
    void getDiscountAmount(int day, int expectedAmount) {
        // when
        LocalDate weekendDays = LocalDate.of(YEAR, MONTH, day);
        int discountAmount = CHRISTMAS_D_DAY_EVENT.getDiscountAmount(ORDER, weekendDays);

        // then
        Assertions.assertThat(discountAmount)
                .isEqualTo(expectedAmount);
    }

}
