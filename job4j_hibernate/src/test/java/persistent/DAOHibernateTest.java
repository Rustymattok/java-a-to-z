package persistent;

import models.User;
import org.junit.Test;
import java.util.GregorianCalendar;

public class DAOHibernateTest {

    @Test
    public void add() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        User user = new User();
        user.setName("Vladimir");
        user.setExpired(new GregorianCalendar(2017, 0 , 25));
        dao.add(user);
    }

    @Test
    public void remove() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        dao.remove(4);
    }

    @Test
    public void update() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        User user = new User();
        user.setName("Vladimir2");
        user.setExpired(new GregorianCalendar(2019, 0 , 25));
        dao.update(5,user);
    }
}