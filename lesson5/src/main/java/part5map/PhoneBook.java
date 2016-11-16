package part5map;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
/**
 * Class for Phone book.
 * @param <T> - key.
 * @param <V> - value.
 */
public class PhoneBook<T,V> {
    private Node<T,V>[] table;
    private int capacity = 16;
    private int size = 0;

    PhoneBook(){
        this.table = new Node[capacity];
    }
    /**
     * Method for add to mapp new element.
     * @param key - key number.
     * @param value - value method.
     * @return true/false - depeds of add or not.
     */
    boolean insert(T key, V value){
        if(this.table.length == 0 || this.table == null || size > (this.table.length -1)){
            this.table = this.resize();
        }
        return putVal(hash(key), key, value) == null;
    }
    /**
     * Get element by Key.
     * @param key - parameter of key.
     * @return value.
     */
    public V get(Object key) {
        Node<T,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }
    /**
     * Get Node by Key of object.
     * @param hash - of key.
     * @param key - key parametr.
     * @return node.
     */
    final Node<T,V> getNode(int hash, Object key) {
        Node<T,V>[] tab; Node<T,V> first, e; int n; T k;
        if ((tab = table) != null && (n = tab.length) > 0 &&
                (first = tab[(n - 1) & hash]) != null) {
            if (first.hash == hash && // always check first node
                    ((k = first.key) == key || (key != null && key.equals(k))))
                return first;
            if ((e = first.next) != null) {
                do {
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        return e;
                } while ((e = e.next) != null);
            }
        }
        return null;
    }
    /**
     * Method for add element to map.
     * @param hash - number.
     * @param key - key element.
     * @param value - value of map.
     * @return null.
     */
    final V putVal(int hash, T key, V value){
        Node<T,V>[] tab; Node<T,V> p; int n, i;
        if ((tab = table) == null || (n = tab.length) == 0)
            n = (tab = resize()).length;
        if ((p = tab[i = (n - 1) & hash]) == null)
            tab[i] = newNode(hash, key, value, null);
        else {
            Node<T, V> e;
            T k;
            if (p.hash == hash &&
                    ((k = p.key) == key || (key != null && key.equals(k))))
                e = p;
            else {
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        p.next = newNode(hash, key, value, null);
                        break;
                    }
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k))))
                        break;
                }
            }
        }
        size++;
        return null;
    }
    /**
     * THis method allow to creat new Node for HashMap.
     * @param hash
     * @param key
     * @param value
     * @param next
     * @return
     */
    Node<T,V> newNode(int hash, T key, V value, Node<T,V> next) {
        return new Node<T,V>(hash, key, value, next);
    }
    /**
     * Method for increase capacity for massive.
     * @return new massive.
     */
    final Node<T,V>[] resize(){
        int capacityNew = capacity * 2;
        Node<T,V>[] newTab =  new Node[capacityNew] ;
        for (int i = 0; i < this.table.length; i++) {
            Node<T,V> e;
            if((e = this.table[i]) != null) {
                newTab[e.hash & (capacityNew - 1)] = e;
            }
        }
        return newTab;
    }
    /**
     * Calculate hashcode end convert it to the index of massive.
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int getSize() {
        return size;
    }

    public Iterator iterator(){
        return new PhoneIterator();
    }
    /**
     *Class wich describe Node.
     * @param <T>
     * @param <V>
     */
    private class Node<T, V> implements Map.Entry<T,V> {
        final int hash;
        final T key;
        V value;
        Node<T,V> next;

        Node(int hash, T key, V value, Node<T,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public T getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public V setValue(V value) {
            this.value = value;
            return value;
        }
    }
    /**
     * Ieratir of PhoneBook.
     * @param <T>
     * @param <V>
     */
    private class PhoneIterator<T,V> implements Iterator<V>{
        Node<T,V> e;
        int position = 0;
        boolean inner = false;

        public void calcPos(){
            while(position < table.length && !inner ){
                if(table[position] != null){
                    e = (Node<T, V>) table[position];
                    break;
                }
                position++;
            }
        }

        public boolean hasNext() {
            boolean result = false;
            calcPos();
            if (e!= null && e.next != null || position != table.length ){
                result = true;
            }
            return result;
        }

        public V next() {
            Node<T,V> node;
            if(hasNext()){
                if(e.next!= null){
                    inner = true;
                    node = e;
                    e = e.next;
                }
                else{
                    node = e;
                    position++;
                    inner = false;
                }
            }else{
                throw new NoSuchElementException();
            }
            return node.value;
        }

        public void remove() {

        }
    }
}
