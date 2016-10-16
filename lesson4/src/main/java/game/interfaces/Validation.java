package game.interfaces;

import game.models.Point;

/**
 * Interface for logic of Validation.
 */
public interface Validation {
    /**
     * Allow to check point in Field.
     * @param point
     * @return
     */
    boolean isEmptyField(Point point);
    /**
     * Allow to check win position in logic game.
     * @param person
     * @return
     */
    boolean isFullField(Person person);
}
