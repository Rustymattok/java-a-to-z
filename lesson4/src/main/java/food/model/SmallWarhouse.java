package food.model;

/**
 * Class of Warhouse with limit size;
 */
public class SmallWarhouse extends Warehouse {
    static final int SIZEWARHOUSE = 2;
    /**
     *
     * @param food - if ok for condition .
     * @return
     */
    @Override
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() <=  CONDITIONFORWARHOUS && warFood.size() <  SIZEWARHOUSE) {
            flag = true;
        }
        return flag;
    }
}
