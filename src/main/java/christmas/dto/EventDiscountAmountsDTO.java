package christmas.dto;

import java.util.List;

public record EventDiscountAmountsDTO(List<EventDiscountAmountDTO> discountAmountDTOs) {

    public int getTotalAmount() {
        return discountAmountDTOs.stream()
                .mapToInt(EventDiscountAmountDTO::amount)
                .sum();
    }

    public EventDiscountAmountsDTO filterHasBenefit() {
        List<EventDiscountAmountDTO> eventDiscountAmountDTOsWithoutNoBenefit
                = discountAmountDTOs.stream()
                .filter(eventDiscountAmountDTO -> eventDiscountAmountDTO.amount() > 0)
                .toList();

        return new EventDiscountAmountsDTO(eventDiscountAmountDTOsWithoutNoBenefit);
    }

    public boolean isEmpty() {
        return discountAmountDTOs.isEmpty();
    }

}
