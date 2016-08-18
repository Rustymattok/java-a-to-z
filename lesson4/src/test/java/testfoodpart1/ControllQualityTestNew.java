package testfoodpart1;

import foodpart1.logic.LogicTest;
import foodpart1.logic.ControllQualityNew;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ControllQualityTestNew {
    private ControllQualityNew contr = new ControllQualityNew();

    @Test
    public void whenShouldCheckAction(){
        contr.action(new LogicTest().initList());
        double result = contr.getWarNewFood().size();
        assertThat(result,is((double)2));
    }
}
