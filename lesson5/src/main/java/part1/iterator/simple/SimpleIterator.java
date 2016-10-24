package part1.iterator.simple;

import java.util.Iterator;
/**
 *Class discribe own Iterator.
 */
public class SimpleIterator implements Iterator{
    private int index = 0;
    private Integer[] arr;

    public SimpleIterator(Integer[] arr) {
        this.arr = arr;
    }
    /**
     * Rezult depends of end or not of massive.True - if massive not at the end and not part1iterator.bigIterator.simple.
     * @return true/false.
     */
    public boolean hasNext() {
        boolean flag = false;
        Integer rezult;
        int mIndex = this.index;
        int i;
        while(mIndex < arr.length){
            rezult = arr[mIndex++];
            for (i = 2; (rezult%i) > 0 ; i++) {
            }
            if (i == rezult ){
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Take parameter of masive and move index depends of conditions. Only for part1iterator.bigIterator.simple parameters.
     * @return rezult.
     */
    public Object next() {
        Integer rezult = null;
        int i;
        while (index < arr.length){
            rezult = arr[index++];
            for (i = 2; (rezult%i) > 0 ; i++) {
            }
            if (i == rezult ){
                break;
            }
        }
        return rezult;
    }
}

