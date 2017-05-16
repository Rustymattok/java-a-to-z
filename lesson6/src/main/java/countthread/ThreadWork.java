package countthread;

public  class ThreadWork {

    private int count = 0;
    private final Object lock = new Object();

   public  void increment(){
           count++;
    }

    public  int getCount() {
        return count;
    }
}
