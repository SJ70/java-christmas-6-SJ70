package christmas.controller;

import static christmas.controller.ErrorMessages.INVALID_DATE_INPUT;
import static christmas.controller.ErrorMessages.INVALID_ORDER_INPUT;

import christmas.domain.order.Order;
import christmas.domain.visitDate.VisitDate;
import christmas.view.inputView.InputView;
import christmas.view.outputView.OutputView;

public class PromotionController {

    private final InputView inputView;
    private final OutputView outputView;

    public PromotionController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.displayWelcomeMessage();
        VisitDate visitDate = requestInputVisitDate();
        Order order = requestInputOrder();
    }

    private VisitDate requestInputVisitDate() {
        while (true) {
            try {
                return VisitDate.fromDay(inputView.inputVisitDay());
            } catch (IllegalArgumentException e) {
                outputView.displayError(INVALID_DATE_INPUT.getMessage());
            }
        }
    }

    private Order requestInputOrder() {
        while (true) {
            try {
                return Order.fromOrderItemDTOs(inputView.inputOrder());
            } catch (IllegalArgumentException e) {
                outputView.displayError(INVALID_ORDER_INPUT.getMessage());
            }
        }
    }

}
