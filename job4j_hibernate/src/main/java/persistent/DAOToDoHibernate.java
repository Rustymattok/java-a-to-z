package persistent;
import models.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.GregorianCalendar;
import java.util.List;
/**
 * This class describe DAO using technology. Class is a singltone.
 */
public class DAOToDoHibernate implements StoreTask {
    private static  final  DAOToDoHibernate INSTANCE = new DAOToDoHibernate();

    private DAOToDoHibernate() {
    }

    public static DAOToDoHibernate getINSTANCE() {
        return INSTANCE;
    }

    public void add(Topic task) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void remove(Integer id) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
        session.remove(topic);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void update(Integer id, Topic task) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
        topic.setStatus(task.isStatus());
        topic.setExpired(new GregorianCalendar());
        session.update(topic);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public List<Topic> getData() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Topic> list = (List<Topic>)session.createQuery("from Topic ").list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return list;
    }

}
