package foodnew.logic;

import foodnew.model.Food;
import foodnew.model.WarehouseNew;

import java.util.ArrayList;

public class ControllQualityNew extends ControllQuality {
    private final static int WARSIZE = 5;
    private ArrayList<WarehouseNew> warNewFood = new ArrayList<WarehouseNew>();

    @Override
    public void action(ArrayList<Food> foods) {
        super.action(foods);
        if(super.getWarFood().size() > WARSIZE){
            System.out.println("test");
            for (int i = super.getWarFood().size(); i > WARSIZE; i--) {
                warNewFood.add(new WarehouseNew(super.getWarFood().get(i-1)));
                super.getWarFood().remove(i - 1);
            }
        }
    }

    public ArrayList<WarehouseNew> getWarNewFood() {
        return warNewFood;
    }
}
