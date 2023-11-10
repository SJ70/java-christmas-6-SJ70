package christmas.domain.event.discountEvent;

import christmas.domain.menuItem.MenuItemType;
import christmas.domain.order.Order;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public class WeekdayEvent implements DiscountEvent {

    private static final int DISCOUNT_AMOUNT = 2023;

    private static final List<DayOfWeek> WEEKDAY = List.of(
            DayOfWeek.SUNDAY,
            DayOfWeek.MONDAY,
            DayOfWeek.TUESDAY,
            DayOfWeek.WEDNESDAY,
            DayOfWeek.THURSDAY
    );

    @Override
    public int getDiscountAmount(Order order, LocalDate date) {
        if (isSatisfyCondition(order, date)) {
            return order.countTypeOf(MenuItemType.DESSERT) * DISCOUNT_AMOUNT;
        }
        return 0;
    }

    private boolean isSatisfyCondition(Order order, LocalDate date) {
        return isSatisfyDefaultCondition(order, date)
                && isWeekday(date.getDayOfWeek());
    }

    private boolean isWeekday(DayOfWeek dayOfWeek) {
        return WEEKDAY.contains(dayOfWeek);
    }

}
