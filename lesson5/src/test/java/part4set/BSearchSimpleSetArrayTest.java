package part4set;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BSearchSimpleSetArrayTest {
    /**
     * This method allow to check method add.
     * If added position 5 and equels with result.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckAdd() throws Exception {
        BSearchSimpleSetArray<String> list = new  BSearchSimpleSetArray<String>();
        list.add("Text1");
        list.add("Text2");
        list.add("Text3");
        list.add("Text3");
        list.add("Text4");
        list.add("Text5");
        int result = list.getPosition();
        assertThat(result,is((int)5));
    }

}