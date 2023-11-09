package christmas.domain.order;

import static christmas.domain.order.ErrorMessages.DUPLICATED_MENU_ITEMS_COUNT;
import static christmas.domain.order.ErrorMessages.ONLY_BEVERAGES;
import static christmas.domain.order.ErrorMessages.TOO_MANY_MENU_ITEMS_COUNT;

import christmas.domain.order.dto.OrderItemDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("중복된 메뉴로 주문을 생성 시 예외가 발생한다.")
    @Test
    void createByDuplicatedMenuItem() {
        // given
        List<OrderItemDTO> OrderItemDTOs = List.of(
                new OrderItemDTO("양송이수프", 1),
                new OrderItemDTO("양송이수프", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromOrderItemDTOs(OrderItemDTOs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_MENU_ITEMS_COUNT.getMessage());
    }

    @DisplayName("음료만 주문 시 예외가 발생한다.")
    @Test
    void createByOnlyBeverages() {
        // given
        List<OrderItemDTO> OrderItemDTOs = List.of(
                new OrderItemDTO("제로콜라", 1),
                new OrderItemDTO("레드와인", 1),
                new OrderItemDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromOrderItemDTOs(OrderItemDTOs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_BEVERAGES.getMessage());
    }

    @DisplayName("메뉴의 총 수량이 20을 넘으면 예외가 발생한다.")
    @Test
    void createByTooManyMenuItems() {
        // given
        List<OrderItemDTO> OrderItemDTOs = List.of(
                new OrderItemDTO("양송이수프", 10),
                new OrderItemDTO("레드와인", 10),
                new OrderItemDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromOrderItemDTOs(OrderItemDTOs))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_MANY_MENU_ITEMS_COUNT.getMessage());
    }

    @DisplayName("주문을 올바르게 생성할 수 있다.")
    @Test
    void createByValidMenuItems() {
        // given
        List<OrderItemDTO> OrderItemDTOs = List.of(
                new OrderItemDTO("양송이수프", 2),
                new OrderItemDTO("레드와인", 2),
                new OrderItemDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThat(Order.fromOrderItemDTOs(OrderItemDTOs))
                .isInstanceOf(Order.class);
    }

}