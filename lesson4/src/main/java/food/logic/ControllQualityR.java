package food.logic;

import food.extend.RFood;
import food.extend.StorageR;
import java.util.ArrayList;
/**
 * Class for sort Rfoods.
 */
public class ControllQualityR
{
    private ArrayList<StorageR> storeges =  new ArrayList<StorageR>();
    /**
     *Method for start logic.
     */
    public void action(RFood food){
        boolean flag =false;
        for(StorageR storage : this.storeges){
            if(storage.isAppropriate(food)){
                storage.add(food);
                flag = true;
                break;
            }
        }
    }
    /**
     * This method add object of Storage to the Storage's list.
     * @param storage - Shop , Warhous or Trash and ect.
     */
    public void addStorage(StorageR storage){
        this.storeges.add(storage);
    }

    public ArrayList<StorageR> getStoreges() {
        return storeges;
    }
}
