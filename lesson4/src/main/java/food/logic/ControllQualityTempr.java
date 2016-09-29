package food.logic;

import food.extend.FoodTempr;
import food.extend.StorageTempr;
import java.util.ArrayList;
/**
 * Class for sort food with temperature parameter.
 */
public class ControllQualityTempr extends ControllQualityR  {
    private ArrayList<StorageTempr> storeges =  new ArrayList<StorageTempr>();
    /**
     *Method for start logic.
     */
    public void action(FoodTempr food){
        boolean flag =false;
        for(StorageTempr storage : this.storeges){
            if(storage.isAppropriate(food)){
                storage.add(food);
                flag = true;
                break;
            }
            if( !flag){
                super.action(food);
            }
        }
    }
    /**
     * This method add object of Storage to the Storage's list.
     * @param storage - Shop , Warhous or Trash and so on.
     */
    public void addStorage(StorageTempr storage){
        this.storeges.add(storage);
    }

}
