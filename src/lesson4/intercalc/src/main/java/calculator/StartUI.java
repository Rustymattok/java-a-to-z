package calculator;
/**
 * Class for start application.
 */
public class StartUI {
    public static void main(String[] args) {
        LogicUI logicUI = new LogicUI(new ShowMenu(),new SimpleCalc());
        logicUI.action();
    }
}
