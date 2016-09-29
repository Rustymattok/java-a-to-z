package food.extend;

import food.model.Storage;
/**
 * Interface for comon porpereties of Food with temperature.
 */
public interface StorageTempr extends Storage {

    boolean isAppropriate(FoodTempr food);

    void add(FoodTempr food);
}
