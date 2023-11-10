package christmas.domain.event.discountEvent;

import christmas.domain.order.Order;
import java.time.LocalDate;

public class ChristmasDDayEvent implements DiscountEvent {

    private static final int MIN_DISCOUNT_AMOUNT = 1000;
    private static final int INCREASE_AMOUNT_BY_DAY = 100;
    private static final LocalDate PERIOD_START_DATE = LocalDate.of(2023, 12, 1);
    private static final LocalDate CHRISTMAS = LocalDate.of(2023, 12, 25);

    @Override
    public int getDiscountAmount(Order order, LocalDate date) {
        if (isSatisfyCondition(order, date)) {
            return MIN_DISCOUNT_AMOUNT
                    + getDaysFromPeriodStartDate(date) * INCREASE_AMOUNT_BY_DAY;
        }
        return 0;
    }

    private boolean isSatisfyCondition(Order order, LocalDate date) {
        return isSatisfyDefaultCondition(order, date)
                && isUntilChristmas(date);
    }

    private boolean isUntilChristmas(LocalDate date) {
        return !date.isAfter(CHRISTMAS);
    }

    private int getDaysFromPeriodStartDate(LocalDate date) {
        return date.getDayOfMonth() - PERIOD_START_DATE.getDayOfMonth();
    }

}
