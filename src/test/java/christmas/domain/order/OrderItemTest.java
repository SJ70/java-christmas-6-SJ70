package christmas.domain.order;

import static christmas.domain.order.ErrorMessages.TOO_LEAST_MENU_ITEM_COUNT;

import christmas.domain.order.dto.OrderItemDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderItemTest {

    @DisplayName("하나의 메뉴에 대해 0개를 주문 시 예외가 발생한다.")
    @Test
    void createByDuplicatedMenuItem() {
        // given
        OrderItemDTO orderItemDTO = new OrderItemDTO("양송이수프", 0);

        // when & then
        Assertions.assertThatThrownBy(() -> OrderItem.fromOrderItemDTO(orderItemDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_LEAST_MENU_ITEM_COUNT.getMessage());
    }

    @DisplayName("하나의 메뉴에 대해 1개 이상 주문 시 주문을 성공적으로 생성한다.")
    @Test
    void createByOnlyBeverages() {
        // given
        OrderItemDTO orderItemDTO = new OrderItemDTO("양송이수프", 1);

        // when & then
        Assertions.assertThat(OrderItem.fromOrderItemDTO(orderItemDTO))
                .isInstanceOf(OrderItem.class);
    }


}
