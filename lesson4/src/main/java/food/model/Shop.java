package food.model;

import java.util.ArrayList;
    /**
    * Class describe foo for shop.
    */
public class Shop implements Storage {
    protected ArrayList<Food> shopFood = new ArrayList<Food>();
    /**
     *
     * @param food - if ok for condition .
     * @return
     */
    public boolean isAppropriate(Food food) {
        boolean flag = false;
        if(food.calculateDay() > CONDITIONFORWARHOUS && food.calculateDay() < CONDITIONFORSHOP) {
            flag = true;
        }
        if(food.calculateDay() >= CONDITIONFORSHOP && food.calculateDay() <  CONDITIONFORTRASH){
            flag = true;
            food.setDiscount(DISCONT);
        }
        return flag;
    }
    /**
     * This method add to the list of foods food.
     * @param food
     */
    public void add(Food food) {
        shopFood.add(food);
    }

    //todo убрать потом


    public ArrayList<Food> getShopFood() {
        return shopFood;
    }
}
