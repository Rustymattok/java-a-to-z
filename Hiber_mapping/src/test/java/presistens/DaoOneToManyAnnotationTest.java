package presistens;
import models.CarAnnotation;
import models.EngineAnnotation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
/**
 * One to many - Annotation.
 */
public class DaoOneToManyAnnotationTest {
    /**
     *Test One to many annotation -> add new car with init properties(engine...).
     */
    @Test
    public void add() {
        /*
        This block for choose engine from DATABASE.
        */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        EngineAnnotation engine = session.get(EngineAnnotation.class,6);
        session.getTransaction().commit();
        session.close();
        factory.close();
        /*
        This block to add car with engine to  DATABASE.
        */
        DaoOneToManyAnnotation dao = DaoOneToManyAnnotation.getINSTANCE();
        CarAnnotation car = new CarAnnotation();
        car.setName("Ford");
        car.setEngineAnn(engine);
        dao.add(car);
    }
    /**
     *Test One to many annotation -> remove car by Index.
     */
    @Test
    public void remove() {
        DaoOneToManyAnnotation dao = DaoOneToManyAnnotation.getINSTANCE();
        dao.remove(5);
    }
    /**
     *Test One to many annotation -> update car by Index.
     */
    @Test
    public void update() {
        DaoOneToManyAnnotation dao = DaoOneToManyAnnotation.getINSTANCE();
        dao.update(14);
    }
}