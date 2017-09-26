package learn_thread_jmm;
/**
 * Class for Test, allow to increment count value.
 */
public class Counter {

    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}
