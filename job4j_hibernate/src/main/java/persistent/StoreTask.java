package persistent;
import models.Topic;
import java.util.List;
/**
 * Interface for work with data of tasks in any type.
 */
public interface StoreTask {

    void add(Topic task);

    void remove(Integer id);

    void update(Integer id,Topic task);

    List<Topic> getData();
}
