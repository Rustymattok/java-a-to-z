package part3list;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class wich describerealisation of LinkedList.
 * @param <T>
 */
public class MyLinkedList <T> implements ContainerArray<T> {
    /**
     * Node befor and after.
     * @param size - size of list.
     */
    MyNode<T> first;
    MyNode<T> last;
    int size;
    /**
     * This method for add element in our list.
     * @param object
     */
    public void add(T object) {
        MyNode<T> next = last;
        MyNode<T> newMode = new MyNode<T>(object,next,null);
        this.last = newMode;
        if(next == null) {
            first = newMode;
        }else{
            next.next = newMode;
        }
        size++;
    }
    public void add(int index, T element) {
        if (index == size)
            linkLast(element);
        else
            linkBefore(element,node(index));
        size++;
    }

    private void linkBefore(T element, MyNode<T> node) {
        MyNode<T> pred = node.prev;
        MyNode<T> newMode = new MyNode<T>(element,pred,node);
        node.prev = newMode;
        if (pred == null)
            first = newMode;
        else
            pred.next = newMode;
    }

    private void linkLast(T element) {
       add(element);
    }

    /**
     * This method return node by index.
     * @param index
     * @return node.
     */
    MyNode<T> node(int index) {
        MyNode<T> x = first;
        if ( size != 0 && index < size){
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
        } else {
            throw new NoSuchElementException();
        }
        return x;
    }
    /**
     * This element return element.
     * @param index
     * @return T object.
     */
    public T getArr(int index) {
        return  node(index).getObject();
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator() {
        return  new MyIterator<T>();
    }
    /**
     * Inner class for describe Node.
     * @param <T>
     */
    private class MyNode<T> {
        T object;
        MyNode<T> next;
        MyNode<T> prev;

        public MyNode(T object, MyNode<T> next, MyNode<T> prev) {
            this.object = object;
            this.next = next;
            this.prev = prev;
        }

        public T getObject() {
            return object;
        }
    }
    /**
     * Iterator for this class.
     * @return
     */
    private class MyIterator <T> implements Iterator <T>{
        private int indexP = 0;

        public boolean hasNext() {
            boolean flag = false;
            if(this.indexP != size){
                flag = true;
            }
            return flag;
        }

        public T next() {
            if (this.hasNext()) {
                return (T) getArr(indexP++);
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {

        }
    }
}

