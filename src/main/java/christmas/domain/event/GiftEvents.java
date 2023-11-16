package christmas.domain.event;

import christmas.domain.event.giftEvent.ChampagneGiftEvent;
import christmas.domain.event.giftEvent.GiftEvent;
import christmas.domain.menuItem.MenuItem;
import christmas.domain.order.Order;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum GiftEvents {

    CHAMPAGNE_GIFT_EVENT("샴페인 증정 이벤트", new ChampagneGiftEvent());

    private final String title;
    private final GiftEvent event;

    GiftEvents(String title, GiftEvent event) {
        this.title = title;
        this.event = event;
    }

    public static Gifts getGifts(Order order, LocalDate date) {
        List<MenuItem> gifts = Arrays.stream(values())
                .map(giftEvent -> giftEvent.event.getGiftMenuItem(order, date))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
        return new Gifts(gifts);
    }

}
