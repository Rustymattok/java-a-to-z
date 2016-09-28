package food.extend;

import food.model.Trash;
/**
 * Class describe foo for TrashR.
 */
public class RTrash extends Trash implements StorageR {
    /**
     * Method for init parameter depending of condition.
     * @param food - if ok for condition .
     * @return true.
     */
    public boolean isAppropriate(RFood food) {
        boolean flag = false;
        if(food.calculateDay() >= CONDITIONFORTRASH && food.isCanReproduct()) {

            flag = true;
        }
        return flag;
    }
    /**
     * This method add to the list of foods RFood.
     * @param food
     */
    public void add(RFood food) {
        trashFood.add(food);
    }
}
