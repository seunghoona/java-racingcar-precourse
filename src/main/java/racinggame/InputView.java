package racinggame;

import nextstep.utils.Console;

import java.util.regex.Pattern;

public class InputView {

    private static final String COMMA = "(\\w+,\\w+)|\\w+";
    private static final String LAST_NOT_COMMA = "[\\w\\d]+,$";
    private static final String ONLY_NUMBER = "[0-9]+";

    Circuit circuit;

    public InputView() {
        circuit = new Circuit();
    }
    /*
        사용자 자동차 입력시 입력 포맷 확인  pobi,bmw,tico
        허용 : pobi,bmw,tico
        exception : 콤마로 구분해서 입력하지 않는경우 한건인경우는 exception 발생하지 않음
     */
    static void validationInputCar(String inputCar) {
        if (Pattern.matches(LAST_NOT_COMMA, inputCar)) {
            throw new IllegalArgumentException("[ERROR] ,를 마지막에 입력하면 안됩니다.");
        }

        if (!Pattern.matches(COMMA, inputCar)) {
            throw new IllegalArgumentException("[ERROR] 자동차는 ,구분해서 입력해야합니다.");
        }
    }

    static void validationInputLaps(String laps) {
        if (!Pattern.matches(ONLY_NUMBER, laps)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야합니다.");
        }
    }

    public void inputCar() {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.");
            final String inputCar = Console.readLine();
            validationInputCar(inputCar);
            circuit.createCar(inputCar);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void laps() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String laps = Console.readLine();
            validationInputLaps(laps);
            circuit.start(Integer.parseInt(laps));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void whoWinner() {
        circuit.whoWinner();
    }


}
