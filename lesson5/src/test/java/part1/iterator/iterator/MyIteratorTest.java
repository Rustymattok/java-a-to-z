package part1.iterator.iterator;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This test for MyIterator/ And it checkes his methods.
 */
public class MyIteratorTest {
    /**
     * Allow to check work of hasNext. THis part1iterator.bigIterator.iterator made for take part1iterator.bigIterator.simple.
     * The common quantity of part1iterator.bigIterator.simple should be 4 in our sample.
     * @throws Exception
     */
    @Test
    public void testHasNext() throws Exception {
        Integer[] arr = {2,1,3,4,5,6,7,9,8};
        Task task = new Task (arr);
        int rezult = 0;
        Iterator it = task.getIterator();
        while ((it.hasNext())){
            it.next();
            rezult++;
        }
        assertThat(rezult,is((int)4));

    }
    /**
     * Allow to check work of next. THis part1iterator.bigIterator.iterator made for take part1iterator.bigIterator.simple.
     * @throws Exception
     */
    @Test
    public void testNext() throws Exception {
        Integer[] arr = {2,1,3,4,5,6,7,9,8};
        Task task = new Task (arr);
        Integer rezult;
        Iterator it = task.getIterator();
        rezult = (Integer) it.next();
        assertThat(rezult,is((int)2));

    }
}