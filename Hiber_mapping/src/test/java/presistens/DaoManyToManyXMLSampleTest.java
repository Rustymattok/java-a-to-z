package presistens;
import models.CarManyToMany;
import models.DriverManyToMany;
import models.Engine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 * Many to many xml.
 */
public class DaoManyToManyXMLSampleTest {
    /**
     *Test Many to many xml -> add new car with init properties(driver,engine...).
     */
    @Test
    public void add(){
        DaoManyToManyXMLSample dao = DaoManyToManyXMLSample.getINSTANCE();
        /*
        This block for choose drive from DATABASE.
        */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        DriverManyToMany driver = session.get(DriverManyToMany.class,1);
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
        DaoOneToOneXMLSample daoEngine = DaoOneToOneXMLSample.getINSTANCE();
        Engine engine = new Engine();
        engine.setName("Z04");
        daoEngine.add(engine);
        /*
        Create new car for insert to DataBase.
         */
        CarManyToMany car = new CarManyToMany();
        car.setName("Almera3");
        car.setEngine(engine);
        car.setDrivers(drivers);
        dao.add(car);
    }
    /**
     *Test Many to many xml -> update car driver.
     */
    @Test
    public void update() {
        DaoManyToManyXMLSample dao = DaoManyToManyXMLSample.getINSTANCE();
        /*
        This block for choose drivers and car from DATABASE for current vehicle.
        */
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        DriverManyToMany driver = session.get(DriverManyToMany.class,2);
        CarManyToMany car = session.get(CarManyToMany.class,12);
         /*
        Preparation set of drivers for current car.
         */
        Set drivers = new HashSet();
        drivers.add(driver);
        for (Iterator iterator2 =  car.getDrivers().iterator(); iterator2.hasNext();){
            DriverManyToMany drDriver = (DriverManyToMany) iterator2.next();
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
     *Test Many to many xml -> remove car.
     */
    @Test
    public void remove() {
        DaoManyToManyXMLSample dao = DaoManyToManyXMLSample.getINSTANCE();
        dao.remove(2);
    }
}