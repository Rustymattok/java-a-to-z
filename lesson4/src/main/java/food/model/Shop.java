package food.model;

import java.util.ArrayList;
/**
 * Class describe foo for shop.
    */
    public class Shop extends Storage {
    protected ArrayList<Food> shopFood = new ArrayList<Food>();

    public Shop(ArrayList<Food> foodList) {
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
            if(getFoodList().get(i).calculateDay() > CONDITIONFORWARHOUS && getFoodList().get(i).calculateDay() < CONDITIONFORSHOP) {
                flag = true;
        }
        if(getFoodList().get(i).calculateDay() >= CONDITIONFORSHOP && getFoodList().get(i).calculateDay() <=  CONDITIONFORTRASH){
            flag = true;
            getFoodList().get(i).setDiscount(DISCONT);
        }
        return flag;
    }
    /**
     * Method for add to list rsult.
     */
    @Override
    public void add() {
        for (int i = 0; i < getFoodList().size(); i++)
            if (isAppropriate(i)) {
                shopFood.add(getFoodList().get(i));
            }
    }

    public ArrayList<Food> getShopFood() {
        return shopFood;
    }
}
