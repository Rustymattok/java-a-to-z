package persistent;

import logic.User;
import org.hamcrest.core.Is;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DbStorePostgresTest {
    DbStorePostgres store = DbStorePostgres.getINSTANCE();
    @Test
    public void initTable() {
        store.initPlaces(10,19,200);
    }

    @Test
    public void addUser() {
        store.addUser(new User("Vladimir2","89165758909", (double) 500),1,4);
    }

    @Test
    public void upBalanceUser() {
        store.checkTransactionUser(new User("Vladimir","89165758909", (double) 400), (double) 500);
    }

    @Test
    public void takePriceTicket() {
        assertThat(store.takePriceTicket("1","1"),is((double)200));
    }
}