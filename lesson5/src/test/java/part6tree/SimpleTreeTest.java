package part6tree;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Tests for checking methods.
 */
public class SimpleTreeTest {
    private SimpleTree<String> list = new SimpleTree<String>("Zagolovok");
    private Node<String> test1 = new Node<String>("test1");
    private Node<String> test2 = new Node<String>("test2");

    public void init(){
        list.addChildren(test1,"Vladimir");
        list.addChildren(test2,"Alliy");
        list.addChildren(test1, "Alina");
        list.addChildren(test2, "Makarov");
    }
    @Test
    public void whenShouldCheckAddChildren() throws Exception {
        init();
        int result = list.getChildren().size();
        assertThat(result, is((int) 4));
    }



    @Test
    public void whenShouldCheckGetChildren() throws Exception {
        init();
        List<String> array = list.getChildren();
        int result = array.size();
        assertThat(result,is((int)4));
    }
    @Test
    public void whenShouldContain() throws Exception{
        boolean result;
        init();
        result = list.contain("Makarov");
        assertThat(result, is(true));
    }
    @Test
    public void whenShouldCheckFindByValue(){
        Node<String> node;
        init();
        boolean result = false;
        node = list.findByValue("Makarov");
        if(node.equals(list.getRoot().getChildren().get(3))){
            result = true;
        }
        assertThat(result, is(true));
    }
    @Test
    public void whenShouldCheckBalanceTree(){
        init();
        boolean result = false;
        result = list.balanceTree();
        assertThat(result, is(true));
    }
}