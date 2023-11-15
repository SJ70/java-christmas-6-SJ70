package christmas.view.outputView;

import java.text.DecimalFormat;

final class MoneyFormatter {

    private static final DecimalFormat MONEY_FORMAT = new DecimalFormat(",###원");

    public static String format(int amount) {
        return MONEY_FORMAT.format(amount);
    }

}
