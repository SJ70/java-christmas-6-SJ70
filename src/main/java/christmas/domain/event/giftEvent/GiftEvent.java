package christmas.domain.event.giftEvent;

import christmas.domain.event.Event;
import christmas.domain.menuItem.MenuItem;
import christmas.domain.order.Order;
import java.time.LocalDate;
import java.util.Optional;

public interface GiftEvent extends Event {

    Optional<MenuItem> getGiftMenuItem(Order order, LocalDate date);

}
