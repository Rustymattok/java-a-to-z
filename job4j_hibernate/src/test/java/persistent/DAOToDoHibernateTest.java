package persistent;
import models.Topic;
import org.junit.Test;
import java.util.GregorianCalendar;
/**
 * Class describe test for Data Hibernate.
 */
public class DAOToDoHibernateTest {

    @Test
    public void add() {
        DAOToDoHibernate dao = DAOToDoHibernate.getINSTANCE();
        Topic task = new Topic();
        task.setTask("Сделать домашку 1");
        task.setStatus(true);
        task.setExpired(new GregorianCalendar());
        dao.add(task);
    }

    @Test
    public void getData() {
        DAOToDoHibernate dao = DAOToDoHibernate.getINSTANCE();
        System.out.println(dao.getData().get(0).getTask());
    }

    @Test
    public void update() {
        DAOToDoHibernate dao = DAOToDoHibernate.getINSTANCE();
        Topic task = new Topic();
        task.setStatus(true);
        dao.update(7,task);
    }

    @Test
    public void remove() {
        DAOToDoHibernate dao = DAOToDoHibernate.getINSTANCE();
        dao.remove(40);
    }
}