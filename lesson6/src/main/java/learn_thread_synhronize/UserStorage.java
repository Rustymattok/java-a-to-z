package learn_thread_synhronize;
import java.util.HashMap;
import java.util.Map;
/**
 * Class describe Storage of data.
 */
public class UserStorage {
    /**
     * @param list - list of data.
     */
    HashMap<Integer,User> list = new HashMap<Integer, User>();

    public synchronized void add(User user){
        if(!check(user)) {
            list.put(user.getId(), user);
        }
    }

    public synchronized void update(User user,int newAmount){
        if(check(user)) {
           list.get(user.getId()).setAmount(newAmount);
        }
    }

    public synchronized void delete(User user){
        if(check(user)){
            list.remove(user.getId());
        }

    }
    public synchronized void transfer(User user1, User user2, int amount){
        if(check(user1) && check(user2)) {
            list.get(user1.getId()).setAmount(list.get(user1.getId()).getAmount() + amount);
            if(list.get(user2.getId()).getAmount() - amount <= 0){
                list.get(user2.getId()).setAmount(0);
            }else{
                list.get(user2.getId()).setAmount(list.get(user2.getId()).getAmount() - amount);
            }
        }
    }
    
    public synchronized boolean check (User user){
        boolean flag = false;
        for (Map.Entry<Integer,User> userlist : list.entrySet() ){
            if(userlist.getKey() == user.getId()){
                flag = true;
            }
        }
        return flag;
    }

    public HashMap<Integer, User> getList() {
        return list;
    }

}
