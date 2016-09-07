package food.model;

import java.util.ArrayList;

public abstract class RStorage extends Storage {
    private int size;

    public RStorage() {
        super();
        this.size = size;
    }

    public abstract boolean isAppropriate(Food food);

    public int getSize() {
        return size;
    }
}
