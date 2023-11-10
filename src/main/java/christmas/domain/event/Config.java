package christmas.domain.event;

enum Config {

    YEAR(2023),
    MINIMUM_ENTIRE_PRICE_FOR_EVENT(10000);

    private final int value;

    Config(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
