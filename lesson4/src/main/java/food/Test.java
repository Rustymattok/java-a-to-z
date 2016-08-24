package food;

import food.logic.ControllQuality;
import food.logic.LogicTest;
/**
 * Class for prelimerry start application.
 */
public class Test {
    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality ();
        ShowMenu showMenu = new ShowMenu(controllQuality);
        controllQuality.action(new LogicTest().initList());
        showMenu.show();
    }
}
