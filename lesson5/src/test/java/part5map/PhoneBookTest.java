package part5map;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Class for Test PhoneBook.
 */
public class PhoneBookTest {
    /**
     * This method allow to check method insert.
     * If added position 4 and equels with result.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckInsert() throws Exception {
        PhoneBook<String,String> list = new PhoneBook<String, String>();
        list.insert("key1","name1");
        list.insert("key2","name2");
        list.insert("key3","name3");
        list.insert("key4","name4");
        int result = list.getSize();
        assertThat(result,is((int)4));

    }

}