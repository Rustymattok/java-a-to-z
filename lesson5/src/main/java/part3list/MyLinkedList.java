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
        linkLast(object);
    }
    /**
     * This method for add element in our list.
     * @param index - index of element.
     * @param element - object which we add.
     */
    public void add(int index, T element) {
        if (index == size)
            linkLast(element);
        else {
            MyNode<T> node = node(index);
            linkBefore(element, node);
        }
    }

    private void linkBefore(T element, MyNode<T> node) {
        MyNode<T> param = node.prev;
        MyNode<T> newMode = new MyNode<T>(element,node.next,node.prev);
        node.prev = newMode;
        if (node.equals(first)) {
            first = newMode;
            first.next = node;
        }
        else {
            param.next = newMode;
            newMode.next = node;
        }
       size++;
    }

    private void linkLast(T element) {
        MyNode<T> next = last;
        MyNode<T> newMode = new MyNode<T>(element,next,null);
        this.last = newMode;
        if(next == null) {
            first = newMode;
        }else{
            next.next = newMode;
            newMode.prev = next;
        }
        size++;
    }
    /**
     * This method allow to orgonize moving lists, during removing.
     */
    public T linkRemove(MyNode<T> node){
        final T element = node.object;
        final MyNode<T> next = node.next;
        final MyNode<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.object = null;
        size--;
        return element;
    }
    /**
     * This method remove element from list by Index.
     * @param index - position of element in the list.
     * @return element which will be delete.
     */
    public T remove(int index){
        return  linkRemove(node(index));
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

    public MyNode<T> getA(int index) {
        return  node(index);
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

        public void setObject(T object) {
            this.object = object;
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

