package tracker;


import tracker.start.LogicUI;
import tracker.start.ShowMenu;
import tracker.start.StubInput;
import tracker.start.Tracker;

/**
 * Start aplication without enetering parameters.
 */
public class StartUITest {
    public static void main(String[] args) {
        ShowMenu menu = new ShowMenu();
        Tracker tracker = new Tracker();
        StubInput input = new StubInput();
        menu.showInfo();
        LogicUI logicUI = new LogicUI(tracker,input,menu);
        logicUI.acton();
    }
}
