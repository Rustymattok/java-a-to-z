package presistens;
import models.CarManyToManyAnnotation;
import java.util.Set;

public interface StoreOwnerAnnotation {
    void add(CarManyToManyAnnotation car);

    void remove(Integer id);

    void update(CarManyToManyAnnotation car, Set drivers);
}
