package presistens;
import models.CarManyToMany;
import java.util.Set;
/**
 * Interface Many to Many xml.
 */
public interface StoreOwner {

    void add(CarManyToMany car);

    void remove(Integer id);

    void update(CarManyToMany car, Set drivers);
}
