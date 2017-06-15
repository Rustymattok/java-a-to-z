package countthread2;
/**
 * Class whish describe thread of using methods.
 */
public class ThreadUser implements  Runnable{
    private User user;
    private User user2;
    private UserStorage userStorage;

    public ThreadUser(User user, User user2, UserStorage userStorage) {
        this.user = user;
        this.user2 = user2;
        this.userStorage = userStorage;
    }

    @Override
    public  void run() {
            //todo нужно предусмотреть наличие user и user2 в UserStorage, также предусмотреть проверку баланса.
            userStorage.amount(user, user2, 150);
    }
}
