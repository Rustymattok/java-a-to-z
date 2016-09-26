package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Warehouse.
 */
public class Warehouse implements Storage {
    protected ArrayList<Food> warFood = new ArrayList<Food>();
    /**
     *
     * @param food - if ok for condition .
     * @return
     */
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() <=  CONDITIONFORWARHOUS) {
            flag = true;
        }
        return flag;
    }
    /**
     * This method add to the list of foods food.
     * @param food
     */
    public void add(Food food) {
        warFood.add(food);
    }

    //todo убрать после теста

    public ArrayList<Food> getWarFood() {
        return warFood;
    }
}
