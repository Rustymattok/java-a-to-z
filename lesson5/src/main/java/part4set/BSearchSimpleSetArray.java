package part4set;

import java.util.Arrays;
import java.util.NoSuchElementException;
/**
 * This class add elements with besearch algoritm.
 */
public class BSearchSimpleSetArray <T> {
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
    public BSearchSimpleSetArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public BSearchSimpleSetArray(int sizeCapacity){
        if (sizeCapacity > 0) {
            this.elementData = new Object[sizeCapacity];
        } else if (sizeCapacity == 0) {
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    sizeCapacity);
        }
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
     *
     */
    public void add(T object) {
        checkCapacity();
        if (elementData != null) {
            int flag = bSearch(object, this.elementData);
            if (flag == -1) {
                elementData[position++] = object;
            }
        }
    }

    /**
     * This method use be search algoritm.
     * @param obj - which we want to add.
     * @param array -  element of massiv for compare.
     * @return -1 if nothing found.
     */
    private int bSearch( Object obj, Object[] array ) {
        return bSearch( obj, array, 0, position-1);
    }

    private int bSearch( Object obj, Object[] array, int lowerBound, int upperBound ) {
        if ( lowerBound > upperBound ) return -1;

        int med = lowerBound + ( upperBound - lowerBound ) / 2;

        int cmp = compareTo(obj,array[med]);

        if ( cmp < 0 ) return bSearch( obj, array, lowerBound, med - 1 );
        if ( cmp > 0 ) return bSearch( obj, array, med + 1, upperBound );
        return med;
    }
    /**
     * This method use for compare two elements.
     * @param object - which we want to add.
     * @param array -  element of massiv for compare.
     * @return 0 - if hashcode equel 1 - if hashcode of object < element and others.
     */
    private int compareTo(Object object,Object array){
        int result = 0;
        if(object.hashCode() > array.hashCode()){
            result = 1;
        }
        if(object.hashCode() < array.hashCode()){
            result = -1;
        }
        return result;
    }
    /**
     * This method take object of massive by Index.
     * @param index- position of element.
     * @return object.
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
    public java.util.Iterator<T> iterator() {
        return new MyIterator<T>();

    }
    private class MyIterator<T>  implements java.util.Iterator<T> {
        private int indexP = 0;

         MyIterator() {
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
    }
}

