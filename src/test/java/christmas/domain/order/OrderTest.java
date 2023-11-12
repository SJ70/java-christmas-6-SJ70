package christmas.domain.order;

import static christmas.domain.order.ErrorMessages.DUPLICATED_MENU_ITEMS_COUNT;
import static christmas.domain.order.ErrorMessages.ONLY_BEVERAGES;
import static christmas.domain.order.ErrorMessages.TOO_MANY_MENU_ITEMS_COUNT;

import christmas.domain.menuItem.MenuItemType;
import christmas.dto.NameAndCountDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {

    @DisplayName("중복된 메뉴로 주문을 생성 시 예외가 발생한다.")
    @Test
    void createByDuplicatedMenuItem() {
        // given
        List<NameAndCountDTO> nameAndCountDTOS = List.of(
                new NameAndCountDTO("양송이수프", 1),
                new NameAndCountDTO("양송이수프", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromNameAndCountDTOs(nameAndCountDTOS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATED_MENU_ITEMS_COUNT.getMessage());
    }

    @DisplayName("음료만 주문 시 예외가 발생한다.")
    @Test
    void createByOnlyBeverages() {
        // given
        List<NameAndCountDTO> nameAndCountDTOS = List.of(
                new NameAndCountDTO("제로콜라", 1),
                new NameAndCountDTO("레드와인", 1),
                new NameAndCountDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromNameAndCountDTOs(nameAndCountDTOS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_BEVERAGES.getMessage());
    }

    @DisplayName("메뉴의 총 수량이 20을 넘으면 예외가 발생한다.")
    @Test
    void createByTooManyMenuItems() {
        // given
        List<NameAndCountDTO> nameAndCountDTOS = List.of(
                new NameAndCountDTO("양송이수프", 10),
                new NameAndCountDTO("레드와인", 10),
                new NameAndCountDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThatThrownBy(() -> Order.fromNameAndCountDTOs(nameAndCountDTOS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_MANY_MENU_ITEMS_COUNT.getMessage());
    }

    @DisplayName("주문을 올바르게 생성할 수 있다.")
    @Test
    void createByValidMenuItems() {
        // given
        List<NameAndCountDTO> nameAndCountDTOS = List.of(
                new NameAndCountDTO("양송이수프", 2),
                new NameAndCountDTO("레드와인", 2),
                new NameAndCountDTO("샴페인", 1)
        );

        // when & then
        Assertions.assertThat(Order.fromNameAndCountDTOs(nameAndCountDTOS))
                .isInstanceOf(Order.class);
    }

    @DisplayName("총 주문 금액을 올바르게 가져올 수 있다.")
    @Test
    void getEntirePrice() {
        // given
        Order order = Order.fromNameAndCountDTOs(
                List.of(
                        new NameAndCountDTO("양송이수프", 2),
                        new NameAndCountDTO("레드와인", 1)
                )
        );

        // when
        int entirePrice = order.getEntirePrice();
        int expectedPrice = 72000;

        // then
        Assertions.assertThat(entirePrice)
                .isEqualTo(expectedPrice);
    }

    @DisplayName("선택한 음식 타입에 해당하는 음식의 수를 올바르게 셀 수 있다.")
    @Test
    void countTypeOf() {
        // given
        Order order = Order.fromNameAndCountDTOs(
                List.of(
                        new NameAndCountDTO("양송이수프", 2),
                        new NameAndCountDTO("타파스", 3),
                        new NameAndCountDTO("레드와인", 1)
                )
        );

        // when
        int appetizerCount = order.countTypeOf(MenuItemType.APPETIZER);
        int expectedCount = 5;

        // then
        Assertions.assertThat(appetizerCount)
                .isEqualTo(expectedCount);
    }

}