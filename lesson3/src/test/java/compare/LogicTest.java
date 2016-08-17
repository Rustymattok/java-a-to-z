package compare;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class LogicTest {
    /**
     * @param logic - initiated parameter of Logic.
     */
    private final Logic logic = new  Logic();
    /**
     * this method check for add(Number number1,Number number2).
     */
    @Test
    public void whenShouldCheckLogicMethodCompare(){
        int result;
        result = logic.compare(new Number(3),new Number(5),new Number(1)).getNumber();
        assertThat(result,is(1));
    }
}
