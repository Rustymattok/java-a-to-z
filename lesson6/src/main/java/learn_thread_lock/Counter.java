package learn_thread_lock;
/**
 * Class which use lock method for threads.
 */
public class Counter {
    private Lock lock = new Lock();
    private int count = 0;

    public int inc(){
        lock.lock();
        int newCount = ++count;
        lock.unlock();
        return newCount;
    }

    public int getCount() {
        return count;
    }
}
