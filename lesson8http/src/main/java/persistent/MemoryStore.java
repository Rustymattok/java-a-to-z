package persistent;
import logic.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Class for Data.
 */
public class MemoryStore implements Store {
    private List<User> list= Collections.synchronizedList(new ArrayList());
    private  static MemoryStore instance;

    private MemoryStore(){

    }

    public static MemoryStore getInstance(){
        if(instance ==null){
            instance = new MemoryStore();
        }
        return instance;
    }

    @Override
    public void add(User user) {
        if(!findAll(user)) {
            list.add(user);
            user.setId(String.valueOf(list.size()));
        }
    }
//todo нет понимания где реалиовывать в задании.
    @Override
    public void update(String id) {
        if(findAll(findById(id))){
            list.get(Integer.valueOf(id)).setName("name");
            list.get(Integer.valueOf(id)).setLogin("login");
            list.get(Integer.valueOf(id)).setEmail("email");
        }
    }

    @Override
    public void delete(String id) {
        if(findAll(findById(id))){
            list.remove(Integer.valueOf(id));
        }
    }

    @Override
    public boolean findAll(User user) {
        boolean flag = false;
        for(User user1 : list){
            if(user1.equals(user)){
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public User findById(String id) {
        User look = null;
        for(User user : list){
            if(user.getId().equals(id)){
                look = user;
            }
        }
        return look;
    }

}
