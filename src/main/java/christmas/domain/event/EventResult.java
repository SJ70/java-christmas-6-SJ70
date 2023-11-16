package christmas.domain.event;

import christmas.domain.order.Order;
import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.EventDiscountAmountsDTO;
import christmas.dto.NameAndCountDTO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventResult {

    private static final String GIFT_EVENT_TITLE = "증정 이벤트";

    private final EventDiscountAmountsDTO discountEventDiscountAmounts;
    private final Gifts gifts;

    private EventResult(EventDiscountAmountsDTO discountEventDiscountAmounts, Gifts gifts) {
        this.discountEventDiscountAmounts = discountEventDiscountAmounts;
        this.gifts = gifts;
    }

    public static EventResult ofOrderAndDate(Order order, LocalDate date) {
        EventDiscountAmountsDTO eventDiscountAmounts = DiscountEvents.getDiscountDetails(order, date);
        Gifts gifts = GiftEvents.getGifts(order, date);
        return new EventResult(eventDiscountAmounts, gifts);
    }

    public List<NameAndCountDTO> getGiftsNameAndCount() {
        return gifts.getNameAndCountDTOs();
    }

    public EventDiscountAmountsDTO getEntireEventDiscountAmounts() {
        List<EventDiscountAmountDTO> entireEventDiscountAmounts = new ArrayList<>();
        entireEventDiscountAmounts.addAll(discountEventDiscountAmounts.discountAmountDTOs());
        entireEventDiscountAmounts.add(getGiftDiscountAmount());
        return new EventDiscountAmountsDTO(entireEventDiscountAmounts);
    }

    private EventDiscountAmountDTO getGiftDiscountAmount() {
        return new EventDiscountAmountDTO(GIFT_EVENT_TITLE, gifts.getEntireDiscount());
    }

    public int getTotalBenefitAmount() {
        return getTotalDiscountEventDiscountAmount() + getTotalGiftEventDiscountAmount();
    }

    public int getTotalDiscountEventDiscountAmount() {
        return discountEventDiscountAmounts.getTotalAmount();
    }

    public int getTotalGiftEventDiscountAmount() {
        return gifts.getEntireDiscount();
    }

}
