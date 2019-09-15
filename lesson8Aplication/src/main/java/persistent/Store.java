package persistent;
import logic.User;
/**
 * Interface for work with Data.
 */
public interface Store {
    void add(User user);
    void update(String id,User user);
    void update(String id, String name, String login, String email);
    void delete(String id);
    void alterFindById(String id, String role);
    int size();
    User findById(String id);
    User findByIdAlternative(String id);
    User findById(String login,String password);
    boolean isCredentional(String login,String password);
}
