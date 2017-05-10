package jmmpart;
/**
 * Class responsoble for connecting two thrieds for cheking jmm.
 *
 */
public class SimpleAction {
    /**
     * @param count - int type static. If this object will be static in this case it can modify parallel with
     *              anoother thried.
     */
    static int count;
    private boolean flag;

    public SimpleAction(int count) {
        this.count = count;
        this.flag = false;
    }
    /**
     * In this method we creat two thread with jmm problem.
     */
    public void action () throws InterruptedException {
        System.out.println(count);
        SimpleThread simpleThread = new SimpleThread(count,"поток 1");
        Thread thread = new Thread(simpleThread);
        SimpleThread simpleThread2 = new SimpleThread(count,"поток 2");
        Thread thread2 = new Thread(simpleThread2);
        thread.start();
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
        }
        thread2.start();
        thread2.join();
        if(simpleThread.getCount() == simpleThread2.getCount()){
            flag = true;
        }
        System.out.println(count);
    }

    public static int getCount() {
        return count;
    }

    public boolean isFlag() {
        return flag;
    }

    public static void setCount(int count) {
        SimpleAction.count = count;
    }
}