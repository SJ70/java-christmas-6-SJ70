package christmas.view.inputView;

import static christmas.view.inputView.ErrorMessages.NOT_A_NUMBER;

class IntParser {

    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_A_NUMBER.getMessage());
        }
    }

}
