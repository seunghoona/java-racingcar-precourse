package racinggame;

public class Car implements Comparable<Car> {
    private static final int CAR_NAME_MAX_RANGE = 5;

    private final String name;
    private int position;

    public Car(String name) {
        validationCarNameRangeCheck(name);
        this.position = 0;
        this.name = name;
    }

    private void validationCarNameRangeCheck(String name) {
        if (isNotExceedCarName(name)) {
            throw new IllegalArgumentException("[ERROR] 이름은 5자 이내로 작성해야합니다.");
        }
    }

    private boolean isNotExceedCarName(String name) {
        return name.length() > CAR_NAME_MAX_RANGE;
    }

    public CarStatus play(int randomNumber) {
        if (randomNumber >= 4) {
            position++;
            return CarStatus.MOVING_FORWARD;
        }
        return CarStatus.STOP;
    }

    @Override
    public String toString() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Car o) {
        if (this.getPosition() > o.getPosition()) {
            return 1;
        }
        if (this.getPosition() < o.getPosition()) {
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        Car car = (Car) o;
        return position == car.position;
    }

}
