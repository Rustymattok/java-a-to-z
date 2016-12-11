package part6tree;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * Tests for checking methods.
 */
public class SimpleTreeTest {
    @org.junit.Test
    public void whenShouldCheckAddChildren() throws Exception {
        SimpleTree<String> list = new SimpleTree<String>("Zagolovok");
        Node<String> test1 = new Node<String>("test1");
        Node<String> test2 = new Node<String>("test2");
        list.addChildren(test1,"Vladimir");
        list.addChildren(test2,"Alliy");
        list.addChildren(test1,"Alina");
        list.addChildren(test2,"Makarov");
        int result = list.getChildren().size();
        assertThat(result,is((int)4));
    }
    @Test
    public void whenShouldCheckGetChildren() throws Exception {
        SimpleTree<String> list = new SimpleTree<String>("Zagolovok");
        Node<String> test1 = new Node<String>("test1");
        Node<String> test2 = new Node<String>("test2");
        list.addChildren(test1,"Vladimir");
        list.addChildren(test2,"Alliy");
        list.addChildren(test1,"Alina");
        list.addChildren(test2,"Makarov");
        List<String> array = list.getChildren();
        int result = array.size();
        assertThat(result,is((int)4));
    }

}