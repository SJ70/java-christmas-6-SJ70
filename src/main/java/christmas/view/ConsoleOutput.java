package christmas.view;

public class ConsoleOutput implements Output {

    private final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    @Override
    public void display(String message) {
        System.out.println(message);
    }

    @Override
    public void displayError(String message) {
        System.out.println(ERROR_MESSAGE_PREFIX + message);
    }

}
