package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for Trash.
 */
public class Trash extends Storage  {
    protected ArrayList<Food> trashFood = new ArrayList<Food>();

    public Trash(ArrayList<Food> foodList) {
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
        if(getFoodList().get(i).calculateDay() >= CONDITIONFORTRASH) {
            flag = true;
        }
        return flag;
    }
    /**
     * Method for add to list rsult.
     */
    @Override
    public void add() {
        for (int i = 0; i < getFoodList().size(); i++) {
            if (isAppropriate(i)) {
                trashFood.add(getFoodList().get(i));
            }
        }
    }

    public ArrayList<Food> getTrashFood() {
        return trashFood;
    }
}
