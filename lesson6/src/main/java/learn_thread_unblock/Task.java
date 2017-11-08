package learn_thread_unblock;
/**
 * Class for sample.
 */
public class Task {

    private String name;
    private int version;
    private int id;

    public Task(String name) {
        this.name = name;
        version = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        version++;
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
