package racinggame;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        inputView.inputCar();
        inputView.laps();
        inputView.whoWinner();
    }
}
