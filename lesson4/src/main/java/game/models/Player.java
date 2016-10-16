package game.models;

import game.interfaces.Field;
import game.interfaces.Person;

/**
 * Class describe objects of player.
 */
public class Player implements Person {
    /**
     * @param field - work area for game.
     * @param flagGame - boolean parameter true/flase. Using in logic of game to recognize who win.
     * @param vision - this parametr for person.
     */
    private Field field;
    private boolean flagGame;
    private String name;
    private Vision vision = Vision.FIELDPL;

    public Player(Field field, String name) {
        this.field = field;
        this.name = name;
    }
    /**
     * This method set point according vision.
     * @param point
     */
    public void logicPerson(Point point) {
        for (int i = 0; i < field.getListPoint().size(); i++) {
            if (point.getX() == field.getListPoint().get(i).getX() && point.getY() == field.getListPoint().get(i).getY()){
                field.getListPoint().get(i).setRes(Vision.FIELDPL);
            }
        }
    }
    /**
     * Using in logic of game to recognize who win.
     * @return true/false.
     */
    public boolean takeFlag() {
        setFlagGame(true);
        return flagGame;
    }
    /**
     * Return name of Person.
     * @return name.
     */
    public String name() {
        return name;
    }
    /**
     * Rturn parametr of person in field.
     * @return vision.
     */
    public Vision getVision() {
        return vision;
    }

    public void setFlagGame(boolean flagGame) {
        this.flagGame = flagGame;
    }

    public boolean isFlagGame() {
        return flagGame;
    }
}
