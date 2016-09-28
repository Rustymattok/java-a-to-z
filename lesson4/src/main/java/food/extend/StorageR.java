package food.extend;

import food.model.Storage;
/**
 * Interface for comon porpereties of Food.
 */
public interface StorageR extends Storage {

    boolean isAppropriate(RFood food);

    void add(RFood food);
}
