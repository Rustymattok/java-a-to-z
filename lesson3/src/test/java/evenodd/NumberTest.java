package evenodd;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for tests.
 */
public class NumberTest {
    /**
     * @param logic - initiated parameter of Logic.
     */
    private Logic logic;
    /**
     * whenShouldCheckNumberEven() - this method check for simple.
     */
    @Test
    public void whenShouldCheckNumberEven(){
        boolean result = false;
        logic = new Logic(new Number(2));
        result = logic.even();
        assertThat(result, is(true));//todo эта строка в этом случае не нужна?
    }
    /**
     * whenShouldCheckNumberOdd() - this method check for odd.
     */
    @Test
    public void whenShouldCheckNumberOdd(){
        boolean result = false;
        logic = new Logic(new Number(3));
        result = logic.odd();
        assertThat(result,is(true));//todo эта строка в этом случае не нужна?
    }
}
