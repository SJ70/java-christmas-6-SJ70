package christmas.domain.order;

enum Config {

    MENU_ITEM_MIN_COUNT(1),
    MENU_ITEMS_MAX_COUNT(20);

    private final int value;

    Config(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
