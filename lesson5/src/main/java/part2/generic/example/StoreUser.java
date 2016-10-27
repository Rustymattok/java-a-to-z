package part2.generic.example;

import part2.generic.SimpleGeneric;
/**
 * Class for StoreUser and worj with users.
 */
public class StoreUser implements Store<User> {
    SimpleGeneric<User> list = new SimpleGeneric<User>();

    public StoreUser(SimpleGeneric<User> list) {
        this.list = list;
    }

    public  User getByIndex(int index) {
        return (User) list.getByIndex(index);
    }

    public void add(User object) {
        list.add(object);
    }

    public void remove(int index) {
        list.delete(index);
    }

    public void  show(){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(getByIndex(i).getId());
        }
    }
}
