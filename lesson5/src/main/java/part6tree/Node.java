package part6tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Class describe Node - with parent,children and so on.
 * @param <T>
 */
public class Node<T>{
    private T value;
    private Node<T> parent;
    private List<Node<T>> children;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getParent() {
        if(parent == null){
            parent = new Node<T>(value);
        }
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        if(children == null){
            children = new ArrayList<Node<T>>();
        }
        return children;
    }

    public void setChildren(List<Node<T>> children) {
        if(parent != null){
            int index = parent.getChildren().size();
            while (index != 0 ){
                index--;
                children.add(parent.getChildren().get(index));
            }
        }
        this.children = children;
    }
    public Node<T> getChild(){
        return new Node<T>(value);
    }

}