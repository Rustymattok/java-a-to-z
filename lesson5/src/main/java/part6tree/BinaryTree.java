package part6tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryTree <T1 extends Comparable<T1>,T2>  {
    private List<MyNode<T1,T2>> list = new ArrayList<MyNode<T1, T2>>();
    /**
     * Link for node of leaf in tree.
     * @param <T1>
     * @param <T2>
     */
    static class MyNode<T1, T2> {
        T1 key;
        T2 value;
        MyNode<T1, T2> left, right;

        MyNode(T1 key, T2 value) {
            this.key = key;
            this.value = value;
        }

        public T2 getValue() {
            return value;
        }

        public T1 getKey() {
            return key;
        }
    }

    private MyNode<T1, T2> root = null;
    /**
     * This method allow to get value buy key in tree.
     * @param k
     * @return
     */
    public T2 get(T1 k) {
        MyNode<T1, T2> x = root;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                return x.value;
            }
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        return null;
    }
    /**
     * This link allow to add new leaf in tree.
     * @param k
     * @param v
     */
    public void add(T1 k, T2 v) {
        MyNode<T1, T2> x = root, y = null;
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                x.value = v;
                return;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        MyNode<T1, T2> newNode = new MyNode<T1, T2>(k, v);
        if (y == null) {
            root = newNode;
        } else {
            if (k.compareTo(y.key) < 0) {
                y.left = newNode;
            } else {
                y.right = newNode;
            }
        }
        list.add(newNode);
    }
    /**
     * This link allow to remove leaf in tree.
     * @param k
     */
    public void remove(T1 k) {
        MyNode<T1, T2> x = root, y = null;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getKey().equals(k)){
                list.remove(i);
                break;
            }
        }
        while (x != null) {
            int cmp = k.compareTo(x.key);
            if (cmp == 0) {
                break;
            } else {
                y = x;
                if (cmp < 0) {
                    x = x.left;
                } else {
                    x = x.right;
                }
            }
        }
        if (x == null) {
            return;
        }
        if (x.right == null) {
            if (y == null) {
                root = x.left;
            } else {
                if (x == y.left) {
                    y.left = x.left;
                } else {
                    y.right = x.left;
                }
            }
        } else {
            MyNode<T1, T2> leftMost = x.right;
            y = null;
            while (leftMost.left != null) {
                y = leftMost;
                leftMost = leftMost.left;
            }
            if (y != null) {
                y.left = leftMost.right;
            } else {
                x.right = leftMost.right;
            }
            x.key = leftMost.key;
            x.value = leftMost.value;
        }
    }



    public Iterator<T2> iterator() {
        return new MyIterator<T2>();
    }

    public List<MyNode<T1, T2>> getList() {
        return list;
    }

    private class MyIterator<T> implements Iterator<T>{
        private int indexP = 0;

        public boolean hasNext() {
            boolean flag = false;
            if(this.indexP != list.size()){
                flag = true;
            }
            return flag;
        }

        public T next() {
            if (this.hasNext()) {
                return (T) list.get(indexP++).getValue();
            } else {
                throw new NoSuchElementException();
            }
        }
    }
}
