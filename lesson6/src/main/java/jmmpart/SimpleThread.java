package jmmpart;
/**
 * Thried for testing JMM case.
 */
public class SimpleThread implements Runnable {
    /**
     * @param count - int type of testing number.
     * @param name - String type of testing number.
     */
    private int count;
    private String name;

    public SimpleThread(int count, String name) {
        this.count = count;
        this.name = name;
    }

    public void run() {
        count++;
        SimpleAction.setCount(count);
        System.out.println(count + "  ------------------> :" + name);
    }

    public int getCount() {
        return count;
    }
}