package part2.generic.example;
/**
 * Abstract class for Base of task.
 */
public abstract class Base {
    protected String id;

    public Base(String id) {
        this.id = id;
    }

    abstract String getId();
    abstract void setID(String id);
}