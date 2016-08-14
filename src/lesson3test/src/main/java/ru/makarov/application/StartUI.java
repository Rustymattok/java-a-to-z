package ru.makarov.application;

import ru.makarov.application.logic.ValidationKey;
import ru.makarov.application.logicui.LogicStart;
import ru.makarov.application.logicui.ShowInterface;
/**
 * Start application.
 */
public class StartUI {
    public static void main(String[] args) {
        //-d C:\JAVA\test -n *.txt -m -o log.txt
        // \S+\.txt";
        ShowInterface showInterface = new ShowInterface();
        showInterface.showMenu();
        ValidationKey validationKey = new ValidationKey(showInterface.enterText());
        LogicStart logicStart = new LogicStart(validationKey,showInterface);
        logicStart.action();
    }
}
