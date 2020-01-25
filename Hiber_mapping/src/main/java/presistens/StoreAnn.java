package presistens;
import models.CarAnn;
import models.EngineAnn;

/**
 * Interface One to Many Annotation
 */
public interface StoreAnn {
    void add(CarAnn car);

    void add(EngineAnn engine);

    void remove(Integer id);

    void update(Integer id);
}
