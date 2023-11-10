package christmas.domain.event;

import christmas.domain.order.Order;
import java.time.LocalDate;
import java.time.Month;

public interface Event {

    // 이벤트의 기본 조건을 충족하는가
    default boolean isSatisfyDefaultCondition(Order order, LocalDate date) {
        return isSatisfyMinimumEntirePrice(order)
        && isWithinPromotionEventPeriod(date);
    }

    // 총 주문 금액이 10000원 이상인가
    private boolean isSatisfyMinimumEntirePrice(Order order) {
        return order.getEntirePrice() >= Config.MINIMUM_ENTIRE_PRICE_FOR_EVENT.getValue();
    }

    // 2023년 12월인가
    private boolean isWithinPromotionEventPeriod(LocalDate date) {
        return date.getYear() == Config.YEAR.getValue()
                && date.getMonth().equals(Month.DECEMBER);
    }

}
