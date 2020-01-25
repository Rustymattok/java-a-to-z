package models;
import java.util.HashSet;
import java.util.Set;
/**
 * Entity Driver many to many -  for XML realise.
 */
public class DriverManyToMany {
    private int id;
    private String name;
    private Set cars = new HashSet();

    public DriverManyToMany() {
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

    public Set getCars() {
        return cars;
    }

    public void setCars(Set cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Driver " + getName();
    }
}
