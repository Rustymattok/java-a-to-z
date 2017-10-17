package learn_thread_wait_notify;
/**
 * Class describe pattern for Thread Pool.
 */
public class ThreadPool {

    public static void main(String[] args) {
        final Work work = new Work();
        new Thread(new Runnable() {
            @Override
            public void run() {
                work.add();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                work.cunsume();
            }
        }).start();
    }
}


