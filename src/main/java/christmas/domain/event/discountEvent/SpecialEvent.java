package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class SpecialEvent implements DiscountEvent {

    private static final int DISCOUNT_AMOUNT = 1000;
    private static final LocalDate CHRISTMAS = LocalDate.of(2023, 12, 25);

    @Override
    public int getDiscountAmount(Order order, LocalDate date) {
        if (isSatisfyCondition(order, date)) {
            return DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private boolean isSatisfyCondition(Order order, LocalDate date) {
        return isSatisfyDefaultCondition(order, date)
                && isStarMarkedDate(date);
    }

    private boolean isStarMarkedDate(LocalDate date) {
        return isChristmas(date) || isSunday(date);
    }

    private boolean isChristmas(LocalDate date) {
        return date.isEqual(CHRISTMAS);
    }

    private boolean isSunday(LocalDate date) {
        return date.getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

}
