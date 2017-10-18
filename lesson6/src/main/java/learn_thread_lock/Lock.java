package learn_thread_lock;
/**
 * Class describong simmple lock.
 */
public class Lock {

    private boolean isLock = false;

    public synchronized void lock(){
        while(isLock ){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLock = true;
    }

    public synchronized void unlock(){
                isLock = false;
                notify();
            }
}
