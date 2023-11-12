package christmas.view.outputView;

import static christmas.view.outputView.Messages.ORDER;
import static christmas.view.outputView.Messages.WELCOME;

import christmas.dto.NameAndCountDTO;
import christmas.view.Output;
import java.util.List;

public class OutputView {

    private final Output output;

    public OutputView(Output output) {
        this.output = output;
    }

    public void displayWelcomeMessage() {
        output.display(WELCOME.getMessage());
    }

    public void displayOrder(List<NameAndCountDTO> order) {
        output.display(ORDER.getMessage());
        output.display(NameAndCountFormatter.formatNameAndCountMessages(order));
    }

    public void displayEntirePrice(int amount) {
        output.display(ORDER.getMessage());
    }

    public void displayError(String message) {
        output.displayError(message);
    }

}
