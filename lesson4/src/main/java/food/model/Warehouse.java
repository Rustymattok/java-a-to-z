package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Warehouse.
 */
public class Warehouse extends Storage {
    protected ArrayList<Food> warFood = new ArrayList<Food>();

    public Warehouse(ArrayList<Food> foodList) {
        super(foodList);
    }
    /**
     * Method for init parameter depending of condition.
     * @param i - index of list.
     * @return
     */
    @Override
    public boolean isAppropriate(int i) {
        boolean flag = false;
        if(getFoodList().get(i).calculateDay() <= CONDITIONFORWARHOUS) {
            flag = true;
        }
        return flag;
    }
    /**
     * Method for add to list result.
     */
    @Override
    public void add() {
        for (int i = 0; i < getFoodList().size(); i++)
            if (isAppropriate(i)) {
                warFood.add(getFoodList().get(i));
            }
    }

    public ArrayList<Food> getWarFood() {
        return warFood;
    }
}
