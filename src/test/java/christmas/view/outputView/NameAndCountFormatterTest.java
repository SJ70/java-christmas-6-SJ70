package christmas.view.outputView;

import static christmas.view.outputView.Messages.NOTHING;

import christmas.dto.NameAndCountDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameAndCountFormatterTest {

    @DisplayName("이름과 수량 문자열 포맷을 올바르게 수행한다.")
    @Test
    void formatNameAndCountMessageSuccess() {
        // given
        List<NameAndCountDTO> order = List.of(
                new NameAndCountDTO("음식1", 1),
                new NameAndCountDTO("음식2", 2),
                new NameAndCountDTO("음식3", 3)
        );

        // when
        String result = NameAndCountFormatter.format(order);
        String expectedResult = "음식1 1개\n음식2 2개\n음식3 3개";

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
        String result = NameAndCountFormatter.format(order);

        // then
        Assertions.assertThat(result)
                .isEqualTo(NOTHING.getMessage());
    }

}