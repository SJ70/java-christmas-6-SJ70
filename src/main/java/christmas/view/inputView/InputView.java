package christmas.view.inputView;

import static christmas.view.inputView.Messages.INPUT_ORDER;
import static christmas.view.inputView.Messages.INPUT_VISIT_DATE;

import christmas.dto.NameAndCountDTO;
import christmas.view.Input;
import christmas.view.Output;
import java.util.List;

public class InputView {

    private final Input input;
    private final Output output;

    public InputView(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public int inputVisitDay() {
        output.display(INPUT_VISIT_DATE.getMessage());
        return inputNumber();
    }

    public List<NameAndCountDTO> inputOrder() {
        output.display(INPUT_ORDER.getMessage());
        return OrderParser.parseOrder(input());
    }

    private int inputNumber() {
        return IntParser.parseInt(input());
    }

    private String input() {
        return input.input();
    }

}
