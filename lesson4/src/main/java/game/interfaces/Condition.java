package game.interfaces;
/**
 * Interface for conditions in validation of game.
 */
public interface Condition {
    /**
     * To check vertical - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    boolean checkVertical(Person person);
    /**
     * To check horizontal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    boolean checkHorizontal(Person person);
    /**
     * To check right diagonal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    boolean checkRight(Person person);
    /**
     * To check left diagonal - win or not.
     * @param person - player/computer
     * @return true/false.
     */
    boolean checkLeft(Person person);
}

