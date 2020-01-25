package presistens;

import models.CarManyToMany;
import models.CarManyToManyAnnotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.Set;
import java.util.function.Function;
/**
 * DAO for many to many -by annotation.
 */
public class DaoManyToManyAnnotation implements StoreOwnerAnnotation {
    private static  final DaoManyToManyAnnotation INSTANCE = new DaoManyToManyAnnotation();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DaoManyToManyAnnotation() {
    }

    public static DaoManyToManyAnnotation getINSTANCE() {
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
    public void add(CarManyToManyAnnotation car) {
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
            CarManyToManyAnnotation car = session.get(CarManyToManyAnnotation.class,id);
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
    public void update(CarManyToManyAnnotation car, Set drivers) {
        this.tx(session -> {
            car.setDrivers(drivers);
            session.update(car);
            return null;
        });
    }
}
