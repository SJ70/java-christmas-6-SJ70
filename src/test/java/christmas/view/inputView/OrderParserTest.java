package christmas.view.inputView;

import static christmas.view.inputView.ErrorMessages.INVALID_ORDER_ITEM_REGEX;

import christmas.domain.order.dto.OrderItemDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderParserTest {

    @DisplayName("올바르지 않은 형식으로 주문 문자열을 파싱할 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"문자+1", "문자-문자", "문자-1-1", "문자-문자-1"})
    void parseOrderWithInvalidValue(String value) {
        // when & then
        Assertions.assertThatThrownBy(() -> OrderParser.parseOrder(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_ORDER_ITEM_REGEX.getMessage());
    }

    @DisplayName("주문 문자열을 올바르게 파싱할 수 있다.")
    @Test
    void parseOrderWithValidValue() {
        // given
        String value = "문자열A-1,문자열b-2,문자열3-3";

        // when
        List<OrderItemDTO> order = OrderParser.parseOrder(value);
        List<OrderItemDTO> expectedOrderItemDto = List.of(
                new OrderItemDTO("문자열A", 1),
                new OrderItemDTO("문자열b", 2),
                new OrderItemDTO("문자열3", 3)
        );

        // when & then
        Assertions.assertThat(order)
                .isEqualTo(expectedOrderItemDto);
    }

}
