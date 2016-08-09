package ru.makarov.application;

import ru.makarov.application.logic.LogicMask;
import ru.makarov.application.logic.LogicReg;
import ru.makarov.application.logic.ValidationKey;
import ru.makarov.application.logicui.LogicUI;
import ru.makarov.application.logicui.ShowInterface;
/**
 * Start application.
 */
public class StartUI {
    public static void main(String[] args) {
        //-d C:\JAVA\test -n *.txt -m -o log.txt
        // \S+\.txt";
        LogicUI logicUI;
        ShowInterface showInterface = new ShowInterface();
        showInterface.showMenu();
        ValidationKey validationKey = new ValidationKey(showInterface.enterText());

        if(validationKey.checkLogic().equals("m") || validationKey.checkLogic().equals("f")) {
            LogicMask logicMask = new LogicMask(validationKey.logFile(), validationKey.checkMask());
            logicUI = new LogicUI(logicMask);
            logicUI.logic(validationKey.checkDir());
            if (logicMask.getMyFileVisitor().getFlag() == 0){
                showInterface.showFileAbsent();
            }
    }
        else if (validationKey.checkLogic().equals("r")){
            LogicReg logicReg = new LogicReg(validationKey.logFile(), validationKey.checkMask());
            logicUI = new LogicUI(logicReg);
            logicUI.logic(validationKey.checkDir());
            if (logicReg.getMyFileVisitor().getFlag() == 0){
                showInterface.showFileAbsent();
            }
        }
    }
}
