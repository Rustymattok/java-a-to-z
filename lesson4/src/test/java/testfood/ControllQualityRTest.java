package testfood;

import food.extend.RTrash;
import food.logic.ControllQualityR;
import food.model.Trash;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Class for make tests.
 */
public class ControllQualityRTest {
    private ControllQualityR controllQualityR = new ControllQualityR();
    private LogicTestR logicTestR;
    /**
     * This method use for inet storages and make sort.
     */
    public void initForTest(){
        logicTestR = new LogicTestR();
        logicTestR.initList();
    }

    @Test
    public void whenShouldCheckActionTrashR(){
        initForTest();
        RTrash trash = new RTrash();
        controllQualityR.addStorage(trash);
        for (int i = 0; i < logicTestR.getList().size(); i++) {
            controllQualityR.action(logicTestR.getList().get(i));
        }
        double result = trash.getTrashFood().size();
        assertThat(result, is((double) 3));
    }
}
