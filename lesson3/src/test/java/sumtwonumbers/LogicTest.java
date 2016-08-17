package sumtwonumbers;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for tests.
 */
public class LogicTest {
    /**
     * @param logic - initiated parameter of Logic.
     */
    private final Logic logic = new Logic();
    /**
     * whenShouldCheckLogicMethodAdd() - this method check for add(Number number1,Number number2).
     */
    @Test
    public void whenShouldCheckLogicMethodAdd(){
        int result;
        result = logic.add(new Number(3),new Number(5));
        assertThat(result,is(8));
    }
}
