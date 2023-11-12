package christmas.dto;

import java.util.List;

public record EventDiscountAmountsDTO(List<EventDiscountAmountDTO> discountAmountDTOs) {

    public boolean isEmpty() {
        return discountAmountDTOs.isEmpty();
    }

}
