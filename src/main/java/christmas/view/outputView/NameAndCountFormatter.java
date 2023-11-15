package christmas.view.outputView;

import static christmas.view.outputView.Messages.NOTHING;

import christmas.dto.NameAndCountDTO;
import java.util.List;
import java.util.stream.Collectors;

final class NameAndCountFormatter {

    private static final String ORDER_MESSAGE_FORMAT = "%s %d개";

    public static String format(List<NameAndCountDTO> nameAndCountDTOs) {
        if (nameAndCountDTOs.isEmpty()) {
            return NOTHING.getMessage();
        }
        return nameAndCountDTOs.stream()
                .map(NameAndCountFormatter::format)
                .collect(Collectors.joining("\n"));
    }

    private static String format(NameAndCountDTO nameAndCountDTO) {
        return String.format(ORDER_MESSAGE_FORMAT, nameAndCountDTO.menuName(), nameAndCountDTO.count());
    }

}
