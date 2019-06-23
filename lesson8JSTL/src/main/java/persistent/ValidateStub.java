package persistent;

import logic.User;
import persistent.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Store {
    private final Map<Integer, User> store = new HashMap<Integer,User>();
    private int ids = 0;

    public ValidateStub() {
        add(new User("root","root","root"));
        add(new User("root1","root1","root1"));
        add(new User("root2","root2","root2"));
        add(new User("root3","root3","root3"));
    }

    public void add(User user) {
        user.setId(String.valueOf(this.ids++));
        this.store.put(Integer.valueOf(user.getId()),user);
    }

    public Map<Integer, User> getStore() {
        return store;
    }

    public void update(String id, String name, String login, String email) {
        store.get(Integer.valueOf(id)).setName(name);
        store.get(Integer.valueOf(id)).setLogin(login);
        store.get(Integer.valueOf(id)).setEmail(email);
    }

    public void delete(String id) {
        store.remove(Integer.valueOf(id));
    }

    public void updateRole(String id, String role) {

    }

    public int size() {
        return store.size();
    }

    public User findById(String id) {
        return null;
    }

    public User findById(String login, String password) {
        return null;
    }

    public boolean isCredentional(String login, String password) {
        return false;
    }
}
