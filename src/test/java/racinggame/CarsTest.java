package racinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void 자동차_여러대를_생성(){
        String inputData = "bmw,벤츠,아우디";
        Cars cars = Cars.of(inputData);
        Assertions.assertThat(cars.size()).isEqualTo(3);
    }
}
