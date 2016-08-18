package food;

import food.logic.ControllQuality;
import food.logic.LogicTest;

/**
 * Class for prelimerry start application.
 */
public class Test {
    public static void main(String[] args) {
        ControllQuality controllQuality = new ControllQuality();
        controllQuality.action(new LogicTest().initList());
//        System.out.println(controllQuality.getWarFood().size());
//        System.out.println(controllQuality.getShopFood().size());
//        System.out.println(controllQuality.getTrashFood().size());
//        System.out.println(controllQuality.getWarFood().size());
    }
}
