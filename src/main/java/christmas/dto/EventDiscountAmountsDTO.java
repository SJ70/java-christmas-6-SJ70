package christmas.dto;

import java.util.List;

public record EventDiscountAmountsDTO(List<EventDiscountAmountDTO> discountAmountDTOs) {

    public int getTotalAmount() {
        return discountAmountDTOs.stream()
                .mapToInt(EventDiscountAmountDTO::amount)
                .sum();
    }

    public boolean isEmpty() {
        return discountAmountDTOs.isEmpty();
    }

}
