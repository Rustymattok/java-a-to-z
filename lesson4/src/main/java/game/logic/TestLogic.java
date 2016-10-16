package game.logic;

import game.guiconsole.PlayerInputConsole;
import game.guiconsole.ShowGameConsole;
import game.interfaces.Coordinate;
import game.interfaces.Validation;
import game.models.Computer;
import game.models.Player;
import game.models.Point;

/**
 * This class describe logic of game.
 */
public class TestLogic {
    /**
     * @param player - switch player in logic.
     * @param computer - switch computer in logic.
     * @param game - switch show of game in console.
     * @param input - switch way for enter parameters of field for player.
     * @param validate - switch logic of validation in this game.
     * @param computerAll - switch ALL of computer in logic.
     */
    private Player player;
    private Computer computer;
    private ShowGameConsole game;
    private PlayerInputConsole input = new PlayerInputConsole();
    private Validation validate ;
    private ComputerAll computerAll;

    public TestLogic(Player player,ShowGameConsole game,Validation validate,Computer computer,ComputerAll computerAll) {
        this.player = player;
        this.game = game;
        this.validate = validate;
        this.computer = computer;
        this.computerAll = computerAll;
    }
    /**
     * This method start game.
     */
    public void action(){
        game.showMenu();
        boolean flag = false;
        while(!flag) {
            game.showField();
            Point pointPlayer = input.enterText();
            player.logicPerson(cicleEnter(pointPlayer, input));
            if(validate.isFullField(player)){
                player.takeFlag();
                break;
            }
            game.turnText();
            Point pointcomputer = computerAll.randomPoint();
            computer.logicPerson(cicleEnter(pointcomputer,computerAll));
            if(validate.isFullField(computer)){
                flag = true;
                computer.takeFlag();
            }
        }
        game.showMenu();
        game.showField();
        if(player.isFlagGame()){
            game.showVictory(player);
        }else if (computer.isFlagGame()){
            game.showVictory(computer);
        }
    }
    /**
     * Method make cicle enter of parameter until ti will be correct for conditions.
     * @param point
     * @param cor
     * @return
     */
    public Point cicleEnter(Point point,Coordinate cor){
        boolean flag = true;
        while (flag){
            if( validate.isEmptyField(point)){
                flag = false;
            }
            else {
                point = cor.enterText();
            }
        }
        return point;
    }
}
