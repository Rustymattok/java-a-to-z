package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Warehouse.
 */
public class Warehouse extends Storage {
    protected ArrayList<Food> warFood = new ArrayList<Food>();

    public Warehouse(String name,ArrayList<Food> foodList) {
        super(name,foodList);
    }
    /**
     * Method for init parameter depending of condition.
     * @param food - food - food for sort.
     * @return
     */
    @Override
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() <=  CONDITIONFORWARHOUS) {
            flag = true;
        }
        return flag;
    }
    /**
     * Method for add to list result.
     */
    @Override
    public void add(Food food) {
            if (isAppropriate(food)) {
                warFood.add(food);
            }
    }

    @Override
    public ArrayList<Food> getFoodList() {
        return warFood;
    }

}
