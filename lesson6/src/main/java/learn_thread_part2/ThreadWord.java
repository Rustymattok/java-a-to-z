package learn_thread_part2;

public class ThreadWord implements Runnable, Calculation {
    /**
     * @param text - the text that should be parsed.
     * @param count - numbers of spaces.
     */
    private final String text;
    private int count;
    private int timeThread;

    public ThreadWord(String text) {
        this.text = text;
    }
    /**
     *This method start thread .
     */
    @Override
    public void run() {
        calulate();
        //todo
    }
    /**
     * This method calculate quantity of word.
     */
    @Override
    public synchronized void calulate() {
        char[] symbol;
        symbol = text.toCharArray();
        int i = 1;
        while (i < text.length()) {
            if (!Thread.interrupted()) {
                if (symbol[i - 1] == ' ' && symbol[i] == ' ') {
                    count = getCount();
                } else if (symbol[i] == ' ') {
                    count++;
                    System.out.printf("Calculation of word: %d%n",getCount());
                    try {
                        timeThread = randomTime();
                        Thread.sleep(timeThread);
//                        System.out.println("WORD" + timeThread);
                        TestThread.time = timeThread;
                    } catch (InterruptedException e) {
                        System.out.println("поток прерван");
                       return;
                    }
                }
                i++;
            }
        }
        if (symbol[text.length()-1] != ' '){
            count++;
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
