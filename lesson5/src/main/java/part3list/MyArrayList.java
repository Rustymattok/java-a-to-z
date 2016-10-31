package part3list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<T> implements ContainerArray<T>{
    /**
     * Size in the start of Array.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Massive with empty elements.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * Work massive in this calss.
     */
    Object[] elementData;

    private int position;
    /**
     * Init MyArrayList  - size of massive = 10.
     */
    public MyArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }
    /**
     * Method increase size o massive.
     */
    private void grow() {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + 1;
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    /**
     * This method chek. Do we need to increase massive.
     */
    private void checkCapacity(){
        if (elementData.length == position + 1 ){
            grow();
        }
    }
    /**
     * This method add new object to masive.
     * @param object - of massiv.
     */
    public void add(T object) {
        checkCapacity();
        elementData[position++] = object;
    }
    /**
     * This method take object of massive by Index.
     * @param index
     * @return
     */
    public T getArr(int index) {
        T object;
        if (index > elementData.length || index < 0){
            object = null;
        }else{
            object = (T) this.elementData[index];
        }
        return object;
    }

    public int getPosition() {
        return position;
    }

    /**
     * Iterator for this class.
     * @return
     */
    public Iterator<T> iterator() {
        return new MyIterator<T>();

    }
    private class MyIterator <T> implements Iterator<T> {
        private int indexP = 0;

        public MyIterator() {
            System.out.println("test");
        }

        public boolean hasNext() {
            boolean flag = false;
            if(this.indexP != elementData.length){
                flag = true;
            }
            return flag;
        }

        public T next() {
            if (this.hasNext()) {
                return (T) elementData[indexP++];
            } else {
                throw new NoSuchElementException();
            }
        }

        public void remove() {

        }
    }
}
