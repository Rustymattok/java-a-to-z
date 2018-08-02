package persistent;
import logic.User;
/**
 * Interface for work with Data.
 */
public interface Store {

    void add(User user);
    void update(String id);
    void delete(String id);
    boolean findAll(User user);
    User findById(String id);
}
