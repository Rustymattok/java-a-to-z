package foodpart1;

import foodpart1.logic.ControllQualityNew;
import foodpart1.logic.LogicTest;

/**
 * Class for prelimerry start application.
 */
public class Test {
    public static void main(String[] args) {
        ControllQualityNew controllQuality = new ControllQualityNew();
        controllQuality.action(new LogicTest().initList());
        System.out.println(controllQuality.getWarFood().size());
        System.out.println(controllQuality.getShopFood().size());
        System.out.println(controllQuality.getTrashFood().size());
        System.out.println(controllQuality.getWarNewFood().size());
    }

}
