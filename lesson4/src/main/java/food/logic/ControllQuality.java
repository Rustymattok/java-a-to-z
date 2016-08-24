package food.logic;

import food.model.Food;
import food.model.Shop;
import food.model.Trash;
import food.model.Warehouse;
import java.util.ArrayList;
/**
 * Class for sort foods.
 */
public class ControllQuality {
    /**
     * @param shop - List of foods in shop.
     * @param warehouse - List of warehouse in shop.
     * @param trash - List of trash in shop.
     */
    private Shop shop;
    private Warehouse warehouse;
    private Trash trash;
    /**
     *Method for start logic.
     */
    public void action (ArrayList<Food> foods){
        shop = new Shop(foods);
        warehouse = new Warehouse(foods);
        trash = new Trash(foods);
        warehouse.add();
        shop.add();
        trash.add();
    }

    public Shop getShop() {
        return shop;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public Trash getTrash() {
        return trash;
    }
}
