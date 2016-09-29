package food.extend;

import food.model.Warehouse;
/**
 * Class of Warhouse with limit temperature;
 */
public class WarhouseTempr extends Warehouse implements StorageTempr {
    final static double CONSTTEMP = 3;

    public boolean isAppropriate(FoodTempr food) {
        boolean flag = false;
        if(food.calculateDay() <=  CONDITIONFORWARHOUS && food.getTempr() <= CONSTTEMP) {
            flag = true;
        }
        return flag;
    }

    public void add(FoodTempr food) {
        warFood.add(food);
    }
}
