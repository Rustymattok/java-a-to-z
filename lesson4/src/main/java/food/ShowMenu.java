package food;

import food.logic.ControllQuality;
/**
 * Class for show prelimery result.
 */
public class ShowMenu {
private ControllQuality controllQuality;

    public ShowMenu(ControllQuality controllQuality) {
        this.controllQuality = controllQuality;
    }

    public void show(){
        System.out.println(controllQuality.getShop().getShopFood().size());
        for (int i = 0; i < controllQuality.getShop().getShopFood().size();i++) {
            System.out.println(controllQuality.getShop().getShopFood().get(i));
        }
        System.out.println(controllQuality.getWarehouse().getWarFood().size());
        for (int i = 0; i < controllQuality.getWarehouse().getWarFood().size();i++) {
            System.out.println(controllQuality.getWarehouse().getWarFood().get(i));
        }
        System.out.println(controllQuality.getTrash().getTrashFood().size());
        for (int i = 0; i < controllQuality.getTrash().getTrashFood().size();i++) {
            System.out.println(controllQuality.getTrash().getTrashFood().get(i));
        }
    }
}
