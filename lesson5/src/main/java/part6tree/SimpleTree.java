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
    private Node<T> rootN;
    private int i = 0;

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
        rootN = new Node<T>(value);
        rootN.setParent(parent);
        root.getChildren().add(rootN);
    }
    /**
     * This method allow to take all children.
     * @return
     */
    public List<Node<T>> getChildren(){
        List<Node<T>> list = new ArrayList<Node<T>>();
        for (int i = 0; i < root.getChildren().size(); i++) {
            list.add(root.getChildren().get(i));
        }
        return   list;
    }
    /**
     * This method allow to check contain T element in Tree.
     * @param value
     * @return ture/false.
     */
    public boolean contain(T value){
        boolean result = false;
        for (int i = 0; i < root.getChildren().size(); i++) {
            if(root.getChildren().get(i).getValue().equals(value)){
                result = true;
            }
        }
        return  result;
    }
    /**
     * This method allow to take node by T value.
     * @param value
     * @return
     */
    public Node<T> findByValue(T value){
        Node<T> node = null;
        for (int i = 0; i < root.getChildren().size(); i++) {
            if(root.getChildren().get(i).getValue().equals(value)){
                node = root.getChildren().get(i);
            }
        }
        return node;
    }
    /**
     * This method allow to check balance or not this tree.
     * @return true/ false.
     */
    public boolean balanceTree(){
        boolean result = false;
        Node<T> node = null;
        int j;
        int index = 0;
        for (int i = 0; i < root.getChildren().size(); i++) {
            node = root.getChildren().get(i).getParent();
            j = i + 1;
            while (j < root.getChildren().size()){
                if (node.equals(root.getChildren().get(j).getParent())){
                    index++;
                }
                j++;
            }
        }
        if ((root.getChildren().size())%index == 0){
            result = true;
        }
        return result;
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

        public void remove() {

        }
    }
}