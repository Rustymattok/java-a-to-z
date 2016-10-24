package part1.iterator.simple;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This test for SimpleIterator/ And it checkes his methods.
 */
public class SimpleIteratorTest {
    /**
     * Allow to check work of hasNext. THis part1iterator.bigIterator.iterator made for take part1iterator.bigIterator.simple.
     * The common quantity of part1iterator.bigIterator.simple should be 4 in our sample.
     */
    @Test
    public void whenShouldCheckHasNext(){
        Integer[] arr = {2,3,4,5,12,11};
        SimpleIterator it = new SimpleIterator(arr);
        int count = 0;
        while (it.hasNext()){
            count++;
            it.next();
        }
        assertThat(count,is((int)4));
    }
    /**
     * Allow to check work of next. THis part1iterator.bigIterator.iterator made for take part1iterator.bigIterator.simple.
     */
    @Test
    public void whenShouldCheckNext(){
        Integer[] arr = {2,3,4,5,12,11};
        SimpleIterator it = new SimpleIterator(arr);
        int result = 0;
        result = (Integer) it.next();
        assertThat(result,is((int)2));
    }

}