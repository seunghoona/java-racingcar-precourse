package racinggame;

import nextstep.utils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CircuitTest {
    @Test
    void 사용자가_입력한_숫자만큼_레이스_시작() {
        final String inputData  ="벤츠,아우디,람보르기니";
        Cars cars = Cars.of(inputData);
        try (MockedStatic<Randoms> randomsMockedStatic = Mockito.mockStatic(Randoms.class)) {
            randomsMockedStatic.when(() -> Randoms.pickNumberInRange(1, 9)).thenReturn(1, 4, 1, 4, 4, 1);

            Circuit circuit = new Circuit();
            circuit.createCar(inputData);
            final Map<Car, List<CarStatus>> carHistory = circuit.start(2);
            assertThat(carHistory.values()).containsExactly(Arrays.asList(CarStatus.STOP, CarStatus.MOVING_FORWARD),
                    Arrays.asList(CarStatus.MOVING_FORWARD, CarStatus.MOVING_FORWARD),
                    Arrays.asList(CarStatus.STOP, CarStatus.STOP)
            );
        }
    }
}
