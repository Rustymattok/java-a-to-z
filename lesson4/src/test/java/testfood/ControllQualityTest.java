package testfood;

import food.logic.ControllQuality;
import food.logic.LogicTest;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllQualityTest {
    private ControllQuality contr = new ControllQuality();

    @Test
    public void whenShouldCheckAction(){
         contr.action(new LogicTest().initList());
         double result = contr.getShopFood().size();
         assertThat(result,is((double)1));
    }
}
