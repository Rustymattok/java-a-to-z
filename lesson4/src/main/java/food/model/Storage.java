package food.model;

import java.util.ArrayList;
/**
 * Abstract class for comon porpereties of Food.
 */
public abstract class Storage {
    /**
     * Final parameters.
     */
    protected static final double CONDITIONFORWARHOUS = 25;
    protected static final double CONDITIONFORSHOP = 75;
    protected static final double CONDITIONFORTRASH = 100;
    protected static final double DISCONT = 25;
    private ArrayList<Food> foodList;

    public Storage(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }
    /**
     * Method for init parameter depending of condition.
     * @param i - index of list.
     * @return
     */
    public abstract boolean isAppropriate(int i);
    /**
     * Method for add to list rsult.
     */
    public abstract void add();

    public ArrayList<Food> getFoodList() {
        return foodList;
    }
}
