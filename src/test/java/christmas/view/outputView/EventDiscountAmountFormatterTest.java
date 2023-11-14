package christmas.view.outputView;

import static christmas.view.outputView.Messages.NOTHING;

import christmas.dto.EventDiscountAmountDTO;
import christmas.dto.EventDiscountAmountsDTO;
import christmas.dto.NameAndCountDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventDiscountAmountFormatterTest {

    @DisplayName("이름과 금액 문자열 포맷을 올바르게 수행한다.")
    @Test
    void formatNameAndCountMessageSuccess() {
        // given
        EventDiscountAmountsDTO eventDiscountAmountsDTO = new EventDiscountAmountsDTO(
                List.of(
                        new EventDiscountAmountDTO("이벤트1", 1000),
                        new EventDiscountAmountDTO("이벤트2", 0),
                        new EventDiscountAmountDTO("이벤트3", 3000)
                )
        );

        // when
        String result = EventDiscountAmountFormatter.format(eventDiscountAmountsDTO);
        String expectedResult = "이벤트1: -1,000원\n이벤트2: -0원\n이벤트3: -3,000원";

        // then
        Assertions.assertThat(result)
                .isEqualTo(expectedResult);
    }

    @DisplayName("항목이 없다면 '없음'을 반환한다.")
    @Test
    void formatNothing() {
        // given
        List<NameAndCountDTO> order = List.of();

        // when
        String result = NameAndCountFormatter.formatNameAndCountMessages(order);

        // then
        Assertions.assertThat(result)
                .isEqualTo(NOTHING.getMessage());
    }

}