package learn_thread_lock;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class for testimg mechanizm of own lock.
 */
public class LockTest {
    @Test
    public void whenShouldLock() throws InterruptedException {
        final Counter counter = new Counter();
        int result;
        int i = 0;
        while (i < 3) {
            i++;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.inc();
                }
            }).start();
        }
        Thread.sleep(2000);
        assertThat(result = counter.getCount(), is(3));
    }

}