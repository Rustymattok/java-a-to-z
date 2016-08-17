package calculator;
/**
 * Class for start application.
 */
public class StartUI {
    public static void main(String[] args) {
        LogicUI logicUI = new LogicUI(new ShowMenuTragicCalc(),new TragicCalc());
        logicUI.action();
    }
}
