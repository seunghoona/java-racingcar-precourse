package racinggame;

import java.util.List;
import java.util.Map;

public class Circuit {

    private Cars cars;

    public void createCar(String inputCar){
        cars = Cars.of(inputCar);
    }

    public Map<Car, List<CarStatus>> start(int inputdata) {
        for (int i = 0; i < inputdata; i++) {
            cars.play();
        }
        return cars.getCarResult();
    }

}
