package christmas.view.outputView;

import static christmas.view.outputView.Messages.NOTHING;

import christmas.domain.amount.Amount;
import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.EventDiscountAmountsDTO;
import java.util.stream.Collectors;

public class EventDiscountAmountFormatter {

    private static final String MESSAGE_FORMAT = "%s: -%s";

    public static String format(EventDiscountAmountsDTO eventDiscountAmountsDTO) {
        if (eventDiscountAmountsDTO.isEmpty()) {
            return NOTHING.getMessage();
        }
        return eventDiscountAmountsDTO.discountAmountDTOs()
                .stream()
                .filter(eventDiscountAmountDTO -> eventDiscountAmountDTO.amount() > 0)
                .map(EventDiscountAmountFormatter::format)
                .collect(Collectors.joining("\n"));
    }

    public static String format(EventDiscountAmountDTO eventDiscountAmountDTO) {
        return String.format(
                MESSAGE_FORMAT,
                eventDiscountAmountDTO.eventName(),
                new Amount(eventDiscountAmountDTO.amount())
        );
    }

}
