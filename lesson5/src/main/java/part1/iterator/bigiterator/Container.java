package part1.iterator.bigiterator;

import java.util.Iterator;
/**
 * Interface for convert several iterators to one common.
 */
public interface Container {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it);

}
