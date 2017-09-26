package learn_thread_jmm;
/**
 * Class for Test jmm case demonstration.
 */
public class TestThread {
    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadCounter counterA = new ThreadCounter("Thread1",counter);
        ThreadCounter counterB = new ThreadCounter("Thread2",counter);
        Thread threadA = new Thread(counterA);
        Thread threadB = new Thread(counterB);
        threadA.start();
        threadB.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Final result %d",counter.getCount());
    }
}
