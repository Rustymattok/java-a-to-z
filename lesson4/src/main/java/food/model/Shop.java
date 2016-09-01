package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for shop.
    */
    public class Shop extends Storage {
    protected ArrayList<Food> shopFood = new ArrayList<Food>();

    public Shop(String name, ArrayList<Food> foodList) {
        super(name,foodList);
    }
    /**
     * Method for init parameter depending of condition.
     * @param  food - food for sort.
     * @return
     */
    @Override
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
     * Method for add to list rsult.
     */
    @Override
    public void add(Food food) {
        if (isAppropriate(food)) {
            shopFood.add(food);
        }
    }

    @Override
    public ArrayList<Food> getFoodList() {
        return shopFood;
    }


}
