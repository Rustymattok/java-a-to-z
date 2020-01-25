package presistens;
import models.CarAnnotation;
import models.EngineAnnotation;

/**
 * Interface One to Many Annotation
 */
public interface StoreAnnotation {
    void add(CarAnnotation car);

    void add(EngineAnnotation engine);

    void remove(Integer id);

    void update(Integer id);
}
