package christmas.view.inputView;

import static christmas.view.inputView.Messages.INPUT_VISIT_DATE;

import christmas.view.Input;
import christmas.view.Output;

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

    private int inputNumber() {
        return IntParser.parseInt(input());
    }

    private String input() {
        return input.input();
    }

}
