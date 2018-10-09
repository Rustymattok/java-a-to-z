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

    @Override
    public void add(User user) {
            list.add(user);
            user.setId(String.valueOf(list.size()));
    }
    //todo добавить проверку поиском в будущем
    @Override
    public void update(String id, String name, String login, String email) {
        list.get(Integer.parseInt(id)).setName(name);
        list.get(Integer.parseInt(id)).setLogin(login);
        list.get(Integer.parseInt(id)).setEmail(email);
    }

    @Override
    public void delete(String id) {
            list.remove(Integer.parseInt(id));
    }

    @Override
    public User findById(String id) {
        return list.get(Integer.parseInt(id));
    }

//    @Override
//    public List<User> getList() {
//        return null;
//    }

    @Override
    public int size() {
        return list.size();
    }
}
