package christmas.domain.amount;

import java.text.DecimalFormat;

public record Amount(int amount) {

    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat("###,###,###원");

    @Override
    public String toString() {
        return MONEY_FORMAT.format(amount);
    }

}
