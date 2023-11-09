package christmas.view.inputView;

enum ErrorMessages {

    NOT_A_NUMBER("숫자가 아닙니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
