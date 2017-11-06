package testthreadver1;
/**
 * Interfece for logic of different persons.
 */
public interface Logic {
    /**
     * Method descrive movement of person.
     */
    void movePerson();
    /**
     * Method for init of first coordinate on board.
     */
    void initPerson();
    /**
     * Random method for take direction of movment.
     * @return
     */
    MoveVariation generateRandom();
    /**
     * Check coordinate by siedes.
     * @param xP - coordinate.
     * @param yP - - coordinate.
     * @return true/fales.
     */
    boolean checkBorder(int xP, int yP);
    /**
     * Check [][] board.
     * @param xP - coordinate.
     * @param yP - coordinate.
     * @return true/false.
     */
    boolean checkLock(int xP, int yP);

}
