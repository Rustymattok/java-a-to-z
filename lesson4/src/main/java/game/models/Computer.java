package game.models;

import game.interfaces.Field;
import game.interfaces.Person;

/**
 * Class describe objects of computer.
 */
public class Computer implements Person {
    /**
     * @param field - work area for game.
     * @param flagGame - boolean parameter true/flase. Using in logic of game to recognize who win.
     * @param vision - this parametr for computer.
     */
    private Field field;
    private boolean flagGame ;
    private String name = "Computer";
    private Vision vision = Vision.FIELDCOMP;

    public Computer(Field field ) {
        this.field = field;
    }
    /**
     * This method set point according vision.
     * @param point
     */
    public void logicPerson(Point point) {
        for (int i = 0; i < field.getListPoint().size(); i++) {
            if (point.getX() == field.getListPoint().get(i).getX() && point.getY() == field.getListPoint().get(i).getY()){
                field.getListPoint().get(i).setRes(Vision.FIELDCOMP);
            }
        }
    }

    public boolean takeFlag() {
        setFlagGame(true);
        return flagGame;
    }

    public String name() {
        return name;
    }

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
