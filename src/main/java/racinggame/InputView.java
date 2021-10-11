package racinggame;

import nextstep.utils.Console;

import java.util.regex.Pattern;

public class InputView {
    Circuit circuit;

    public InputView() {
        circuit = new Circuit();
    }
    public void inputCar() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.");
            final String inputCar = Console.readLine();
            circuit.createCar(inputCar);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputCar();
        }
    }

    public void laps() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String laps = Console.readLine();
            validation(laps);
            circuit.start(Integer.parseInt(laps));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            laps();
        }
    }

    public void whoWinner() {
        circuit.whoWinner();
    }

    private static void validation(String laps) {
        if (!Pattern.matches("[0-9]+", laps)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야합니다.");
        }
    }

}
