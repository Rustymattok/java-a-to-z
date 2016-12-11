package part6tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/**
 * Class for Simple tree.
 * @param <T>
 */
public class SimpleTree<T> {
    /**
     * Node<T> link for type.
     */
    private Node<T> root;

    public SimpleTree(T rootValue){
        root = new Node<T>(rootValue);
        root.setChildren(new ArrayList<Node<T>>());
    }
    /**
     * This method alllow to add additional element.
     * @param parent
     * @param value
     */
    public void addChildren(Node<T> parent,T value){
        Node<T> rootN = new Node<T>(value);
        root.getParent().setParent(parent);
        root.getChildren().add(rootN);
        root.setParent(parent);
    }
    /**
     * This method allow to take all children.
     * @return
     */
    public List<T> getChildren(){
        List<T> list = new ArrayList<T>();
        for (int i = 0; i < root.getChildren().size(); i++) {
            list.add(root.getChildren().get(i).getValue());
        }
        return   list;
    }

    public Node<T> getRoot() {
        return root;
    }

    public Iterator<T> iterator() {
        return new MyIterator<T>();
    }
    /**
     * This is iterator for SimpleTree
     * @param <T>
     */
    private class MyIterator<T> implements Iterator<T>{
        private int indexP = 0;

        public boolean hasNext() {
            boolean flag = false;
            if(this.indexP != root.getChildren().size()){
                flag = true;
            }
            return flag;
        }

        public T next() {
            if (this.hasNext()) {
                return (T) root.getChildren().get(indexP++).getValue();
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
