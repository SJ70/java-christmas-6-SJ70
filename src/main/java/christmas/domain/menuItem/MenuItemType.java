package christmas.domain.menuItem;

public enum MenuItemType {

    APPETIZER("애피타이저"),
    MAIN("메인"),
    DESSERT("디저트"),
    BEVERAGE("음료");

    private final String title;

    MenuItemType(String title) {
        this.title = title;
    }

}
