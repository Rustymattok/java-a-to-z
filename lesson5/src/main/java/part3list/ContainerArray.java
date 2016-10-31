package part3list;
/**
 * Interface with generic of our container.
 * @param <T>
 */
public interface ContainerArray<T> extends Iterable<T> {
    void add(T object);
    T getArr(int index);
}
