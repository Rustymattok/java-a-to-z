package part3list;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for testing MyQueue.
 */
public class MyQueueTest {
    /**
     * This method allow to check add(T object).
     * @throws Exception
     */
    @Test
    public void whenShouldCheckStackAdd() throws Exception {
        MyQueue<String> list = new MyQueue<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        int result = list.getSize();
        assertThat(result, is(5));
    }
    /**
     * This method allow to check peek().
     * @throws Exception
     */
    @Test
    public void whenShouldCheckQueuePeek() throws Exception {
        MyQueue<String> list = new MyQueue<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        String result = list.peek();
        assertThat(result, is("Test5"));
    }
}