package game.logic;

import game.interfaces.Coordinate;
import game.interfaces.Field;
import game.models.Point;

import java.util.Random;

/**
 * Class describe all of computer.
 */
public class ComputerAll implements Coordinate {
    private Field field;

    public ComputerAll(Field field) {
        this.field = field;
    }
    /**
     * This method for generate point . This is walk of computer.
     * @return point.
     */
    public Point randomPoint(){
        Random random = new Random();
        int commonPoints = field.getListPoint().size();
        int index;
        index = random.nextInt(commonPoints);
        return field.getListPoint().get(index);
    }

    public Point enterText() {
        return randomPoint();
    }
}
