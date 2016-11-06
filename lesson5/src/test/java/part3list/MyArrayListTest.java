package part3list;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This class for testing metods of main class MyArrayList.
 */
public class MyArrayListTest {
    private MyArrayList<String> list;
    /**
     * This method allow to check method add.
     * If added position 5 and equels with result.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckAdd() throws Exception {
        list = new MyArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        int result = list.getPosition();
        assertThat(result, is(5));
    }
    /**
     * This method allow to check method get.
     * If get object by index equel choosed.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckGetArr() throws Exception {
        list = new MyArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        String result = list.getArr(2);
        assertThat(result, is("Test3"));
    }
    /**
     * This method allow to check method get.
     * If get object by index equel choosed.
     * @throws Exception
     */
    @Test
    public void whenShouldCheckAddByIndex(){
        list = new MyArrayList<String>();
        list.add("Test1");
        list.add("Test2");
        list.add("Test3");
        list.add("Test4");
        list.add("Test5");
        list.add(2,"Test");
        String result = list.getArr(2);
        assertThat(result, is("Test"));
    }
}