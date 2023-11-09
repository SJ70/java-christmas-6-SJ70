package christmas.domain.order;

import static christmas.domain.order.Config.MENU_ITEMS_MAX_COUNT;
import static christmas.domain.order.ErrorMessages.DUPLICATED_MENU_ITEMS_COUNT;
import static christmas.domain.order.ErrorMessages.ONLY_BEVERAGES;
import static christmas.domain.order.ErrorMessages.TOO_MANY_MENU_ITEMS_COUNT;

import christmas.domain.menuItem.MenuItemType;
import christmas.domain.order.dto.OrderItemDTO;
import java.util.List;

public class Order {

    private final List<OrderItem> order;

    private Order(List<OrderItem> order) {
        validateDistinct(order);
        validateOnlyBeverages(order);
        validateMenuItemsCountBelowMaximum(order);
        this.order = order;
    }

    public static Order fromOrderItemDTOs(List<OrderItemDTO> orderItemDTOs) {
        List<OrderItem> order = orderItemDTOs.stream()
                .map(OrderItem::fromOrderItemDTO)
                .toList();
        return new Order(order);
    }

    private void validateDistinct(List<OrderItem> order) {
        int distinctOrderCount = (int) order.stream()
                .map(OrderItem::getMenuName)
                .distinct()
                .count();
        if (order.size() != distinctOrderCount) {
            throw new IllegalArgumentException(DUPLICATED_MENU_ITEMS_COUNT.getMessage());
        }
    }

    private void validateOnlyBeverages(List<OrderItem> order) {
        boolean containsNotABeverage = order.stream()
                .anyMatch(orderItem -> !orderItem.getMenuType().equals(MenuItemType.BEVERAGE));
        if (!containsNotABeverage) {
            throw new IllegalArgumentException(ONLY_BEVERAGES.getMessage());
        }
    }

    private void validateMenuItemsCountBelowMaximum(List<OrderItem> order) {
        int menuItemsCount = order.stream()
                .map(OrderItem::getCount)
                .reduce(Integer::sum)
                .orElse(0);
        if (menuItemsCount > MENU_ITEMS_MAX_COUNT.getValue()) {
            throw new IllegalArgumentException(TOO_MANY_MENU_ITEMS_COUNT.getMessage());
        }
    }

}
