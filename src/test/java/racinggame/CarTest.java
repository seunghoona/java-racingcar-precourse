package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    void 자동차_객체_생성시_이름을_출력하는지_체크() {
        Car pobi = new Car("pobi");
        Car crong = new Car("crong");
        Car honux = new Car("honux");
        assertThat(pobi.getName()).isEqualTo("pobi");
        assertThat(crong.getName()).isEqualTo("crong");
        assertThat(honux.getName()).isEqualTo("honux");
    }

    @Test
    void 자동차_이름이_5글자를_넘기면_예외처리() {

        assertThatIllegalArgumentException().isThrownBy(() -> {
                    Car pobi = new Car("pobiasdf");
                }).withMessageStartingWith("[ERROR]")
                .withMessageContaining("이름은 5자 이내로 작성해야합니다.");
    }
}