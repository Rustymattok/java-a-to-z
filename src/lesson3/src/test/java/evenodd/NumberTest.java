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
    private final Logic logic = new Logic(new Number(2));
    /**
     * whenShouldCheckNumberEven() - this method check for even.
     */
    @Test
    public void whenShouldCheckNumberEven(){
        boolean result = false;
        result = logic.even();
        System.out.println("Четное " + result);
        assertThat(result, is(true));//todo эта строка в этом случае не нужна?
    }
    /**
     * whenShouldCheckNumberOdd() - this method check for odd.
     */
    @Test
    public void whenShouldCheckNumberOdd(){
        boolean result = false;
        result = logic.odd();
        System.out.println("Не Четное " + result);
        assertThat(result,is(true));//todo эта строка в этом случае не нужна?
    }
}
