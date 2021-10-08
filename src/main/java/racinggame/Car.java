package racinggame;

public class Car {
    private String name;
    private static final int CAR_NAME_MAX_RANGE = 5;

    public Car(String name) {
        validationCarNameRangeCheck(name);
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

    public String getName() {
        return name;
    }
}
