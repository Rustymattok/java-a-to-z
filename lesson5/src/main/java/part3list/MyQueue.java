package part3list;
/**
 * Own class for queue.
 * @param <T>
 */
public class MyQueue<T> extends MyLinkedList<T> implements IQureContainer<T>{
    /**
     * This method for add element in queue.
     * @param object - elemnt which add to the list.
     */
    public void push(T object) {
        super.add(object);
    }
    /**
     * THis method for removing element from the list by turn - top.
     * @return - element which was deleted.
     */
    public T peek() {
        return super.remove(0);
    }
}
