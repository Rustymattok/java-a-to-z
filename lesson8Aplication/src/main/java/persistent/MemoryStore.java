package persistent;
import logic.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Class for DataBase.
 */
public class MemoryStore implements Store {
    private final List<User> list= Collections.synchronizedList(new ArrayList());
    private static MemoryStore instance;

    private MemoryStore(){
    }

    public static MemoryStore getInstance(){
        if(instance ==null){
            instance = new MemoryStore();
        }
        return instance;
    }

    public void add(User user) {
            list.add(user);
            user.setId(String.valueOf(list.size()));
    }

    public void update(String id, User user) {
        //to do smth.
    }

    public void update(String id, String name, String login, String email) {
        list.get(Integer.parseInt(id)).setName(name);
        list.get(Integer.parseInt(id)).setLogin(login);
        list.get(Integer.parseInt(id)).setEmail(email);
    }

    public void alterFindById(String id, String role) {

    }

    public boolean isCredentional(String login,String password){
        return false;
    }

    public void delete(String id) {
            list.remove(Integer.parseInt(id));
    }


    public User findById(String id) {
        return list.get(Integer.parseInt(id));
    }

    public User findByIdAlternative(String id) {
        return null;
    }

    public User findById(String login,String password){
        User user = null;
        return user;
    }

    public int size() {
        return list.size();
    }
}
