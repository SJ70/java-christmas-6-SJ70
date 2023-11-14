package christmas.controller;

import static christmas.controller.ErrorMessages.INVALID_DATE_INPUT;
import static christmas.controller.ErrorMessages.INVALID_ORDER_INPUT;

import christmas.domain.badge.Badge;
import christmas.domain.amount.Amount;
import christmas.domain.event.EventResult;
import christmas.domain.order.Order;
import christmas.domain.visitDate.VisitDate;
import christmas.dto.EventDiscountAmountsDTO;
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
        outputView.displayOrder(order.getNameAndCountDTOs());

        outputView.displayPreviewMessage(visitDate.getDate());

        Amount entirePrice = new Amount(order.getEntirePrice());
        outputView.displayEntirePrice(entirePrice.toString());

        EventResult eventResult = EventResult.ofOrderAndDate(order, visitDate.getDate());
        outputView.displayGifts(eventResult.getGiftsNameAndCount());

        EventDiscountAmountsDTO eventDiscountAmountsDTO = eventResult.getEntireEventDiscountAmounts();
        outputView.displayDiscountAmounts(eventDiscountAmountsDTO);

        int totalDiscountEventDiscountAmount = eventResult.getTotalDiscountEventDiscountAmount();
        int totalGiftEventDiscountAmount = eventResult.getTotalGiftEventDiscountAmount();
        outputView.displayTotalDiscountAmount(totalDiscountEventDiscountAmount, totalGiftEventDiscountAmount);
        outputView.displayPaymentAmount(entirePrice.amount(), totalDiscountEventDiscountAmount);

        int totalBenefitAmount = totalDiscountEventDiscountAmount + totalGiftEventDiscountAmount;
        Badge badge = Badge.fromBenefitAmount(totalBenefitAmount);
        outputView.displayBadge(badge.getName());
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
                return Order.fromNameAndCountDTOs(inputView.inputOrder());
            } catch (IllegalArgumentException e) {
                outputView.displayError(INVALID_ORDER_INPUT.getMessage());
            }
        }
    }

}
