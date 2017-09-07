package learn_thried_part1;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * TestThread for checking count of spaces
 */
public class ThreadSpaceTest {
    private String text;
    private ThreadSpace space;
    @Test
    public void whenShouldCheckCalulate() throws Exception {
        text = "dddd ddd d";
        space = new ThreadSpace(text);
        space.calulate();
        assertThat(space.getCount(), is(2));
    }
}