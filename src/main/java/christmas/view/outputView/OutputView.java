package christmas.view.outputView;

import static christmas.view.outputView.Messages.ORDER;
import static christmas.view.outputView.Messages.WELCOME;

import christmas.domain.order.dto.OrderItemDTO;
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

    public void displayOrder(List<OrderItemDTO> order) {
        output.display(ORDER.getMessage());
        output.display(OrderFormatter.formatOrderMessage(order));
    }

    public void displayError(String message) {
        output.displayError(message);
    }

}
