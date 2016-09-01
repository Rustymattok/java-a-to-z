package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Trash.
 */
public class Trash extends Storage  {
    protected ArrayList<Food> trashFood = new ArrayList<Food>();

    public Trash(String name,ArrayList<Food> foodList) {
        super(name,foodList);
    }
    /**
     * Method for init parameter depending of condition.
     * @param food - food for sort.
     * @return boolean.
     */
    @Override
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() >= CONDITIONFORTRASH) {
            flag = true;
        }
        return flag;
    }
    /**
     * Method for add to list rsult.
     */
    @Override
    public void add(Food food) {
            if (isAppropriate(food)) {
                trashFood.add(food);
        }
    }

    @Override
    public ArrayList<Food> getFoodList() {
        return trashFood;
    }

}
