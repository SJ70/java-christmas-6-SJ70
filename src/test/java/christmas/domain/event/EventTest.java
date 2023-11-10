package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.domain.order.dto.OrderItemDTO;
import java.time.LocalDate;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class EventTest {

    private final Event EVENT = new Event() {
    };

    @DisplayName("모든 이벤트는 2023년 12월에만 적용될 수 있다.")
    @Nested
    class satisfyDefaultDate {

        private final Order order = Order.fromOrderItemDTOs(
                List.of(
                        new OrderItemDTO("양송이수프", 3)
                )
        );

        @DisplayName("2023년 12월이 아니라면 적용되지 않는다.")
        @Test
        void isNotSatisfyNotFor2023December() {
            // when
            LocalDate date = LocalDate.of(2023, 11, 1);

            // then
            Assertions.assertThat(EVENT.isSatisfyDefaultCondition(order, date))
                    .isFalse();
        }

        @DisplayName("2023년 12월이라면 적용될 수 있다.")
        @Test
        void isSatisfyFor2023December() {
            // when
            LocalDate date = LocalDate.of(2023, 12, 1);

            // then
            Assertions.assertThat(EVENT.isSatisfyDefaultCondition(order, date))
                    .isTrue();
        }

    }

    @DisplayName("모든 이벤트는 총 주문금액 10000원 이상 시, 적용될 수 있다.")
    @Nested
    class satisfyDefaultMinimumEntirePrice {

        private final LocalDate date = LocalDate.of(2023, 12, 1);

        @DisplayName("10000원 미만이라면 적용되지 않는다.")
        @Test
        void isNotSatisfyNotFor2023December() {
            // when
            Order order = Order.fromOrderItemDTOs(
                    List.of(
                            new OrderItemDTO("아이스크림", 1)
                    )
            );

            // then
            Assertions.assertThat(EVENT.isSatisfyDefaultCondition(order, date))
                    .isFalse();
        }

        @DisplayName("10000원 이상이라면 적용될 수 있다.")
        @Test
        void isSatisfyFor2023December() {
            // when
            Order order = Order.fromOrderItemDTOs(
                    List.of(
                            new OrderItemDTO("아이스크림", 2)
                    )
            );

            // then
            Assertions.assertThat(EVENT.isSatisfyDefaultCondition(order, date))
                    .isTrue();
        }

    }

}