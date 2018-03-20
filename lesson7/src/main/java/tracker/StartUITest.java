package ru.makarov.tracker;

import ru.makarov.tracker.start.LogicUI;
import ru.makarov.tracker.start.ShowMenu;
import ru.makarov.tracker.start.Tracker;
import ru.makarov.tracker.start.StubInput;
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
