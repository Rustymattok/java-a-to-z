package learn_thread_pool_sample;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * This class was made to dewscribe ThreadPool.
 */
public class ThreadPoolSample {
    public static void main(String[] args) {
        //ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        /**
         * newSingleThreadExecutor() -  in this case our applacation works only with one Thread regarding deque.
         */
        ExecutorService executor = Executors.newSingleThreadExecutor();
        final ArrayDeque<Work> states = new ArrayDeque<Work>();
        int i = 0;
        while(i < Runtime.getRuntime().availableProcessors()) {
            i++;
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    states.add(new Work());
                    System.out.println(states.size());
                }
            });
        }
        executor.shutdown();
    }
}
