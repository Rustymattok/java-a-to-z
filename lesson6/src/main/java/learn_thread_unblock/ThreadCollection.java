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
    public void add(Task task) {
        id++;
        list.put(id,task);
        task.setId(id);
    }

    public void update(Task task){
        int version = task.getVersion();
        BiFunction<Integer,Task,Task> biFunction = (k, v) -> {
            if (task.getVersion() == version ) {
                v.setName("Edited!");
            }else{
                try {
                    throw new OptimalException("Косяк");
                } catch (OptimalException e) {
                    e.printStackTrace();
                }
            }
            return v;
        };
            list.computeIfPresent(task.getId(),biFunction);
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