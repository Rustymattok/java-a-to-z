package game.interfaces;

import game.models.Point;
import game.models.Vision;

/**
 * Interface for Person.Computer/Player.
 */
public  interface Person {
    /**
     *  This method set point according vision.
     * @param point
     */
    void logicPerson(Point point);
    /**
     * Using in logic of game to recognize who win.
     * @return true/false.
     */
    boolean takeFlag();
    /**
     * Return name of Person.
     * @return name.
     */
    String name();
    /**
     * Rturn parametr of person in field.
     * @return vision.
     */
    Vision getVision();
}

