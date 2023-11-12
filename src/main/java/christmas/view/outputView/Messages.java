package christmas.view.outputView;

enum Messages {

    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    ORDER("\n<주문 메뉴>"),
    ENTIRE_PRICE("\n<할인 전 총주문 금액>");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
