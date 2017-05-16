package countthread;

import org.junit.Test;

public class SimpleActionTest {

    @Test
    public void whenShouldCheckActionThried() throws InterruptedException {
        ThreadWork threadWork = new ThreadWork();
        Thread thread1 = new Thread(new ThreadCount("поток1 ",threadWork));
        Thread thread2 = new Thread(new ThreadCount("поток2 ",threadWork));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

}