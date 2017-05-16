package countthread;

public class ThreadCount implements Runnable {
    /**
     * @param count - int type of testing number.
     * @param name - String type of testing number.
     */
    private String name;
    private  ThreadWork threadWork;

    public ThreadCount(String name, ThreadWork threadWork) {
        this.name = name;
        this.threadWork = threadWork;
    }

    public void run() {
        synchronized (threadWork) {
            threadWork.increment();
            System.out.println(name + " ---------> " + threadWork.getCount());
        }
    }

}

