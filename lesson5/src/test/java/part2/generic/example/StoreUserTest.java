package part2.generic.example;

import org.junit.Test;
import part2.generic.SimpleGeneric;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
/**
 * This class for test of methods.
 */
public class StoreUserTest {
    private SimpleGeneric<User> listUser;

    @Test
    public void whenShouldCheckAdd(){
        init();
        StoreUser storeUser = new StoreUser(listUser);
        storeUser.add(new User("5"));
        String result = storeUser.getByIndex(5).getId();
        assertThat(result, is("5"));
    }
    @Test
    public void whenShouldCheckGetByIndex(){
        init();
        StoreUser storeUser = new StoreUser(listUser);
        String result = storeUser.getByIndex(0).getId();
        assertThat(result, is("0"));
    }
    @Test
    public void whenShouldCheckRemove(){
        init();
        StoreUser storeUser = new StoreUser(listUser);
        storeUser.remove(0);
        String result = storeUser.getByIndex(0).getId();
        assertThat(result, is("1"));
    }
    /**
     *This method for initilization of parameters.
     */
    public void init(){
        listUser  = new SimpleGeneric<User>();
        listUser.add(new User("0"));
        listUser.add(new User("1"));
        listUser.add(new User("2"));
        listUser.add(new User("3"));
        listUser.add(new User("4"));
    }

}