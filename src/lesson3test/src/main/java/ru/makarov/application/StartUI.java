package ru.makarov.application;

import ru.makarov.application.logic.ValidationKey;
import ru.makarov.application.logicui.LogicStart;
import ru.makarov.application.logicui.ShowInterface;
/**
 * Start application.
 */
public class StartUI {
    private String[] key;
    private String text;

    public StartUI(String[] key) {
        this.key = key;
    }
    /**
     * This method take massive of String parameter and make common String text.
     * @return
     */
    public String getText() {
        text = "";
        for (int i = 0; i < key.length ; i++) {
            text = new StringBuilder().append(text).append(key[i]).append(" ").toString();
        }
        return text;
    }
    /**
     * Method for start application.
     * We have 2 type of application.
     * 1)If you enetered arges parameter application will start without additional entered parameters.
     * 2)If args absent application will make proposal for entering and continiue work.
     * -d C:\JAVA\test -n *.txt -m -o log.txt - for developer.
     * @param args
     */
    public static void main(String[] args) {
        //-d C:\JAVA\test -n *.txt -m -o log.txt
        ValidationKey validationKey;
        ShowInterface showInterface = new ShowInterface();
        if (args.length != 0) {
            StartUI startUI = new StartUI(args);
            validationKey = new ValidationKey(startUI.getText());
            if(!validationKey.checkText()){
                showInterface.wrongText();
                return;
            }
        }else{
            showInterface.showMenu();
            validationKey = new ValidationKey(showInterface.enterText());
        }
        LogicStart logicStart = new LogicStart(validationKey,showInterface);
        logicStart.action();
    }

}
