package presistens;

import models.Car;
import models.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.function.Function;

/**
 * This class describe DAO using technology. Class is a singltone.
 */
public class DaoOneToOneXMLSample implements Store {
    private static  final DaoOneToOneXMLSample INSTANCE = new DaoOneToOneXMLSample();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DaoOneToOneXMLSample() {
    }

    public static DaoOneToOneXMLSample getINSTANCE() {
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
     * Add new car to DATA.
     * @param car - car to add.
     */
    @Override
    public void add(Car car) {
        this.tx(session -> {
           session.save(car);
           return null;
       });
    }
    /**
     * Add new engine to data.
     * @param engine -  to add to data.
     */
    @Override
    public void add(Engine engine) {
        this.tx(session -> {
            session.save(engine);
            return null;
        });
    }
    /**
     * Remove car by id from DATA.
     * @param id -  remove by id.
     */
    @Override
    public void remove(Integer id) {
        this.tx(session -> {
            Car car = session.get(Car.class,id);
            session.remove(car);
            return null;
        });
    }
    /**
     * Update car in DATA by id.
     * @param id -  car id.
     */
    @Override
    public void update(Integer id) {
        this.tx(session -> {
            Car car= session.get(Car.class,id);
            car.setName(car.getName() + ">" +"new");
            session.update(car);
            return null;
        });
    }
}
