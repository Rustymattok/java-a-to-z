package food;

import food.logic.ControllQuality;
import food.logic.LogicTest;
import food.model.Shop;
import food.model.Trash;
import food.model.Warehouse;
/**
 * Class for prelimerry start application.
 */
public class Test {
    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality (new LogicTest().initList());
        controllQuality.addStorage(new Shop("������",new LogicTest().initList()));
        controllQuality.addStorage(new Warehouse("1st",new LogicTest().initList()));
        controllQuality.addStorage(new Trash("������",new LogicTest().initList()));
        controllQuality.action();
        ShowMenu showMenu = new ShowMenu(controllQuality);
        showMenu.show();
    }
}
