package part2.generic;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for Test SimpleGeneric.
 */
public class SimpleGenericTest {
    private String[] list = new String[]{"Vladimir","Aksana","Nataly","Nikola"};
    /**
     * This method for test method add().
     */
    @Test
      public void whenShouldCheckAdd(){
        String result;
        SimpleGeneric<String> listWords = new SimpleGeneric<String>(list);
        listWords.add("Alya");
        result = (String) listWords.getByIndex(4);
        assertThat(result,is("Alya"));
    }
    /**
     * This method for test method update().
     */
    @Test
    public void whenShouldCheckUpdate(){
        String result;
        SimpleGeneric<String> listWords = new SimpleGeneric<String>(list);
        listWords.update(3, "Alya");
        result = (String) listWords.getByIndex(3);
        assertThat(result, is("Alya"));
    }
    /**
     * This method for test method delete().
     */
    @Test
    public void whenShouldCheckDelete(){
        String result;
        SimpleGeneric<String> listWords = new SimpleGeneric<String>(list);
        listWords.delete(2);
        result = (String) listWords.getByIndex(2);
        assertThat(result, is("Nikola"));
    }
}