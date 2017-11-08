package learn_thread_unblock;
/**
 * Test multythread.
 */
public class TestClass {
    public static void main(String[] args) {
        final ThreadCollection threadCollection = new ThreadCollection();
        Task task1 = new Task("privet1");
        threadCollection.add(task1);
        threadCollection.add(new Task("privet2"));
        threadCollection.add(new Task("privet3"));
        threadCollection.add(new Task("privet4"));
        threadCollection.add(new Task("privet5"));
        threadCollection.add(new Task("privet6"));
        threadCollection.add(new Task("privet7"));
        threadCollection.add(new Task("privet8"));
        threadCollection.add(new Task("privet9"));
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for ( int i = 0; i < 10; i++) {
            int y = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadCollection.update(task1);
                }
            }).start();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadCollection.show();
    }
}
