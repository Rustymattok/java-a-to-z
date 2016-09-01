package food.logic;

import food.model.Food;
import food.model.Storage;
import java.util.ArrayList;
/**
 * Class for sort foods.
 */
public class ControllQuality {
    private ArrayList<Storage> storeges =  new ArrayList<Storage>();
    private ArrayList<Food> list;

    public ControllQuality(ArrayList<Food> list) {
        this.list = list;
    }
    /**
     *Method for start logic.
     */
    public void action(){
        for (int i = 0; i < storeges.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                storeges.get(i).add(list.get(j));
            }
        }
    }
    /**
     * This method add object of Storage to the Storage's list.
     * @param storage - Shop , Warhous or Trash.
     */
    public void addStorage(Storage storage){
            storeges.add(storage);
    }

    public ArrayList<Storage> getStoreges() {
        return storeges;
    }

    public ArrayList<Food> getList() {
        return list;
    }
}
