package learn_thread_synhronize;
/**
 * Thread of work with storage.
 */
public class ThreadStorage implements Runnable {
    private UserStorage userStorage;
    private User user1;
    private User user2;
    private int amount;

    public ThreadStorage(UserStorage userStorage, User user1, User user2, int amount) {
        this.userStorage = userStorage;
        this.user1 = user1;
        this.user2 = user2;
        this.amount = amount;
    }

    @Override
    public void run() {
        userStorage.transfer(user1,user2,amount);
        for (int i = 0; i < 5 ; i++) {
            try {
                Thread.sleep(i*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
