package foodpart1.logic;

import foodpart1.model.Food;
import foodpart1.model.Shop;
import foodpart1.model.Trash;
import foodpart1.model.Warehouse;

import java.util.ArrayList;

/**
 * Class for sort foods.
 */
public class ControllQuality {
    private static final double CONDITIONFORWARHOUS = 25;
    private static final double CONDITIONFORSHOP = 75;
    private static final double CONDITIONFORTRASH = 100;
    private static final double DISCONT = 25;
    private ArrayList<Warehouse> warFood = new ArrayList<Warehouse>();
    private ArrayList<Shop> shopFood = new ArrayList<Shop>();
    private ArrayList<Trash> trashFood = new ArrayList<Trash>();
    /**
     * This Method sort list of food depending from days.
     * @param foods - list of foods with parameters.
     */
    public void action(ArrayList<Food> foods){
        for (int i = 0; i < foods.size(); i++) {
            if(foods.get(i).calculateDay() <= CONDITIONFORWARHOUS){
               warFood.add(new Warehouse(foods.get(i).getName(),foods.get(i).getExpaireDate(),foods.get(i).getCreatDate(),foods.get(i).getPrice(),foods.get(i).getDiscount()));
            } else if(foods.get(i).calculateDay() > CONDITIONFORWARHOUS && foods.get(i).calculateDay() < CONDITIONFORSHOP){
                shopFood.add(new Shop(foods.get(i).getName(),foods.get(i).getExpaireDate(),foods.get(i).getCreatDate(),foods.get(i).getPrice(),foods.get(i).getDiscount()));
            } else if (foods.get(i).calculateDay() >= CONDITIONFORSHOP && foods.get(i).calculateDay() < CONDITIONFORTRASH ){
                foods.get(i).setDiscount(DISCONT);
                shopFood.add(new Shop(foods.get(i).getName(),foods.get(i).getExpaireDate(),foods.get(i).getCreatDate(),foods.get(i).getPrice(),foods.get(i).getDiscount()));
            } else {
                trashFood.add(new Trash(foods.get(i).getName(),foods.get(i).getExpaireDate(),foods.get(i).getCreatDate(),foods.get(i).getPrice(),foods.get(i).getDiscount()));
            }
        }
    }

    public ArrayList<Warehouse> getWarFood() {
        return warFood;
    }

    public void setWarFood(ArrayList<Warehouse> warFood) {
        this.warFood = warFood;
    }

    public ArrayList<Shop> getShopFood() {
        return shopFood;
    }

    public void setShopFood(ArrayList<Shop> shopFood) {
        this.shopFood = shopFood;
    }

    public ArrayList<Trash> getTrashFood() {
        return trashFood;
    }

    public void setTrashFood(ArrayList<Trash> trashFood) {
        this.trashFood = trashFood;
    }
}
