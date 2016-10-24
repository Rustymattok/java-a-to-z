package part1.iterator.iterator;
/**
 *Class discribe own Iterator.
 */
public class MyIterator implements Iterator {
    private int index = 0;
    private Integer[] arr;

    public MyIterator(Integer[] arr) {
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
        while(mIndex < arr.length){
            rezult = arr[mIndex++];
            if(rezult%2 == 0){
                flag = true;
                break;
            }
        }
        return flag;
    }
    /**
     * Take parameter of masive and move index depends of conditions. Only for part1iterator.bigIterator.simple parameters.
     * @return rezult.
     */
    public Object  next() {
        Integer rezult = null;
        while (index < arr.length){
            rezult = arr[index++];
            if (rezult%2 == 0){
                break;
            }
        }
        return rezult;
    }
}
