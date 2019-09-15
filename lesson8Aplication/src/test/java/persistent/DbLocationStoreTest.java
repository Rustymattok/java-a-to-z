package persistent;

import logic.CityType;
import logic.ClientType;
import logic.CountryType;
import logic.User;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class DbLocationStoreTest {
    DbLocationStore db = DbLocationStore.getInstance();

    @Test
    public void initTable() {
        db.initTable();
    }

    @Test
    public void doSmth(){
        String mail = "mrArxi%40gmail.com";
        mail = mail.replace("%40","@");
        System.out.println(mail);
    }

    @Test
    public void add() {
        initTable();
        User user = new User("Vladimir3", "Vladimir3", "mrArxi@gmail.com");
        user.setRole(String.valueOf(ClientType.USER));
        user.setCountry(String.valueOf(CountryType.ENGLAND));
        user.setCity(String.valueOf(CityType.LONDON));
        db.add(user);
    }

    @Test
    public void update() {
        initTable();
        db.update("1488", "Dima2", "Dima2", "mrya@uddd.ru");
    }

    @Test
    public void delete() {
        initTable();
        db.delete("502");
    }

    @Test
    public void size() {
        initTable();
        System.out.println(db.size());
    }

    @Test
    public void findById() {
        initTable();
        System.out.println(db.findById("1").getId());
    }

    @Test
    public void findByIdAlternative() {
        initTable();
        System.out.println(db.findByIdAlternative("1233").getName());
    }

    @Test
    public void isCredentional() {
        initTable();
        assertThat(db.isCredentional("Vladimir2", "Vladimir2"), is(true));
    }

    @Test
    public void updateRole() {
        int data = 125;
        data++;
        int ans = data + 1;
        System.out.println(ans);
    }
}