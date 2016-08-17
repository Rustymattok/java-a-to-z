package calculator;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for Test SimpleCalc
 */
public class SimpleCalcTest {
    private SimpleCalc simpleCalc = new SimpleCalc();
    /**
     * Test of method add.
     */
    @Test
    public void whenShouldCheckADD(){
        double result = simpleCalc.add(2,5);
        assertThat(result,is((double)7));
    }
    /**
     * Test of method minus.
     */
    @Test
    public void whenShouldCheckMINUS(){
        double result = simpleCalc.minus(5,3);
        assertThat(result,is((double)2));
    }
    /**
     * Test of method devoid.
     */
    @Test
    public void whenShouldDEVOID(){
        double result = simpleCalc.devoid(4,2);
        assertThat(result,is((double)2));
    }
    /**
     * Test of method MULTY.
     */
    @Test
    public void whenShouldMULTY(){
        double result = simpleCalc.multiply(2,5);
        assertThat(result,is((double)10));
    }
}
