package testfood;

import food.logic.ControllQuality;
import food.logic.LogicTest;
import food.model.Shop;
import food.model.Trash;
import food.model.Warehouse;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for make tests.
 */
public class ControllQualityTest {
    private ControllQuality contr = new ControllQuality(new LogicTest().initList());
    /**
     * This method use for inet storages and make sort.
     */
    public void initForTest(){
        contr.addStorage(new Shop("магнит",new LogicTest().initList()));
        contr.addStorage(new Warehouse("1st",new LogicTest().initList()));
        contr.addStorage(new Trash("магнит",new LogicTest().initList()));
    }

    @Test
    public void whenShouldCheckActionShop(){
         initForTest();
         contr.action();
         double result = contr.getStoreges().get(0).getFoodList().size();
         assertThat(result,is((double)3));
    }

    @Test
    public void whenShouldCheckActionWarhous(){
        initForTest();
        contr.action();
        double result = contr.getStoreges().get(1).getFoodList().size();
        assertThat(result,is((double)5));
    }

    @Test
    public void whenShouldCheckActionTrash(){
        initForTest();
        contr.action();
        double result = contr.getStoreges().get(2).getFoodList().size();
        assertThat(result,is((double)1));
    }
}
