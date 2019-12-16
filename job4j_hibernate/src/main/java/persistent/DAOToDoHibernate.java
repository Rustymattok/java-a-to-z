package persistent;

import models.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.GregorianCalendar;
import java.util.List;

public class DAOToDoHibernate implements StoreTask {

    private static  final  DAOToDoHibernate INSTANCE = new DAOToDoHibernate();

    private SessionFactory sessionFactory;
    private Session session;

    private DAOToDoHibernate() {
    }

    public static DAOToDoHibernate getINSTANCE() {
        return INSTANCE;
    }

    private void initHibernate(){
        sessionFactory = null;
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    public void add(Topic task) {
        initHibernate();
        session.save(task);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void remove(Integer id) {
        initHibernate();
        Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
        session.remove(topic);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();

    }

    public void update(Integer id, Topic task) {
        initHibernate();
        Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
        topic.setStatus(task.isStatus());
        topic.setExpired(new GregorianCalendar());
        session.update(topic);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public List<Topic> getData() {
        initHibernate();
        List<Topic> list = (List<Topic>)session.createQuery("from Topic ").list();
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        return list;
    }

}
