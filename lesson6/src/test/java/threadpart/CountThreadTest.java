package threadpart;
import org.junit.Test;
/**
 * Class for Testing functions of thread and CountClass.
 */
public class CountThreadTest {
    @Test
    /**
     * In concole you may see results according tasks in job4.ru/8888
     */
    public void whenShouldCheckApplicationWithTwoThreads() throws Exception {
        System.out.println("Изучаем многопоточность");
        Text text = new Text("Привет дед мазай и улыблк тебе и так");
        CountThread countS = new CountThread("space",text);
        CountThread countW = new CountThread("word",text);
        Thread thread1 = new Thread(countS);
        Thread thread2 = new Thread(countW);
        thread1.start();
        thread2.start();
        for (int i = 0; i < 3 ; i++) {
            Thread.sleep(600);
            System.out.println("pause");
        }
        thread1.interrupt();
        thread1.join();
        thread2.join();
        System.out.println("Завершено");
    }
}