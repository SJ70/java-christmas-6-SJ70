package christmas.domain.menuItem;

import static christmas.domain.menuItem.ErrorMessages.NONEXISTENT_MENU;
import static christmas.domain.menuItem.MenuItemType.APPETIZER;
import static christmas.domain.menuItem.MenuItemType.BEVERAGE;
import static christmas.domain.menuItem.MenuItemType.DESSERT;
import static christmas.domain.menuItem.MenuItemType.MAIN;

import java.util.Arrays;

public enum MenuItem {

    // <애피타이저>
    MUSHROOM_SOUP("양송이수프", APPETIZER, 6000),
    TAPAS("타파스", APPETIZER, 5500),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8000),

    // <메인>
    T_BONE_STEAK("티본스테이크", MAIN, 55000),
    BBQ_RIBS("바비큐립", MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25000),

    // <디저트>
    CHOCOLATE_CAKE("초코케이크", DESSERT, 15000),
    ICE_CREAM("아이스크림", DESSERT, 5000),

    // <음료>
    ZERO_COLA("제로콜라", BEVERAGE, 3000),
    RED_WINE("레드와인", BEVERAGE, 60000),
    CHAMPAGNE("샴페인", BEVERAGE, 25000);

    private final String name;
    private final MenuItemType type;
    private final int price;

    MenuItem(String name, MenuItemType type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuItemType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static MenuItem fromMenuName(String menuName) {
        return Arrays.stream(values())
                .filter(menuItem -> menuItem.name.equals(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(NONEXISTENT_MENU.getMessage()));
    }

}
