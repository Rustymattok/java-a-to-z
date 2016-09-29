package testfood;

import food.extend.WarhouseTempr;
import food.logic.ControllQualityTempr;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for make tests.
 */
public class ControllQualityTemprTest {
    private ControllQualityTempr controllQualityTempr = new ControllQualityTempr();
    private LogicTestTempr logicTestTempr;
    /**
     * This method use for inet storages and make sort.
     */
    public void initForTest(){
        logicTestTempr = new LogicTestTempr();
        logicTestTempr.initList();
    }

    @Test
    public void whenShouldCheckActionTrashR(){
        initForTest();
        WarhouseTempr tempr = new WarhouseTempr();
        controllQualityTempr.addStorage(tempr);
        for (int i = 0; i < logicTestTempr.getList().size(); i++) {
            controllQualityTempr.action(logicTestTempr.getList().get(i));
        }
        double result = tempr.getWarFood().size();
        assertThat(result, is((double) 2));
    }
}
