package racinggame;

import java.util.List;
import java.util.Map;

public class OutputMessage {
    static private final StringBuilder sb = new StringBuilder();

    public static void print(Map<Car, List<CarStatus>> carMaps) {
        for (Car car : carMaps.keySet()) {
            sb.append(car.getName());
            sb.append(" : ");
            sb.append(getCarPositionHistory(carMaps, car));
            sb.append("\n");
        }
        System.out.printf(sb.toString());
    }

    private static String getCarPositionHistory(Map<Car, List<CarStatus>> carMaps, Car car) {
        StringBuilder sb = new StringBuilder();
        for (CarStatus carStatus : carMaps.get(car)) {
            sb.append(carStatus.marker());
        }
        return sb.toString();
    }

    public static void print(String str) {
        System.out.printf("최종 우승자는 %s 입니다.", str);
    }
}
