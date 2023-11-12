package christmas.domain.event;

import christmas.domain.menuItem.MenuItem;
import christmas.dto.NameAndCountDTO;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GiftsTest {

    @DisplayName("선물들에 대해 이름과 수량을 담는 DTO로 올바르게 반환을 할 수 있다")
    @Test
    void getNameAndCountDTO() {
        // given
        Gifts gifts = new Gifts(
                List.of(MenuItem.CHAMPAGNE, MenuItem.CHAMPAGNE, MenuItem.BBQ_RIBS, MenuItem.CHAMPAGNE)
        );

        // when
        List<NameAndCountDTO> result = gifts.getNameAndCountDTOs();
        List<NameAndCountDTO> expectedResult = List.of(
                new NameAndCountDTO(MenuItem.CHAMPAGNE.getName(), 3),
                new NameAndCountDTO(MenuItem.BBQ_RIBS.getName(), 1)
        );

        //
        Assertions.assertThat(result)
                .isEqualTo(expectedResult);
    }

}
