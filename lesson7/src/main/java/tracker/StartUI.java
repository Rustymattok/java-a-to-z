package tracker;


import tracker.start.ConsoleInput;
import tracker.start.LogicUI;
import tracker.start.ShowMenu;
import tracker.start.Tracker;

/**
 * Start aplication.
 */
public class StartUI {
    public static void main(String[] args) {
        ShowMenu menu = new ShowMenu();
        Tracker tracker = new Tracker();
        ConsoleInput input = new ConsoleInput();
        LogicUI logicUI = new LogicUI(tracker,input,menu);
        menu.showInfo();
        logicUI.acton();
    }
}