package learn_thread_part3;

public class TestThread {
    static long time = 0;

    public static void main(String[] args) {
        CountChar countChar = new CountChar("fsdf fsdf fdsf fdsf d");
        Thread thread1 = new Thread(countChar);
        Time timeThread = new Time();
        Thread thread2 = new Thread(timeThread);
        thread1.start();
        thread2.start();
        for (int i = 1; i < 5 ; i++) {
            try {
                Thread.sleep(i*2*500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(time > 3000){
                thread1.interrupt();
                thread2.interrupt();
            }
        }
        try {
            thread1.join();
            thread2.join();
            System.out.println(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program is done");
    }
}
