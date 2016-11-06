package part1.iterator.bigiterator;

import java.util.Iterator;
/**
 * This class for big Iterator. Entered parameter consist of list from three iterators.
 */
public class BigIterator implements Container {
    public Iterator<Integer> convert(final Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            private Iterator<Iterator<Integer>> big = it;
            private Iterator<Integer> box = null  ;
            /**
             * Allow to check work of hasNext.Depends of condition.
             * true - not the end of line. false - end of line.
             */
            public boolean hasNext() {
                boolean flag = false;
                if(big.hasNext() || (this.box.hasNext() && this.box != null) ){
                    flag = true;
                }
                return flag;

            }
            /**
             * Take parameter of masive and move index depends of conditions.
             * @return rezult.
             */
            public Integer next() {
                Integer rezult = null;
                if(big.hasNext() && (box == null || !box.hasNext())) {
                    box = big.next();
                }
                if ( box.hasNext()){
                    rezult =  box.next();
                }
                return rezult;

            }

            public void remove() {

            }
        };
    }
}
