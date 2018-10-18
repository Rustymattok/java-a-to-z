package persistent;
import logic.User;

/**
 * Interface for work with Data.
 */
public interface Store {

    void add(User user);
    void update(String id, String name, String login, String email);
    void delete(String id);
    int size();
    User findById(String id);
}
