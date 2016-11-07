package part3list;
/**
 * Own class for stack.
 * @param <T>
 */
public class MyStack<T> extends MyLinkedList<T> implements IQureContainer<T> {
    /**
     * This method for add element in stack.
     * @param object - elemnt which add to the list.
     */
    public void push(T object) {
        super.add(object);
    }
    /**
     * THis method for removing element fromthe list by turn - top.
     * @return - element which was deleted.
     */
    public T peek() {
        return super.remove(super.getSize() - 1);
    }
}
