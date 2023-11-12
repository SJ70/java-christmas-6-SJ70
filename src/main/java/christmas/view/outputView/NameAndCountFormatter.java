package christmas.view.outputView;

import static christmas.view.outputView.Messages.NOTHING;

import christmas.dto.NameAndCountDTO;
import java.util.List;
import java.util.stream.Collectors;

class NameAndCountFormatter {

    private static final String ORDER_MESSAGE_FORMAT = "%s %d개";

    public static String formatNameAndCountMessages(List<NameAndCountDTO> nameAndCountDTOs) {
        if (nameAndCountDTOs.size() == 0) {
            return NOTHING.getMessage();
        }
        return nameAndCountDTOs.stream()
                .map(NameAndCountFormatter::formatNameAndCountMessage)
                .collect(Collectors.joining("\n"));
    }

    private static String formatNameAndCountMessage(NameAndCountDTO orderItem) {
        return String.format(ORDER_MESSAGE_FORMAT, orderItem.menuName(), orderItem.count());
    }

}
