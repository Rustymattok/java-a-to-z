package presistens;
import models.Car;
import models.Engine;
/**
 * Interface One to Many XML
 */
public interface Store {
    void add(Car car);

    void add(Engine engine);

    void remove(Integer id);

    void update(Integer id);
}
