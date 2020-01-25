package presistens;
import models.CarAnn;
import models.Engine;
import models.EngineAnn;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.function.Function;
/**
 * DAO one to many by Annotation.
 */
public class DaoOneToManyAnnotation implements StoreAnn {
    private static  final DaoOneToManyAnnotation INSTANCE = new DaoOneToManyAnnotation();
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();

    private DaoOneToManyAnnotation() {
    }

    public static DaoOneToManyAnnotation getINSTANCE() {
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
     * Add to data new car.
     * @param car - car to add.
     */
    @Override
    public void add(CarAnn car) {
        this.tx(session -> {
            session.save(car);
            return null;
        });
    }
    /**
     * Add to data new car.
     * @param engine - engine to add.
     */
    @Override
    public void add(EngineAnn engine) {
        this.tx(session -> {
            session.save(engine);
            return null;
        });
    }
    /**
     * Remove car by id from DATA.
     * @param id -  remove by this id.
     */
    @Override
    public void remove(Integer id) {
        this.tx(session -> {
            CarAnn car = session.get(CarAnn.class,id);
            session.remove(car);
            return null;
        });
    }
    /**
     * Update car by id in DATA.
     * @param id -  car id to update.
     */
    @Override
    public void update(Integer id) {
        this.tx(session -> {
            CarAnn car= session.get(CarAnn.class,id);
            car.setName(car.getName() + ">" +"new");
            session.update(car);
            return null;
        });
    }
}
