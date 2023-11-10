package christmas.domain.event.giftEvent;

import christmas.domain.menuItem.MenuItem;
import christmas.domain.order.Order;
import java.time.LocalDate;
import java.util.Optional;

public class ChampagneGiftEvent implements GiftEvent {

    private static final int MINIMUM_ENTIRE_PRICE_FOR_GIFT = 120000;
    private static final MenuItem GIFT = MenuItem.CHAMPAGNE;

    @Override
    public Optional<MenuItem> getGiftMenuItem(Order order, LocalDate date) {
        if (isSatisfyCondition(order, date)) {
            return Optional.of(GIFT);
        }
        return Optional.empty();
    }

    private boolean isSatisfyCondition(Order order, LocalDate date) {
        return isSatisfyDefaultCondition(order, date)
                && isSatisfyMinimumEntirePriceForGift(order);
    }

    private boolean isSatisfyMinimumEntirePriceForGift(Order order) {
        return order.getEntirePrice() >= MINIMUM_ENTIRE_PRICE_FOR_GIFT;
    }

}
