package part4set;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleSetListTest {
    /**
     * This method allow to check method add.
     * If added position 5 and equels with result.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckadd() throws Exception {
        SimpleSetList<String> list = new SimpleSetList<String>();
        list.add("Text1");
        list.add("Text2");
        list.add("Text3");
        list.add("Text3");
        list.add("Text4");
        list.add("Text5");
        int result = list.getSize();
        assertThat(result,is((int)5));
    }

}