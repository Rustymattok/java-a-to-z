package testthreadver1;
/**
 * Class discribe person and which logic should be use for it.
 */
public class Person {

    private String name;
    private Logic logic;
    private final int x = 0;
    private final int y = 0;

    public Person(String name, Logic logic) {
        this.name = name;
        this.logic = logic;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Logic getLogic() {
        return logic;
    }
}
