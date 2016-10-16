package game.guiconsole;
import game.interfaces.Field;
import game.models.Point;
import game.models.Vision;

import java.util.ArrayList;
/**
 * Class describe field in cosole.
 */
public class FieldConsole implements Field {
    /**
     * @param  SIZE - parameter of field.
     * @param listPoint - list of points in field.
     */
    private int SIZE;
    private ArrayList<Point> listPoint = new ArrayList<Point>();

    public FieldConsole(int SIZE) {
        this.SIZE = SIZE;
        initField();
    }

    public void initField(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                listPoint.add(new Point(i,j, Vision.EMPTY));
            }
        }
    }

    public ArrayList<Point> getListPoint() {
        return listPoint;
    }

    public int getSIZE() {
        return SIZE;
    }

}
