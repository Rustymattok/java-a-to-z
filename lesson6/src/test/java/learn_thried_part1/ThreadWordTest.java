package learn_thried_part1;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * TestThread for checking count of spaces
 */
public class ThreadWordTest {
    private String text;
    private ThreadWord word;
    @org.junit.Test
    public void whenShouldCheckCalulate() throws Exception {
        text = "dddd ddd d";
        word = new ThreadWord(text);
        word.calulate();
        assertThat(word.getCount(), is(3));
    }
}