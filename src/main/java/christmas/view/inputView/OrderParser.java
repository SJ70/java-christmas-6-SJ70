package christmas.view.inputView;

import static christmas.view.inputView.ErrorMessages.INVALID_ORDER_ITEM_REGEX;

import christmas.domain.order.dto.OrderItemDTO;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class OrderParser {

    private static final String ORDER_DELIMITER = ",";

    private static final String ORDER_ITEM_REGEX = "^([가-힣0-9a-zA-Z]+)-(\\d+)$";
    private static final Pattern ORDER_ITEM_PATTERN = Pattern.compile(ORDER_ITEM_REGEX);

    public static List<OrderItemDTO> parseOrder(String value) {
        String[] values = value.split(ORDER_DELIMITER);
        return Arrays.stream(values)
                .map(OrderParser::parseOrderItem)
                .toList();
    }

    private static OrderItemDTO parseOrderItem(String value) {
        Matcher matcher = ORDER_ITEM_PATTERN.matcher(value);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_ORDER_ITEM_REGEX.getMessage());
        }
        String menuName = matcher.group(1);
        int count = IntParser.parseInt(matcher.group(2));
        return new OrderItemDTO(menuName, count);
    }

}
