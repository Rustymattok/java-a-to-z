package logic;

public class IdGenerator {
    private long lastId = 0;

    private static IdGenerator instance = new IdGenerator();

    private IdGenerator(){}

    public static IdGenerator getInstance () {
        return instance;
    }

    public long getNextId() {
        lastId = lastId + 1;
        return lastId;
    }

    public void setLastId(long lastId) {
        this.lastId = lastId;
    }
}