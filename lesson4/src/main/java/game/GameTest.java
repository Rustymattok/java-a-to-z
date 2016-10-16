package game;

import game.guiconsole.FieldConsole;
import game.guiconsole.PlayerInputConsole;
import game.guiconsole.ShowGameConsole;
import game.interfaces.Validation;
import game.logic.ComputerAll;
import game.logic.TestLogic;
import game.logic.ValidationConsole;
import game.models.Computer;
import game.models.Player;
/**
 * Class for prelimery TestGame.
 */
public class GameTest {
    public static void main(String[] args) {
        FieldConsole field = new FieldConsole(3);
        Player player = new Player(field,new PlayerInputConsole().enterName());
        Computer computer = new Computer(field);
        ComputerAll computerAll = new ComputerAll(field);
        ShowGameConsole console = new ShowGameConsole(field);
        Validation validation = new ValidationConsole(field);
        TestLogic game = new TestLogic(player,console,validation,computer,computerAll);
        game.action();
    }
}

