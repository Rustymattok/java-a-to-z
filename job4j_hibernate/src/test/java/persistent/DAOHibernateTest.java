package persistent;

import models.User;
import org.junit.Test;
import java.util.GregorianCalendar;

public class DAOHibernateTest {

    @Test
    public void add() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        User user = new User();
        user.setName("Vladimir23");
        user.setExpired(new GregorianCalendar(2017, 0 , 25));
        dao.add(user);
    }

    @Test
    public void remove() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        dao.remove(1);
    }

    @Test
    public void update() {
        DAOHibernate dao = DAOHibernate.getINSTANCE();
        User user = new User();
        user.setName("Vladimir34");
        user.setExpired(new GregorianCalendar(2019, 0 , 25));
        dao.update(3,user);
    }
}