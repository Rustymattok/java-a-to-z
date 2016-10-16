package game.interfaces;
import game.models.Point;

import java.util.ArrayList;
/**
 * Interface for field of game.
 */
public  interface Field {
    /**
     * Initilization of gme field. Depends of realize tool.(console and ect).
     */
    void initField();
    /**
     * Get list of point's field.
     * @return list of points.
     */
    ArrayList<Point> getListPoint();

}

