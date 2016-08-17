package calculator;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for Test SimpleCalc
 */
public class TragicCalcTest extends SimpleCalcTest {
    private TragicCalc calc = new TragicCalc();
    /**
     * Test of method ADDSIN.
     */
    @Test
    public void whenShouldCheckADDSIN(){
        double result =  calc.addSin(30,30);
        assertThat(result,is((double)1));
    }
}
