package countthread2;
import org.hamcrest.core.Is;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * This class for testthread class of UserStorage
 */
public class UserStorageTest {

    private  UserStorage userStorage;

    public void init(){
        userStorage = new UserStorage();
        User user1 = new User("Vladimir");
        User user2 = new User("Aksana");
        User user3 = new User("Alya");
        User user4 = new User("Ira");
        User user5 = new User("Dima");
        user1.setAmount(500);
        user2.setAmount(550);
        user3.setAmount(660);
        user4.setAmount(350);
        user5.setAmount(455);
        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);
        userStorage.add(user4);
        userStorage.add(user5);
    }

    @Test
    public void whenShouldCheckAdd() throws Exception {
        init();
        userStorage.add(new User("Alina"));
        int result = userStorage.getList().size();
        assertThat(result,is((int)6));
    }

    @Test
    public void whenShouldCheckEdit() throws Exception {
        boolean result = false;
        init();
        User user = new User("Aksana",2);
        userStorage.edit(user);
        if (userStorage.getList().get(2).getName().equals("VladimirEdited")) {
            result = true;
        }
        assertThat(result,is(true));
    }

    @Test
    public void whenShouldCheckRead() throws Exception {
        init();
        userStorage.read();
    }

    @Test
    public void whenShouldCheckDelete() throws Exception {
        init();
        User user = new User("Dima",5);
        userStorage.delete(user);
        int result = userStorage.getList().size();
        assertThat(result,is((int)4));
    }

    @Test
    public void whenShouldCheckAmount() throws Exception {
        init();
        User user1 = userStorage.getList().get(1);
        User user2 = userStorage.getList().get(2);
        User user3 = userStorage.getList().get(3);
        ThreadUser threadUser = new ThreadUser(user1,user2,userStorage);
        ThreadUser threadUser2 = new ThreadUser(user1,user3,userStorage);
        Thread thread = new Thread(threadUser);
        Thread thread2 = new Thread(threadUser2);
        thread.start();
        thread2.start();
        thread.join();
        thread2.join();
        assertThat(user1.getAmount(), Is.<Double>is((double) 200));

    }

}