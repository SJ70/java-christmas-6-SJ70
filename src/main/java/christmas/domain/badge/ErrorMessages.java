package christmas.domain.badge;

enum ErrorMessages {

    INVALID_BENEFIT_AMOUNT("유효하지 않은 혜택 금액 값입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
