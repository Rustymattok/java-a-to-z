package food.model;
/**
 * Interface for comon porpereties of Food.
 */
public interface Storage {
    /**
     * Final parameters.
     */
    double CONDITIONFORWARHOUS = 25;
    double CONDITIONFORSHOP = 75;
    double CONDITIONFORTRASH = 100;
    double DISCONT = 25;
    /**
     * Method for init parameter depending of condition.
     * @param food - if ok for condition .
     * @return true.
     */
    boolean isAppropriate(Food food);
    /**
     * Method for add to list rsult.
     */
    void add(Food food);

}

