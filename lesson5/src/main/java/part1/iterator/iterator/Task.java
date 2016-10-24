package part1.iterator.iterator;
/**
 * Class for using Iterator with conditions.
 */
public class Task implements Container {
    private Integer[] arr;

    public Task(Integer[] arr) {
        this.arr = arr;
    }

    public Iterator getIterator() {
        return new MyIterator(arr);
    }
}
