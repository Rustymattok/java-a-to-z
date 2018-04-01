package ru.makarov.application.logicui;

import ru.makarov.application.logic.LogicMask;
import ru.makarov.application.logic.LogicReg;
import ru.makarov.application.logic.ValidationKey;
/**
 * Class for logic application. This class allow two choose type of searching of application.
 */
public class LogicStart {
    private ValidationKey validationKey;
    private ShowInterface showInterface;

    public LogicStart(ValidationKey validationKey, ShowInterface showInterface) {
        this.validationKey = validationKey;
        this.showInterface = showInterface;
    }
    /**
     * Method for choose type of searching. Using pattern strategy.
     */
    public void action() {
        LogicUI logicUI;
        if(validationKey.getText().equals(ShowInterface.EXIT)){
            return;
        }

        if (validationKey.checkLogic().equals("m") || validationKey.checkLogic().equals("f")) {
            LogicMask logicMask = new LogicMask(validationKey.logFile(), validationKey.checkMask());
            logicUI = new LogicUI(logicMask);
            logicUI.logic(validationKey.checkDir());
           if (logicMask.getMyFileVisitor().getFlag() == 0) {
                showInterface.showFileAbsent();
            }
        } else if (validationKey.checkLogic().equals("r")) {
            LogicReg logicReg = new LogicReg(validationKey.logFile(), validationKey.checkMask());
            logicUI = new LogicUI(logicReg);
            logicUI.logic(validationKey.checkDir());
            if (logicReg.getMyFileVisitor().getFlag() == 0) {
                showInterface.showFileAbsent();
            }
        }
    }
}
