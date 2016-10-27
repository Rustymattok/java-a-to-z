package part2.generic.example;

import part2.generic.SimpleGeneric;
/**
 * Interface for common stores with generic.
 * This iterface describe functions of class.
 * @param <T>
 */
public interface Store<T extends Base> {
    T getByIndex(int index);
    void add(T object);
    void remove (int index);
}