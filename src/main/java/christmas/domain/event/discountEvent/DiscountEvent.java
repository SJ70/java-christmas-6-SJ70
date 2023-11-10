package christmas.domain.event.discountEvent;

import christmas.domain.event.Event;
import christmas.domain.order.Order;
import java.time.LocalDate;

public interface DiscountEvent extends Event {

    int getDiscountAmount(Order order, LocalDate date);

}
