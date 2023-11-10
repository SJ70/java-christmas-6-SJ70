package christmas.domain.event.discountEvent;

import christmas.domain.menuItem.MenuItemType;
import christmas.domain.order.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekendEvent implements DiscountEvent {

    private static final int DISCOUNT_AMOUNT = 2023;

    private static final List<DayOfWeek> WEEKEND = List.of(
            DayOfWeek.FRIDAY,
            DayOfWeek.SATURDAY
    );

    @Override
    public int getDiscountAmount(Order order, LocalDate date) {
        if (isSatisfyCondition(order, date)) {
            return order.countTypeOf(MenuItemType.MAIN) * DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private boolean isSatisfyCondition(Order order, LocalDate date) {
        return isSatisfyDefaultCondition(order, date)
                && isWeekend(date.getDayOfWeek());
    }

    private boolean isWeekend(DayOfWeek dayOfWeek) {
        return WEEKEND.contains(dayOfWeek);
    }

}
