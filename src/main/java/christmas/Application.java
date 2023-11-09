package christmas;

import christmas.controller.PromotionController;
import christmas.view.ConsoleInput;
import christmas.view.ConsoleOutput;
import christmas.view.Input;
import christmas.view.inputView.InputView;
import christmas.view.Output;
import christmas.view.outputView.OutputView;

public class Application {

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        InputView inputView = new InputView(input, output);
        OutputView outputView = new OutputView(output);
        PromotionController promotionController = new PromotionController(inputView, outputView);
        promotionController.run();
    }
}
