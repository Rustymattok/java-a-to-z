package learn_thread_synhronize;
import static org.hamcrest.core.Is.is;
import org.junit.Test;
import static org.junit.Assert.assertThat;
/**
 * Class for checking methods of UserStorage.
 */
public class UserStorageTest {

    private User user = new User(1,222);
    private UserStorage userStorage = new UserStorage();

    public void initList(){
        userStorage.add(user);
        userStorage.add(new User(2,222));
        userStorage.add(new User(4,222));
    }

    @Test
    public void whenShouldCheck(){
        initList();
        assertThat(userStorage.check(new User(2,555)),is(true));
    }

    @Test
    public void  whenShouldCheckUpdate(){
        initList();
        userStorage.update(user,5555);
        int result = user.getAmount();
        assertThat(result,is(5555));
    }

    @Test
    public void whenShouldCheckDelete(){
        initList();
        userStorage.delete(user);
        int result = userStorage.getList().size();
        assertThat(result,is(2));
    }

    @Test
    public void whenShouldCheckTransfer(){
        initList();
        userStorage.transfer(user,new User(2,222),100);
        int result1 = user.getAmount();
        int result2 = userStorage.getList().get(2).getAmount();
        assertThat(result1,is(322));
        assertThat(result2,is(122));
    }

}