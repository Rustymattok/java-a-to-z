package food;

import food.logic.ControllQuality;
import food.logic.LogicTest;
import food.logic.RControllQuality;
import food.model.RWarehouse;
import food.model.Shop;
import food.model.Trash;
import food.model.Warehouse;
/**
 * Class for prelimerry start application.
 */
public class Test {
    public static void main(String[] args) {
//        ControllQuality controllQuality = new ControllQuality (new LogicTest().initList());
//        controllQuality.addStorage(new Shop("магнит",new LogicTest().initList()));
//       // controllQuality.addStorage(new Warehouse("1st",new LogicTest().initList()));
//        controllQuality.addStorage(new RWarehouse(new Warehouse("1st",new LogicTest().initList()),3));
//        controllQuality.addStorage(new Trash("магнит",new LogicTest().initList()));
//        controllQuality.action();
//        ShowMenu showMenu = new ShowMenu(controllQuality);
//        showMenu.show();
        //todo тут должна быть стратегия. НО не входит в рамки задания.
        RControllQuality controllQuality = new RControllQuality (new LogicTest().initList());
        controllQuality.addStorage(new Shop("магнит",new LogicTest().initList()));
        //controllQuality.addStorage(new Warehouse("1st",new LogicTest().initList()));
        controllQuality.addStorage(new RWarehouse(new Warehouse("1st",new LogicTest().initList()),3));
        controllQuality.addStorage(new Trash("магнит",new LogicTest().initList()));
        controllQuality.action();
        RShowMenu showMenu = new RShowMenu(controllQuality);
        showMenu.show();
    }
}
