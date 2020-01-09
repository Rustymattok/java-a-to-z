package persistent;
import models.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Function;
/**
 * This class describe DAO using technology. Class is a singltone.
 */
public class DAOToDoHibernate implements StoreTask {
    private static  final  DAOToDoHibernate INSTANCE = new DAOToDoHibernate();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DAOToDoHibernate() {
    }

    public static DAOToDoHibernate getINSTANCE() {
        return INSTANCE;
    }
    /**
     * Function method for lambda.
     * @param command - in description, session and tx.
     * @param <T> -  void or Object.
     * @return - Object or null.
     */
    private <T> T tx(final Function<Session, T> command) {
        final Session session =  factory.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        }finally {
            session.close();
        }
    }
    /**
     * Method for lambda - remove.
     * @param id -  by which id to remove.
     */
    private void lambdaRemove(Integer id){
        this.tx(session -> {
            Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
            session.remove(topic);
            return null;
        });
    }
    /**
     * Method for lambda - add.
     * @param task -  which topic should be add.
     */
    private void lambdaAdd(Topic task){
        this.tx(session -> {
            session.save(task);
            return null;
        });
    }
    /**
     * Method for lambda - update
     * @param id - which topic in data to update ( by id)
     * @param task -  update [parameters for new task).
     */
    private void lambdaUpdate(Integer id, Topic task){
        this.tx(session -> {
            Topic topic = (Topic) session.createQuery("from Topic where id =" + id).list().get(0);
            topic.setStatus(task.isStatus());
            topic.setExpired(new GregorianCalendar());
            session.update(topic);
            return null;
        });
    }
    /**
     * Method for lambda - getData().
     * @return - list of tasks in data(open and close).
     */
    private List<Topic> lambdagetData(){
        return this.tx(session -> {
            List<Topic> list = (List<Topic>)session.createQuery("from Topic ").list();
            return list;
        });
    }

    @Override
    public void add(Topic task) {
        lambdaAdd(task);
    }

    @Override
    public void remove(Integer id) {
        lambdaRemove(id);
    }

    @Override
    public void update(Integer id, Topic task) {
        lambdaUpdate(id,task);
    }

    @Override
    public List<Topic> getData() {
        return lambdagetData();
    }

}
