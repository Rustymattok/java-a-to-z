package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class MyIterator<T> implements Iterator<T> {
    private HashMap<Integer,Order> listNew;
    private int indexP = 0;

    public MyIterator(HashMap<Integer, Order> listNew) {
        this.listNew = listNew;
    }

    public boolean hasNext() {
        boolean flag = false;
        if(this.indexP != listNew.size()){
            flag = true;
        }
        return flag;
    }

    public T next() {
        if (this.hasNext()) {
            return (T) listNew.get(indexP++);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        listNew.remove(indexP++);
    }
}