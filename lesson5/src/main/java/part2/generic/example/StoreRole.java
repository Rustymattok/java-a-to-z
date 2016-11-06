package part2.generic.example;

import part2.generic.SimpleGeneric;
/**
 * Class for work with roles.
 */
public class StoreRole implements Store<Role> {
    SimpleGeneric<Role> list = new SimpleGeneric<Role>();

    public StoreRole(SimpleGeneric<Role> list) {
        this.list = list;
    }

    public Role getByIndex(int index) {
        return (Role) list.getByIndex(index);
    }

    public void add(Role object) {
        list.add(object);
    }

    public void remove(int index) {
        list.delete(index);
    }
}
