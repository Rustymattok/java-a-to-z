package logic;

import persistent.Store;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Store {
    private final Map<Integer, User> store = new HashMap<Integer,User>();
    private int ids = 0;

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
        return 0;
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
