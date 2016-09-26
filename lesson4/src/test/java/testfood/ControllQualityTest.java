package testfood;

import food.logic.ControllQuality;
import food.model.Shop;
import food.model.SmallWarhouse;
import food.model.Trash;
import food.model.Warehouse;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for make tests.
 */
public class ControllQualityTest {
    private ControllQuality controllQuality = new ControllQuality();
    private LogicTest logicTest;
    /**
     * This method use for inet storages and make sort.
     */
    public void initForTest(){
         logicTest = new LogicTest();
         logicTest.initList();
    }

    @Test
    public void whenShouldCheckActionShop(){
         initForTest();
         Shop shop = new Shop();
         controllQuality.addStorage(shop);
         for (int i = 0; i < logicTest.getList().size(); i++) {
            controllQuality.action(logicTest.getList().get(i));
         }
         double result = shop.getShopFood().size();
         assertThat(result, is((double) 3));
    }

    @Test
    public void whenShouldCheckActionSmallWarhouse(){
        initForTest();
        SmallWarhouse smallWarhouse = new  SmallWarhouse();
        controllQuality.addStorage(smallWarhouse);
        for (int i = 0; i < logicTest.getList().size(); i++) {
            controllQuality.action(logicTest.getList().get(i));
        }
        double result = smallWarhouse.getWarFood().size();
        assertThat(result,is((double)2));
    }

    @Test
    public void whenShouldCheckActionWarhous(){
        initForTest();
        Warehouse warehouse = new Warehouse();
        controllQuality.addStorage(warehouse);
        for (int i = 0; i < logicTest.getList().size(); i++) {
            controllQuality.action(logicTest.getList().get(i));
        }
        double result = warehouse.getWarFood().size();
        assertThat(result,is((double)5));
    }

    @Test
    public void whenShouldCheckActionTrash(){
        initForTest();
        Trash trash = new Trash();
        controllQuality.addStorage(trash);
        for (int i = 0; i < logicTest.getList().size(); i++) {
            controllQuality.action(logicTest.getList().get(i));
        }
        double result = trash.getTrashFood().size();
        assertThat(result,is((double)1));
    }
}
