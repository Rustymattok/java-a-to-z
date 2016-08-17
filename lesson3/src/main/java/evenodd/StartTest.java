package evenodd;
/**
 * Class for init application.
 */
public class StartTest {
    public static void main(String[] args) {
         Number number = new Number();
         Logic logic = new Logic(number);
         logic.evenOdd();
         logic.show();
    }
}
