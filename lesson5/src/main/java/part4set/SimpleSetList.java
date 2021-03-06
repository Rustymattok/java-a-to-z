package part4set;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class sample of set using LinkedLus.
 * @param <T>
 */
public class SimpleSetList<T> {
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
        boolean flag = false;
        MyNode<T> node = first;
        for (int i = 0; i < getSize(); i++) {
            T value = (T) node.object;
            if(value.equals(object)){
                flag = true;
                break;
            }
            node = node.next;
        }
        if(!flag){
            linkLast(object);
        }
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
    private class MyIterator <T> implements Iterator<T> {
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
