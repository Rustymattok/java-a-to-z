package presistens;
import models.CarManyToMany;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.function.Function;
/**
 * DAO for many to many.
 */
public class DaoManyToManyXMLSample implements StoreOwner {
    private static  final DaoManyToManyXMLSample INSTANCE = new DaoManyToManyXMLSample();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DaoManyToManyXMLSample() {
    }

    public static DaoManyToManyXMLSample getINSTANCE() {
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
     * Add to DATA new car.
     * @param car - car added.
     */
    @Override
    public void add(CarManyToMany car) {
        this.tx(session -> {
            session.save(car);
            return null;
        });
    }
    /**
     * Remove from DATA car by ID.
     * @param id - removed by id.
     */
    @Override
    public void remove(Integer id) {
        this.tx(session -> {
            CarManyToMany car = session.get(CarManyToMany.class,id);
            session.remove(car);
            return null;
        });
    }
    /**
     * Update car in data - value for update new driver.
     * @param car - car to update.
     * @param drivers - add new driver.
     */
    @Override
    public void update(CarManyToMany car, Set drivers) {
        this.tx(session -> {
            car.setDrivers(drivers);
            session.update(car);
            return null;
        });
    }
}
