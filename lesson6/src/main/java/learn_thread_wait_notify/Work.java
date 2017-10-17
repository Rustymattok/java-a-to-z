package learn_thread_wait_notify;

import java.util.LinkedList;
/**
 * Class Work created for work in multi Thread area.
 * It depends of capacity ( processor numbers for thread).
 * For view sample(test) we tale LinkedList.
 * When we have enogh capacity for work one of our thread can add values to the list.
 * When all thread works it will be block while remove using threads.
 */
public class Work {
    private LinkedList listThread = new LinkedList();
    private int capacity = Runtime.getRuntime().availableProcessors();

    public void add(){
        int value = 0;
        while(true){
            synchronized (this){
                while (listThread.size() == capacity){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producer produced-" + value);
                value++;
                listThread.add(value);
                notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void cunsume(){
        while (true){
            synchronized (this){
                while (listThread.size() == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Integer val = (Integer) listThread.removeFirst();
                System.out.println("Consumer consumed-" + val);
                notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
