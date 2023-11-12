package christmas.view.outputView;

import christmas.dto.NameAndCountDTO;
import java.util.List;
import java.util.stream.Collectors;

class NameAndCountFormatter {

    private static final String ORDER_MESSAGE_FORMAT = "%s %d개";

    public static String formatNameAndCountMessages(List<NameAndCountDTO> order) {
        return order.stream()
                .map(NameAndCountFormatter::formatNameAndCountMessage)
                .collect(Collectors.joining("\n"));
    }

    private static String formatNameAndCountMessage(NameAndCountDTO orderItem) {
        return String.format(ORDER_MESSAGE_FORMAT, orderItem.menuName(), orderItem.count());
    }

}
