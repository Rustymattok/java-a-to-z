package foodpart1.logic;

import foodpart1.model.Food;
import foodpart1.model.WarehouseNew;
import java.util.ArrayList;
/**
 * Class for sort foods with additional parameters.
 */
public class ControllQualityNew extends ControllQuality {
    /**
     * @param WARSIZE - size of warhous.
     */
    private final static int WARSIZE = 5;
    private ArrayList<WarehouseNew> warNewFood = new ArrayList<WarehouseNew>();
    /**
     * Method for fill warhouse. If it comes full, automaticalyy added to a new warhouse.
     */
    @Override
    public void action(ArrayList<Food> foods) {
        super.action(foods);
        if(super.getWarFood().size() > WARSIZE){
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
