package models;
import javax.persistence.*;
import java.util.Set;
/**
 * Entity Car many to many -  for annotation realise.
 */
@Entity(name = "car")
public class CarManyToManyAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK") )
    private EngineAnnotation engine;
    @Column(name = "name")
    private String name;
    @ManyToMany
    @JoinTable(name = "history_owner", joinColumns = @JoinColumn(name = "car_id"), inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private Set<DriverManyToManyAnnotation> drivers;

    public CarManyToManyAnnotation() {
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

    public EngineAnnotation getEngine() {
        return engine;
    }

    public void setEngine(EngineAnnotation engine) {
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
