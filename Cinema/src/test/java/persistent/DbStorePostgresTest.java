package persistent;

import logic.User;
import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DbStorePostgresTest {
    DbStorePostgres store = DbStorePostgres.getINSTANCE();

    @Test
    public void addUser() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(112);
        list.add(113);
        list.add(114);
        store.addUser(new User("Vladimir27","89165758909"),list);
    }

    @Test
    public void upBalanceUser() {
        store.checkTransactionUser(new User("Vladimir","89165758909", (double) 400), (double) 500);
    }

    @Test
    public void takePriceTicket() {
        assertThat(store.takePriceTicket("1","1"),is((double)200));
    }

    @Test
    public void sizeData() {
        assertThat(store.sizeData(),is(190));
    }

    @Test
    public void selectByIDHalls() {
        assertThat(store.selectByIDHalls(190).getRow(),is(String.valueOf(10)));
        assertThat(store.selectByIDHalls(190).getPlace(),is(String.valueOf(19)));
        assertThat(store.selectByIDHalls(190).getStatus(),is("free"));
    }

    @Test
    public void checkTransactionUser() {
        User user = new User("Rustymattok","89165758909",(double)200);
        System.out.println(store.checkTransactionUser(user,(double)200));
    }

    @Test
    public void selectUSER() {
        User user = new User("Rustymattok","89165758909",(double)200);
        System.out.println(store.selectUSER(user));
    }

    @Test
    public void selectBalance() {
        User user = new User("Vladimir2","89165758909");
        assertThat(store.selectBalance(user),is((double) 300));
    }
}