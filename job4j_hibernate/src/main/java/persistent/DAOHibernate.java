package persistent;
import models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 * This class describe DAO using technology. Class is a singltone.
 */
public class DAOHibernate implements StoreUser {
    private static  final  DAOHibernate INSTANCE = new DAOHibernate();

    private final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory() ;
    private final Session session = sessionFactory.openSession();

    private DAOHibernate() {
    }

    public static DAOHibernate getINSTANCE() {
        return INSTANCE;
    }

    private void initHibernate(){
        if (sessionFactory == null){
            session.beginTransaction();
        }
    }

    public void add(User user) {
        initHibernate();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void remove(Integer id) {
        initHibernate();
        User user = (User) session.createQuery("from User where id ="+id).list().get(0);
        session.remove(user);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }

    public void update(Integer id, User user) {
        initHibernate();
        User userData = (User) session.createQuery("from users where id ="+id).list().get(0);
        userData.setName(user.getName());
        userData.setExpired(user.getExpired());
        session.update(userData);
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
