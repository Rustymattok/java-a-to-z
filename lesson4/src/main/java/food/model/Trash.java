package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Trash.
 */
public class Trash implements Storage {
    protected ArrayList<Food> trashFood = new ArrayList<Food>();
    /**
     *
     * @param food - if ok for condition .
     * @return
     */
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() >= CONDITIONFORTRASH) {
            flag = true;
        }
        return flag;
    }
    /**
     * This method add to the list of foods food.
     * @param food
     */
    public void add(Food food) {
        trashFood.add(food);
    }

    public ArrayList<Food> getTrashFood() {
        return trashFood;
    }
}
