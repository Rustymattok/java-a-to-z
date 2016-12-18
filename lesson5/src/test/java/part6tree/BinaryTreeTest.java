package part6tree;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * Tests for checking methods.
 */
public class BinaryTreeTest {
    @Test
    public void whenShouldCheckAdd() throws Exception {
        BinaryTree<String,String> tree = new BinaryTree<String, String>();
        tree.add("1","Vladimir1");
        String result  = tree.get("1");
        assertThat(result,is("Vladimir1"));
    }
    @Test
    public void whenShouldCheckRemove() throws  Exception{
        BinaryTree<String,String> tree = new BinaryTree<String, String>();
        tree.add("1","Vladimir1");
        tree.add("2","Vladimir2");
        tree.add("3","Vladimir3");
        tree.add("4","Vladimir4");
        tree.remove("2");
        int result = 3;
        assertThat(result,is((int) tree.getList().size()));
    }
}