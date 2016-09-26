package food.logic;

import food.model.Food;
import food.model.Storage;
import java.util.ArrayList;
/**
 * Class for sort foods.
 */
public class ControllQuality {
    private ArrayList<Storage> storeges =  new ArrayList<Storage>();
    /**
     *Method for start logic.
     */
    public void action(Food food){
        boolean flag =false;
        for(Storage storage : this.storeges){
            if(storage.isAppropriate(food)){
                storage.add(food);
                flag = true;
                break;
            }
        }
    }
    /**
     * This method add object of Storage to the Storage's list.
     * @param storage - Shop , Warhous or Trash.
     */
    public void addStorage(Storage storage){
        this.storeges.add(storage);
    }
}
