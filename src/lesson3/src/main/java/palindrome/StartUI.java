package palindrome;
/**
 * Class for init application.
 */
public class StartUI {
    public static void main(String[] args) {
        Text text = new Text();
        Logic logic = new Logic(text);
        logic.show();
    }
}
