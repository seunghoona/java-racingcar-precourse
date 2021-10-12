package racinggame;

public enum CarStatus {
    MOVING_FORWARD(4, "-"), STOP(3, "");

    private final int moveNumber;
    private final String marker;

    CarStatus(int moveNumber, String marker) {
        this.moveNumber = moveNumber;
        this.marker = marker;
    }

    public static boolean isMove(int randomNumber) {
        return randomNumber >= MOVING_FORWARD.moveNumber;
    }

    public String marker() {
        return marker;
    }
}
