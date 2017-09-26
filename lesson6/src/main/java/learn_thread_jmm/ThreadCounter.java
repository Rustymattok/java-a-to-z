package learn_thread_jmm;
/**
 * Thread for increment differnet counter.
 */
public class ThreadCounter implements Runnable{
    private Counter counter;
    private String name;

    public ThreadCounter(String name,Counter counter) {
        this.counter = counter;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.printf("%s %d%n",name,counter.getCount());
                Thread.sleep(100*i);
                counter.increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
