package part2.generic.example;

import org.junit.Test;
import part2.generic.SimpleGeneric;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This class for test of methods.
 */
public class StoreRoleTest {
    private SimpleGeneric<Role> listUser;

    @Test
    public void whenShouldCheckAdd(){
        init();
        StoreRole storeRole = new StoreRole(listUser);
        storeRole.add(new Role("5"));
        String result = storeRole.getByIndex(5).getId();
        assertThat(result, is("5"));
    }
    @Test
    public void whenShouldCheckGetByIndex(){
        init();
        StoreRole storeRole = new StoreRole(listUser);
        String result = storeRole.getByIndex(0).getId();
        assertThat(result, is("0"));
    }
    @Test
    public void whenShouldCheckRemove(){
        init();
        StoreRole storeRole = new StoreRole(listUser);
        storeRole.remove(0);
        String result = storeRole.getByIndex(0).getId();
        assertThat(result, is("1"));
    }
    /**
     *This method for initilization of parameters.
     */
    public void init(){
        listUser = new SimpleGeneric<Role>();
        listUser.add(new Role("0"));
        listUser.add(new Role("1"));
        listUser.add(new Role("2"));
        listUser.add(new Role("3"));
        listUser.add(new Role("4"));
    }

}