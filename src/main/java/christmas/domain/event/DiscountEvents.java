package christmas.domain.event;

import christmas.domain.event.discountEvent.ChristmasDDayEvent;
import christmas.domain.event.discountEvent.DiscountEvent;
import christmas.domain.event.discountEvent.SpecialEvent;
import christmas.domain.event.discountEvent.WeekdayEvent;
import christmas.domain.event.discountEvent.WeekendEvent;
import christmas.domain.order.Order;
import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.EventDiscountAmountsDTO;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public enum DiscountEvents {

    CHRISTMAS_D_DAY_EVENT("크리스마스 디데이 할인", new ChristmasDDayEvent()),
    WEEKDAY_EVENT("평일 할인", new WeekdayEvent()),
    WEEKEND_EVENT("주말 할인", new WeekendEvent()),
    SPECIAL_EVENT("특별 할인", new SpecialEvent());

    private final String title;
    private final DiscountEvent event;

    DiscountEvents(String title, DiscountEvent event) {
        this.title = title;
        this.event = event;
    }

    public static EventDiscountAmountsDTO getDiscountDetails(Order order, LocalDate date) {
        List<EventDiscountAmountDTO> discountDetails = Arrays.stream(values())
                .map(discountEvent -> new EventDiscountAmountDTO(
                        discountEvent.title,
                        discountEvent.event.getDiscountAmount(order, date)
                ))
                .toList();
        return new EventDiscountAmountsDTO(discountDetails);
    }

}
