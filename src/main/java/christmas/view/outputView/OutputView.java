package christmas.view.outputView;

import static christmas.view.outputView.Messages.BADGE;
import static christmas.view.outputView.Messages.DISCOUNT_DETAILS;
import static christmas.view.outputView.Messages.ENTIRE_PRICE;
import static christmas.view.outputView.Messages.GIFTS;
import static christmas.view.outputView.Messages.ORDER;
import static christmas.view.outputView.Messages.PAYMENT_AMOUNT;
import static christmas.view.outputView.Messages.PREVIEW_FORMAT;
import static christmas.view.outputView.Messages.TOTAL_DISCOUNT_AMOUNT;
import static christmas.view.outputView.Messages.WELCOME;

import christmas.domain.amount.Amount;
import christmas.dto.EventDiscountAmountsDTO;
import christmas.dto.NameAndCountDTO;
import christmas.view.Output;
import java.time.LocalDate;
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

    public void displayPreviewMessage(LocalDate date) {
        output.display(String.format(PREVIEW_FORMAT.getMessage(), date.getDayOfMonth()));
    }

    public void displayGifts(List<NameAndCountDTO> gifts) {
        output.display(GIFTS.getMessage());
        output.display(NameAndCountFormatter.formatNameAndCountMessages(gifts));
    }

    public void displayEntirePrice(String amount) {
        output.display(ENTIRE_PRICE.getMessage());
        output.display(amount);
    }

    public void displayDiscountAmounts(EventDiscountAmountsDTO discountAmounts) {
        output.display(DISCOUNT_DETAILS.getMessage());
        output.display(EventDiscountAmountFormatter.format(discountAmounts));
    }

    public void displayTotalDiscountAmount(int totalDiscountEventDiscountAmount, int totalGiftEventDiscountAmount) {
        output.display(TOTAL_DISCOUNT_AMOUNT.getMessage());
        output.display(new Amount(- totalDiscountEventDiscountAmount - totalGiftEventDiscountAmount).toString());
    }

    public void displayPaymentAmount(int entirePrice, int totalDiscountEventDiscountAmount) {
        output.display(PAYMENT_AMOUNT.getMessage());
        output.display(new Amount(entirePrice - totalDiscountEventDiscountAmount).toString());
    }

    public void displayBadge(String badgeName) {
        output.display(BADGE.getMessage());
        output.display(badgeName);
    }

    public void displayError(String message) {
        output.displayError(message);
    }

}
