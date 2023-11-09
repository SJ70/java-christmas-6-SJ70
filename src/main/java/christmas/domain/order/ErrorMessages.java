package christmas.domain.order;

import static christmas.domain.order.Config.MENU_ITEMS_MAX_COUNT;
import static christmas.domain.order.Config.MENU_ITEM_MIN_COUNT;

enum ErrorMessages {

    DUPLICATED_MENU_ITEMS_COUNT("중복된 메뉴가 존재합니다."),

    ONLY_BEVERAGES("음료만 주문할 수 없습니다."),

    TOO_LEAST_MENU_ITEM_COUNT(String.format(
            "메뉴 당 수량은 %d개 이상이어야 합니다.",
            MENU_ITEM_MIN_COUNT.getValue()
    )),

    TOO_MANY_MENU_ITEMS_COUNT(String.format(
            "메뉴는 한 번에 최대 %d개까지만 주문할 수 있습니다.",
            MENU_ITEMS_MAX_COUNT.getValue()
    ));

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
