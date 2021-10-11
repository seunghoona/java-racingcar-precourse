package racinggame;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    void 자동차가_4이상인경우_전진() {
        Car pobi = new Car("pobi");
        assertThat(pobi.play(5)).isEqualTo(CarStatus.MOVING_FORWARD);
        assertThat(pobi.play(6)).isEqualTo(CarStatus.MOVING_FORWARD);
        assertThat(pobi.getPosition()).isEqualTo(2);
    }

    @Test
    void 자동차가_3이하인경우_정지() {
        Car pobi = new Car("pobi");
        assertThat(pobi.play(3)).isEqualTo(CarStatus.STOP);
        assertThat(pobi.play(1)).isEqualTo(CarStatus.STOP);
        assertThat(pobi.getPosition()).isEqualTo(0);
    }
}