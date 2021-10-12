package racinggame;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest extends NSTest {

    @BeforeEach
    void beforeEach() {
        setUp();
    }

    @Test
    void 자동차_여러대를_생성() {
        String inputData = "bmw,벤츠,아우디";
        Cars cars = Cars.of(inputData);
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void 자동차가_랜덤한_숫자에_의해_전진_또는_정지_하는지_확인() {
        Cars cars = Cars.of("bmw,벤츠,아우디,테슬라,람보르기니");
        try (MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(-1, 3, 4, 9, 1);
            cars.play();
            final Collection<List<CarStatus>> carHistory = cars.getCarResult().values();
            assertThat(carHistory).containsExactly(Arrays.asList(CarStatus.STOP),
                    Arrays.asList(CarStatus.STOP),
                    Arrays.asList(CarStatus.MOVING_FORWARD),
                    Arrays.asList(CarStatus.MOVING_FORWARD),
                    Arrays.asList(CarStatus.STOP)
            );
        }
    }

    @Test
    void 우승자를_확인() {
        Cars cars = Cars.of("bmw,벤츠,아우디,테슬라,람보르기니");
        try (MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(-1, 3, 1, 9, 1);
            cars.play();
            final Collection<List<CarStatus>> carHistory = cars.getCarResult().values();
            assertThat(carHistory).containsExactly(Arrays.asList(CarStatus.STOP),
                    Arrays.asList(CarStatus.STOP),
                    Arrays.asList(CarStatus.STOP),
                    Arrays.asList(CarStatus.MOVING_FORWARD),
                    Arrays.asList(CarStatus.STOP)
            );
        }
        cars.winner();
        verify("최종 우승자는 테슬라 입니다.");
    }

    @Override
    protected void runMain() {
    }
}
