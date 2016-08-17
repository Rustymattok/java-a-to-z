package palindrome;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for tests.
 */
public class LogicTest {
    /**
     * @param text - Text init parameter for test
     * @param logic - Logic init parameter for test logic
     */
    private final Text text = new Text("–Œ“Œ–");
    private final Logic logic = new Logic(text);
    /**
     * this method check does text palindrome or not(true / false).
     */
    @Test
    public void whenShouldCheckCompareString(){
        boolean result  = logic.compareString(text,logic.reverseText(text));
        assertThat(result,is(true));
    }
}
