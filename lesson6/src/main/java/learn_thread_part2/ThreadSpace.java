package learn_thread_part2;
/**
 * The class which describe thread of calculation spaces.
 */
public class ThreadSpace implements Runnable, Calculation {
    /**
     * @param text - the text that should be parsed.
     * @param count - numbers of spaces.
     */
    private final String text;
    private  int count ;
    private int timeThread;

    public ThreadSpace(String text) {
        this.text = text;
    }
    /**
     *This method start thread .
     */
    @Override
    public void run() {
        calulate();
    }
    /**
     * This method calculate quantity of spaces.
     */
    @Override
    public synchronized void calulate() {
        char[] symbol;
        symbol = text.toCharArray();
        int i = 0;
        while(i < text.length()){
            if (!Thread.interrupted()) {
                if (symbol[i] == ' ') {
                    count++;
                    System.out.printf("Calculation of space: %d%n", getCount());
                    try {
                        timeThread = randomTime();
                        Thread.sleep(timeThread);
//                         System.out.println("SPACE" + timeThread);
                        TestThread.time = timeThread;
                    } catch (InterruptedException e) {
                        System.out.println("поток прерван SPACE");
                        return;
                    }
                }
                i++;
            }
        }
    }
    /**
     * This method generate time for pause.
     * @return random time in sec (integer type). it can be from 100 till 1000ms.
     */
    @Override
    public int randomTime() {
        final double random = Math.random();
        return  (int) Math.round((random * 10) + 0)*150;
    }

    public int getCount() {
        return count;
    }
}
