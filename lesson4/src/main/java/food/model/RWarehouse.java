package food.model;

import java.util.ArrayList;

public class RWarehouse extends RStorage {

    private Storage storage;
    private int size;

    public RWarehouse(Storage storage, int size) {
        this.storage = storage;
        this.size = size;
    }

    @Override
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(storage.isAppropriate(food) && getFoodList().size() <= super.getSize() ){
            flag = true;
        }
        return flag;
    }

    @Override
    public void add(Food food) {
        storage.add(food);
    }

    @Override
    public ArrayList<Food> getFoodList() {
        return storage.getFoodList();
    }
}
