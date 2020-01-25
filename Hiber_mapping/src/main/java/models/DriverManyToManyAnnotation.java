package models;
import javax.persistence.*;
import java.util.Set;
/**
 * Entity Driver many to many -  for annotation realise.
 */
@Entity(name = "driver")
public class DriverManyToManyAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @ManyToMany(mappedBy = "drivers")
    private Set<CarManyToManyAnnotation> cars;

    public DriverManyToManyAnnotation() {
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
