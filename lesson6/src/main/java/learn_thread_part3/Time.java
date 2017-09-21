package learn_thread_part3;
/**
 * This class calculate time.
 */
public class Time implements Runnable,Calculaton {
    @Override
    public void run() {
        calc();
    //todo сделать нить по проверки времени
    }

    @Override
    public void calc() {
        long y = System.currentTimeMillis();
        long time1 = 0;
        while (!Thread.interrupted()){
            try {
                Thread.sleep(1000);
                time1 = time1 +  (System.currentTimeMillis() - y);
                TestThread.time = time1;
            } catch (InterruptedException e) {
                System.out.println("Поток измерения времени прерван");
                return;
        }
        }
    }
}
