package persistent;
import models.User;
/**
 * Interface for work with data in any type.
 */
public interface StoreUser {

    void add(User user);

    void remove(Integer id);

    void update(Integer id,User user);
}
