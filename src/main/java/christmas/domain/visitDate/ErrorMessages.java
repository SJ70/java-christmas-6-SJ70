package christmas.domain.visitDate;

enum ErrorMessages {

    NON_EXISTENT_DATE("존재하지 않는 날짜입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
