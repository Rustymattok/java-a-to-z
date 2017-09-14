package learn_thread_part2;
/**
 * This class created for Testing.
 * time - is the time of delay. If delay will be about 1 sec th Threads will stop work.
 */
public class TestThread {
    static int time = 0;

    public static void main(String[] args) {
        String  text = "This is my Test programm";
        System.out.println(text);
        ThreadSpace threadSpace = new ThreadSpace(text);
        ThreadWord threadWord = new ThreadWord(text);
        Thread ups = new Thread(threadWord);
        Thread ups2 = new Thread(threadSpace);
        ups.start();
        ups2.start();
        for (int i = 1; i < 5 ; i++) {
            try {
                Thread.sleep(i*2*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(time >= 900){
                ups.interrupt();
                ups2.interrupt();
            }
        }
        try {
            ups.join();
            ups2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Program is done");
    }
}

