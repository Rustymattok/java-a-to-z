package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Class describe logic of application.
 */
public class LogicUI {
    /**
     * @param showMenu - parameter for game.interface of show Menu.
     * @param calc - parameter for init logic of SimpleCalc.
     */
    private ShowMenu showMenu;
    private SimpleCalc calc;

    public LogicUI(ShowMenu showMenu, SimpleCalc calc) {
        this.showMenu = showMenu;
        this.calc = calc;
    }
    /**
     * Method for start of logic.
     */
    public  void action(){
        showMenu.showMenu();
        String text = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while (!text.equals(showMenu.EXIT)){
                 showMenu.chooseOperation();
                 text = bufferedReader.readLine();
                 calc.action(text,showMenu);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
