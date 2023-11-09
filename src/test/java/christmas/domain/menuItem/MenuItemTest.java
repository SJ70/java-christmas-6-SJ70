package christmas.domain.menuItem;

import static christmas.domain.menuItem.ErrorMessages.NONEXISTENT_MENU;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MenuItemTest {

    @DisplayName("존재하지 않는 음식으로 음식을 찾을 시 예외가 발생한다.")
    @Test
    void findMenuItemByNonexistentMenuName() {
        // given
        String menuName = "파인애플피자";

        // when & then
        Assertions.assertThatThrownBy(() -> MenuItem.fromMenuName(menuName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NONEXISTENT_MENU.getMessage());
    }

    @DisplayName("음식을 올바르게 찾을 수 있다.")
    @Test
    void findMenuItemByExistentMenuName() {
        // given
        String menuName = "양송이수프";

        // when
        MenuItem foundMenuItem = MenuItem.fromMenuName(menuName);
        MenuItem expectedMenuItem = MenuItem.MUSHROOM_SOUP;

        // then
        Assertions.assertThat(foundMenuItem)
                .isEqualTo(expectedMenuItem);
    }

}
