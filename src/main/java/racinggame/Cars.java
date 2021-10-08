package racinggame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private final List<Car> cars ;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(String inputData) {
        return createCar(splitInputData(inputData));
    }

    private static List<String> splitInputData(String inputData) {
        return Arrays.asList(inputData.split(","));
    }

    private static Cars createCar(List<String> splitCars) {
        List<Car> cars = new ArrayList<>();
        for (String car : splitCars) {
            cars.add(new Car(car));
        }
        return new Cars(cars);
    }

    public int size(){
        return cars.size();
    }
}
