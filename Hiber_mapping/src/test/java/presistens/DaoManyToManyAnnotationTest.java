package presistens;
import models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * Many to many annotation.
 */
public class DaoManyToManyAnnotationTest {
    /**
     *Test Many to many annotation -> add new car with init properties(driver,engine...).
     */
    @Test
    public void add() {
        DaoManyToManyAnnotation dao = DaoManyToManyAnnotation.getINSTANCE();
        /*
        This block for choose drive from DATABASE.
        */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        DriverManyToManyAnnotation driver = session.get(DriverManyToManyAnnotation.class,1);
        session.getTransaction().commit();
        session.close();
        factory.close();
        /*
        Preparation set of drivers for new car.
         */
        Set drivers = new HashSet();
        drivers.add(driver);
        /*
        This block for init new engine in One to Many tables engine.
         */
        DaoOneToManyAnnotation daoEng = DaoOneToManyAnnotation.getINSTANCE();
        EngineAnnotation engine = new EngineAnnotation();
        engine.setName("Z06");
        daoEng.add(engine);
        /*
        Create new car for insert to DataBase.
         */
        CarManyToManyAnnotation car = new CarManyToManyAnnotation();
        car.setName("Almera4");
        car.setEngine(engine);
        car.setDrivers(drivers);
        dao.add(car);
    }
    /**
     *Test Many to many annotation -> update car driver.
     */
    @Test
    public void update() {
        DaoManyToManyAnnotation dao = DaoManyToManyAnnotation.getINSTANCE();
        /*
        This block for choose drivers and car from DATABASE for current vehicle.
        */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        DriverManyToManyAnnotation driver = session.get(DriverManyToManyAnnotation.class,2);
        CarManyToManyAnnotation car = session.get(CarManyToManyAnnotation.class,13);
         /*
        Preparation set of drivers for current car.
         */
        Set drivers = new HashSet();
        drivers.add(driver);
        for (Iterator iterator2 = car.getDrivers().iterator(); iterator2.hasNext();){
            DriverManyToManyAnnotation drDriver = (DriverManyToManyAnnotation) iterator2.next();
            drivers.add(drDriver);
        }
        session.getTransaction().commit();
        session.close();
        factory.close();
        /*
        Update current car drivers.
         */
        dao.update(car,drivers);
    }
    /**
     *Test Many to many annotation -> remove car.
     */
    @Test
    public void remove() {
        DaoManyToManyAnnotation dao = DaoManyToManyAnnotation.getINSTANCE();
        dao.remove(13);
    }
}