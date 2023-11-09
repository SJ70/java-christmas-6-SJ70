package christmas.view.outputView;

import static christmas.view.outputView.Messages.WELCOME;

import christmas.view.Output;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void displayWelcomeMessage() {
        output.display(WELCOME.getMessage());
    }

    public void displayError(String message) {
        output.displayError(message);
    }

}
