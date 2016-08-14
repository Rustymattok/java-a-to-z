package ru.makarov.tracker;

import ru.makarov.tracker.start.ConsoleInput;
import ru.makarov.tracker.start.LogicUI;
import ru.makarov.tracker.start.ShowMenu;
import ru.makarov.tracker.start.Tracker;
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