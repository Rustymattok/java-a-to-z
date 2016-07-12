package evenodd;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NumberTest {

    @Test
    public void whenShouldCheckNumberEven(){
        boolean result = false;
        Number number = new Number(2);
        result = number.even();
        assertThat(result,is(true));
    }

    @Test
    public void whenShouldCheckNumberOdd(){
        boolean result = false;
        Number number = new Number(3);
        result = number.odd();
        assertThat(result,is(true));
    }
}
