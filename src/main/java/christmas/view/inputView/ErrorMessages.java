package christmas.view.inputView;

enum ErrorMessages {

    NOT_A_NUMBER("숫자가 아닙니다."),
    INVALID_ORDER_ITEM_REGEX("주문 형식에 맞지 않습니다");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
