package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    InputView inputView;

    public InputViewTest() {
        this.inputView = new InputView();
    }

    @ParameterizedTest
    @DisplayName("마지막 콤마 추가시 Excpetion")
    @ValueSource(strings = {"123,", "1234,123,", "bmw,audi,k5,kia,"})
    void validationLastComma(String carName) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputView.validationInputCar(carName);
                })
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining(",를 마지막에 입력하면 안됩니다.");
    }

    @ParameterizedTest
    @DisplayName("자동차 입력시 콤마에 맞게 입력되는 확인")
    @ValueSource(strings = {"123,", "1234,123,", "bmw,audi,k5,kia,"})
    void validationCommaCheck() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputView.validationInputCar("123/123");
                })
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("자동차는 ,구분해서 입력해야합니다.");
    }

    @Test
    @DisplayName("정수 외 입력시 오류")
    void validationOnlyNumber() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
                    inputView.validationInputLaps("asdf");
                })
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("숫자만 입력해야합니다.");
    }


}