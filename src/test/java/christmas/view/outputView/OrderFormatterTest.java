package christmas.view.outputView;


import christmas.domain.order.dto.OrderItemDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderFormatterTest {

    @DisplayName("주문 내역 문자열 포맷을 올바르게 수행한다.")
    @Test
    void formatOrderMessageSuccess() {
        // given
        List<OrderItemDTO> order = List.of(
                new OrderItemDTO("음식1", 1),
                new OrderItemDTO("음식2", 2),
                new OrderItemDTO("음식3", 3)
        );

        // when
        String result = OrderFormatter.formatOrderMessage(order);
        String expectedResult = "음식1 1개\n음식2 2개\n음식3 3개";

        // then
        Assertions.assertThat(result)
                .isEqualTo(expectedResult);
    }

}