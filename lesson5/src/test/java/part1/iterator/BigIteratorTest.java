package part1.iterator;

import org.junit.Test;
import part1.iterator.bigiterator.BigIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This test for BigIterator/ And it checkes his methods.
 */
public class BigIteratorTest {
    private ArrayList<Integer> one = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
    private ArrayList<Integer> two = new ArrayList<Integer>(Arrays.asList(4,5,6));
    private ArrayList<Integer> three = new ArrayList<Integer>(Arrays.asList(7,8,9));
    /**
     * Allow to check work of hasNext.
     * The common quantity of part1iterator.bigIterator.simple should be 9 in our sample.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckHasNext(){
        ArrayList<Iterator<Integer>> common = new ArrayList<Iterator<Integer>>(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));
        BigIterator it = new BigIterator();
        Iterator<Integer> text = it.convert(common.iterator());
        int count = 0;
        while (text.hasNext()){
            count++;
            text.next();
        }
        assertThat(count,is((int)9));
    }
    /**
     * Allow to check work of next. In our sample first number should be 1;
     */
    @Test
    public void whenShouldCheckNext(){
        ArrayList<Iterator<Integer>> common = new ArrayList<Iterator<Integer>>(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));
        BigIterator it = new BigIterator();
        Iterator<Integer> text = it.convert(common.iterator());
        int result = 0;
        result = (Integer) text.next();
        assertThat(result,is((int)1));
    }

}