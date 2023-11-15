package christmas.view.outputView;

enum Messages {

    WELCOME("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다."),
    PREVIEW_FORMAT("12월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!"),
    ORDER("주문 메뉴"),
    ENTIRE_PRICE("할인 전 총주문 금액"),
    GIFTS("증정 메뉴"),
    DISCOUNT_DETAILS("혜택 내역"),
    TOTAL_DISCOUNT_AMOUNT("총혜택 금액"),
    PAYMENT_AMOUNT("할인 후 예상 결제 금액"),
    BADGE("12월 이벤트 배지"),
    TITLE_FORMAT("\n<%s>"),
    NOTHING("없음");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
