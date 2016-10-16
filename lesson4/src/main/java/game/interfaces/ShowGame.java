package game.interfaces;
/**
 * Interface for show game.
 */
public  interface ShowGame {
    /**
     * This allow to shoe menu.
     */
    void showMenu();
    /**
     * This allow to show field of game.
     */
    void showField();
    /**
     * This allow to show who win.
     * @param person
     */
    void showVictory(Person person);
}
