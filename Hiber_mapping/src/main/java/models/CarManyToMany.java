package models;
import java.util.HashSet;
import java.util.Set;
/**
 * Entity Car many to many -  for XML realise.
 */
public class CarManyToMany {
    private int id;
    private Engine engine;
    private String name;
    private Set drivers = new HashSet();

    public CarManyToMany() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Set getDrivers() {
        return drivers;
    }

    public void setDrivers(Set drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "engine type " + engine.getName() + "  car   " + getName();
    }
}
