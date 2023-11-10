package christmas.view.outputView;

import christmas.domain.order.dto.OrderItemDTO;
import java.util.List;
import java.util.stream.Collectors;

class OrderFormatter {

    private static final String ORDER_MESSAGE_FORMAT = "%s %d개";

    public static String formatOrderMessage(List<OrderItemDTO> order) {
        return order.stream()
                .map(OrderFormatter::formatOrderItemMessage)
                .collect(Collectors.joining("\n"));
    }

    private static String formatOrderItemMessage(OrderItemDTO orderItem) {
        return String.format(ORDER_MESSAGE_FORMAT, orderItem.menuName(), orderItem.count());
    }

}
