package christmas.controller;

enum ErrorMessages {

    INVALID_DATE_INPUT("유효하지 않은 날짜입니다."),
    INVALID_ORDER_INPUT("유효하지 않은 주문입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
