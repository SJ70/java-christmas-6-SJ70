package christmas.domain.event.giftEvent;

import christmas.domain.menuItem.MenuItem;
import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChampagneGiftEventTest {

    private final ChampagneGiftEvent CHAMPAGNE_GIFT_EVENT = new ChampagneGiftEvent();
    private final LocalDate DATE = LocalDate.of(2023, 12, 1);

    @DisplayName("총 주문 금액이 12만원 미만이라면 아무것도 받지 못 한다.")
    @Test
    void getGiftFail() {
        // given
        Order order = Order.fromOrderItemDTOs(
                List.of(
                        new OrderItemDTO("양송이수프", 1)
                )
        );

        // when
        Optional<MenuItem> gift = CHAMPAGNE_GIFT_EVENT.getGiftMenuItem(order, DATE);

        // then
        Assertions.assertThat(gift)
                .isEmpty();
    }

    @DisplayName("총 주문 금액이 12만원 이상이라면 샴페인을 받는다.")
    @Test
    void getGift() {
        // given
        Order order = Order.fromOrderItemDTOs(
                List.of(
                        new OrderItemDTO("양송이수프", 20)
                )
        );

        // when
        Optional<MenuItem> gift = CHAMPAGNE_GIFT_EVENT.getGiftMenuItem(order, DATE);

        // then
        Assertions.assertThat(gift)
                .isEqualTo(MenuItem.CHAMPAGNE);
    }

}