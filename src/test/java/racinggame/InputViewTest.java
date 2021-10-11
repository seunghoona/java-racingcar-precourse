package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {


    @Test
    @DisplayName("마지막 콤마 추가시 Excpetion")
    void validationLastComma() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.validationInputCar("123,");
        })
        .withMessageStartingWith("[ERROR]")
        .withMessageContaining(",를 마지막에 입력하면 안됩니다.");
    }

    @Test
    @DisplayName("자동차 입력시 콤마에 맞게 입력되는 확인")
    void validationCommaCheck() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.validationInputCar("123/123");
        })
        .withMessageStartingWith("[ERROR]")
        .withMessageContaining("자동차는 ,구분해서 입력해야합니다.");
    }

    @Test
    @DisplayName("정수 외 입력시 오류")
    void validationOnlyNumber() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            InputView.validationInputLaps("asdf");
        })
        .withMessageStartingWith("[ERROR]")
        .withMessageContaining("숫자만 입력해야합니다.");
    }


}