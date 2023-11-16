package christmas.view.outputView;

import static christmas.view.outputView.Messages.BADGE;
import static christmas.view.outputView.Messages.DISCOUNT_DETAILS;
import static christmas.view.outputView.Messages.ENTIRE_PRICE;
import static christmas.view.outputView.Messages.GIFTS;
import static christmas.view.outputView.Messages.ORDER;
import static christmas.view.outputView.Messages.PAYMENT_AMOUNT;
import static christmas.view.outputView.Messages.PREVIEW_FORMAT;
import static christmas.view.outputView.Messages.TITLE_FORMAT;
import static christmas.view.outputView.Messages.TOTAL_DISCOUNT_AMOUNT;
import static christmas.view.outputView.Messages.WELCOME;

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
        displayTitle(ORDER.getMessage());
        output.display(NameAndCountFormatter.format(order));
    }

    public void displayPreviewMessage(LocalDate date) {
        output.display(String.format(PREVIEW_FORMAT.getMessage(), date.getDayOfMonth()));
    }

    public void displayGifts(List<NameAndCountDTO> gifts) {
        displayTitle(GIFTS.getMessage());
        output.display(NameAndCountFormatter.format(gifts));
    }

    public void displayEntirePrice(int amount) {
        displayTitle(ENTIRE_PRICE.getMessage());
        output.display(MoneyFormatter.format(amount));
    }

    public void displayDiscountAmounts(EventDiscountAmountsDTO discountAmounts) {
        displayTitle(DISCOUNT_DETAILS.getMessage());
        output.display(EventDiscountAmountFormatter.format(discountAmounts));
    }

    public void displayTotalDiscountAmount(int totalDiscountEventDiscountAmount, int totalGiftEventDiscountAmount) {
        displayTitle(TOTAL_DISCOUNT_AMOUNT.getMessage());
        int totalDiscountAmount = totalDiscountEventDiscountAmount + totalGiftEventDiscountAmount;
        output.display(MoneyFormatter.format(-totalDiscountAmount));
    }

    public void displayPaymentAmount(int entirePrice, int totalDiscountEventDiscountAmount) {
        displayTitle(PAYMENT_AMOUNT.getMessage());
        int paymentAmount = entirePrice - totalDiscountEventDiscountAmount;
        output.display(MoneyFormatter.format(paymentAmount));
    }

    public void displayBadge(String badgeName) {
        displayTitle(BADGE.getMessage());
        output.display(badgeName);
    }

    private void displayTitle(String title) {
        output.display(String.format(TITLE_FORMAT.getMessage(), title));
    }

    public void displayError(String message) {
        output.displayError(message);
    }

}
