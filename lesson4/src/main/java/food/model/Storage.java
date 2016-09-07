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
    private String name;

    public Storage() {
        name = "new Storage";
    }

    public Storage(String name,ArrayList<Food> foodList) {
        this.foodList = foodList;
        this.name = name;
    }
    /**
     * Method for init parameter depending of condition.
     * @param food - if ok for condition .
     * @return true.
     */
    public abstract boolean isAppropriate(Food food);
    /**
     * Method for add to list rsult.
     */
    public abstract void add(Food food);

    public abstract ArrayList<Food> getFoodList();
}
