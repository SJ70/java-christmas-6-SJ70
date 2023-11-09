package christmas.domain.menuItem;

enum ErrorMessages {

    NONEXISTENT_MENU("존재하지 않는 메뉴입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
