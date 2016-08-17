package compare;
/**
 * Class for init application.
 */
public class StartUI {
    public static void main(String[] args) {
        Number number1 = new Number();
        Number number2 = new Number();
        Number number3 = new Number();
        Logic logic = new Logic();
        logic.setNumber(logic.compare(number1,number2,number3));
        logic.show();
    }
}

