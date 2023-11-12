package christmas.domain.order;

import static christmas.domain.order.Config.MENU_ITEM_MIN_COUNT;
import static christmas.domain.order.ErrorMessages.TOO_LEAST_MENU_ITEM_COUNT;

import christmas.domain.menuItem.MenuItem;
import christmas.domain.menuItem.MenuItemType;
import christmas.dto.NameAndCountDTO;

public class OrderItem {

    private final MenuItem menuItem;
    private final int count;

    private OrderItem(String menuName, int count) {
        validateMenuItemCountAboveMinimum(count);
        this.menuItem = MenuItem.fromMenuName(menuName);
        this.count = count;
    }

    public static OrderItem fromNameAndCountDTO(NameAndCountDTO nameAndCountDTO) {
        return new OrderItem(
                nameAndCountDTO.menuName(),
                nameAndCountDTO.count()
        );
    }

    private void validateMenuItemCountAboveMinimum(int count) {
        if (count < MENU_ITEM_MIN_COUNT.getValue()) {
            throw new IllegalArgumentException(TOO_LEAST_MENU_ITEM_COUNT.getMessage());
        }
    }

    public String getMenuName() {
        return menuItem.getName();
    }

    public MenuItemType getMenuType() {
        return menuItem.getType();
    }

    public int getPrice() {
        return menuItem.getPrice();
    }

    public int getEntirePrice() {
        return menuItem.getPrice() * count;
    }

    public NameAndCountDTO getNameAndCountDTO() {
        return new NameAndCountDTO(menuItem.getName(), count);
    }

    public int getCount() {
        return count;
    }

}