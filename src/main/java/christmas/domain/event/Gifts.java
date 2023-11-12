package christmas.domain.event;

import christmas.domain.menuItem.MenuItem;
import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.NameAndCountDTO;
import java.util.List;

public class Gifts {

    private final List<MenuItem> gifts;

    public Gifts(List<MenuItem> gifts) {
        this.gifts = gifts;
    }

    public List<NameAndCountDTO> getNameAndCountDTOs() {
        return gifts.stream()
                .distinct()
                .map(MenuItem::getName)
                .map(name -> new NameAndCountDTO(
                        name,
                        (int) gifts.stream()
                                .map(MenuItem::getName)
                                .filter(menuItem -> menuItem.equals(name))
                                .count()
                ))
                .toList();
    }

    public int getEntireDiscount() {
        return gifts.stream()
                .mapToInt(MenuItem::getPrice)
                .sum();
    }

}
