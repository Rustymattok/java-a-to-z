package learn_thread_unblock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;

/**
 * Class for ConcurrentHashMap. If we use this collection we don't need to add any Lock mechanizm and so on.
 */
public class ThreadCollection {

    private ConcurrentHashMap<Integer,Task> list = new ConcurrentHashMap<Integer,Task>();
    private int id =  0;
   // Lock lock = new ReentrantLock();
    public void add(Task task) {
        id++;
        list.put(id,task);
    }

    public void update(int id, String newName){
        int version = list.get(id).getVersion();
        BiFunction<Integer,Task,Task> biFunction = (k, v) -> {
            if (list.get(id).getVersion() == version ) {
                v.setName(newName);
            }else{
                try {
                    throw new OptimalException("Косяк");
                } catch (OptimalException e) {
                    e.printStackTrace();
                }
            }
            return v;
        };
            list.computeIfPresent(id,biFunction);

    }

    public void show(){
        for ( ConcurrentHashMap.Entry<Integer,Task> data : list.entrySet()) {
            System.out.print(data.getKey() + ": ");
            System.out.print("version " + data.getValue().getVersion() + " " );
            System.out.println(data.getValue().getName());
        }
    }
    public ConcurrentHashMap<Integer, Task> getList() {
        return list;
    }
}