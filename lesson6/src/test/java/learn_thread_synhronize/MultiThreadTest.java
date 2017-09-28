package learn_thread_synhronize;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Class for Test multiThread.
 */
public class MultiThreadTest {
    private UserStorage userStorage = new UserStorage();
    private User user1 = new User(1,100);
    private User user2 = new User(2,200);
    private User user3 = new User(3,300);
    private User user4 = new User(4,400);

    public void initList(){
        userStorage.add(user1);
        userStorage.add(user2);
        userStorage.add(user3);
        userStorage.add(user4);
    }
    @Test
    public void whenShouldCheckMultyThread(){
        initList();
        ThreadStorage threadStorage1 = new ThreadStorage(userStorage,user1,user2,100);
        ThreadStorage threadStorage2 = new ThreadStorage(userStorage,user1,user3,100);
        Thread thread1 = new Thread(threadStorage1);
        Thread thread2 = new Thread(threadStorage2);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("user1 " + user1.getAmount());
        System.out.println("user2 " + user2.getAmount());
        System.out.println("user3 " + user3.getAmount());
//        assertThat(userStorage.check(new User(2,555)),is(true));
    }
}
