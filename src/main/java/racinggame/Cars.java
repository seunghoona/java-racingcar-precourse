package racinggame;

import nextstep.utils.Randoms;

import java.util.*;

public class Cars {
    private final Map<Car, List<CarStatus>> carMaps;

    private Cars(Map<Car, List<CarStatus>> carMap) {
        this.carMaps = carMap;
    }

    public static Cars of(String inputData) {
        return createCar(splitInputData(inputData));
    }

    private static List<String> splitInputData(String inputData) {
        return Arrays.asList(inputData.split(","));
    }

    private static Cars createCar(List<String> splitCars) {
        Map<Car, List<CarStatus>> createCarMap = new LinkedHashMap<>();
        for (String carName : splitCars) {
            createCarMap.put(new Car(carName), new ArrayList<>());
        }
        return new Cars(createCarMap);
    }

    public void play() {
        for (Car car : getCreatedCars()) {
            setMoveCarHistroy(car, moveCar(car));
        }
        OutputMessage.print(getCarResult());
    }

    public Map<Car, List<CarStatus>> getCarResult() {
        return Collections.unmodifiableMap(carMaps);
    }

    private Set<Car> getCreatedCars() {
        return carMaps.keySet();
    }

    private void setMoveCarHistroy(Car car, CarStatus carStatus) {
        carMaps.get(car).add(carStatus);
    }

    private CarStatus moveCar(Car car) {
        return car.play(takeRandomNumber());
    }

    private int takeRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public int size() {
        return getCarResult().size();
    }

    public void winner() {
        List<Car> cars = new ArrayList<>(carMaps.keySet());
        final Car maxCar = Collections.max(cars);
        List<String> winnerCar = new ArrayList<>();
        for (Car car : cars) {
            isExistMaxCarEqualsCar(maxCar, winnerCar, car);
        }
        OutputMessage.print(String.join(",", winnerCar));
    }

    private void isExistMaxCarEqualsCar(Car maxCar, List<String> winnerCar, Car car) {
        if (car.equals(maxCar)) {
            winnerCar.add(car.getName());
        }
    }
}
