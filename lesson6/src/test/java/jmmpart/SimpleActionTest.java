package jmmpart;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * This class for testing jmm.
 */
public class SimpleActionTest {
    /**
     * If isFlag = true, that mean that count of thread1 = thread2, but in reak it isn't.
     */
    @Test
    public void whenShouldCheckAction() throws InterruptedException {
        SimpleAction simpleAction = new SimpleAction(5);
        simpleAction.action();
        assertThat(simpleAction.isFlag(), is(true));
    }

}