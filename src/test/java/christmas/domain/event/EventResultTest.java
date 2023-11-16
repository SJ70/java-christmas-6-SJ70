package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.visitDate.VisitDate;
import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.EventDiscountAmountsDTO;
import christmas.dto.NameAndCountDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EventResultTest {

    @DisplayName("총 할인 내역을 올바르게 취합한다.")
    @Test
    void getEntireEventDiscountAmounts() {
        // given
        Order order = Order.fromNameAndCountDTOs(
                List.of(
                        new NameAndCountDTO("해산물파스타", 2),
                        new NameAndCountDTO("레드와인", 1),
                        new NameAndCountDTO("초코케이크", 1)
                )
        );
        VisitDate date = VisitDate.fromDay(1);

        // when
        EventResult eventResult = EventResult.ofOrderAndDate(order, date.getDate());
        EventDiscountAmountsDTO result = eventResult.getEntireEventDiscountAmounts();
        EventDiscountAmountsDTO expectedResult = new EventDiscountAmountsDTO(
                List.of(
                        new EventDiscountAmountDTO("크리스마스 디데이 할인", 1000),
                        new EventDiscountAmountDTO("평일 할인", 0),
                        new EventDiscountAmountDTO("주말 할인", 4046),
                        new EventDiscountAmountDTO("특별 할인", 0),
                        new EventDiscountAmountDTO("증정 이벤트", 25000)
                )
        );

        // then
        Assertions.assertThat(result)
                .isEqualTo(expectedResult);
    }

}
