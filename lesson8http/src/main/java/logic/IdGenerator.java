package logic;
/**
 * Class for creating individual id.
 */
public class IdGenerator {
    private long lastId = 0;

    private static IdGenerator instance = new IdGenerator();

    private IdGenerator(){}

    public static IdGenerator getInstance () {
        return instance;
    }
    /**
     * Recieve new id. This is increment.
     * @return id.
     */
    public synchronized long  getNextId() {
        lastId = lastId + 1;
        return lastId;
    }

    public synchronized void setLastId(long lastId) {
        this.lastId = lastId;
    }
}