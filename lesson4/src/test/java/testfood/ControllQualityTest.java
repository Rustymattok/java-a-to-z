package testfood;

import food.logic.ControllQuality;
import food.logic.LogicTest;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllQualityTest {
    private ControllQuality contr = new ControllQuality();

    @Test
    public void whenShouldCheckActionShop(){
         contr.action(new LogicTest().initList());
         double result = contr.getShop().getShopFood().size();
         assertThat(result,is((double)4));
    }

    @Test
    public void whenShouldCheckActionWarhous(){
        contr.action(new LogicTest().initList());
        double result = contr.getWarehouse().getWarFood().size();
        assertThat(result,is((double)5));
    }

    @Test
    public void whenShouldCheckActionTrash(){
        contr.action(new LogicTest().initList());
        double result = contr.getTrash().getTrashFood().size();
        assertThat(result,is((double)1));
    }
}
