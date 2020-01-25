package models;
import javax.persistence.*;
/**
 * Entity CarAnnotation -  for annotation realise.
 */
@Entity(name = "car")
public class CarAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK") )
    private EngineAnnotation engineAnn;
    @Column(name = "name")
    private String name;

    public CarAnnotation() {
    }

    public CarAnnotation(EngineAnnotation engineAnn, String name) {
        this.engineAnn = engineAnn;
        this.name = name;
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

    public EngineAnnotation getEngineAnn() {
        return engineAnn;
    }

    public void setEngineAnn(EngineAnnotation engineAnn) {
        this.engineAnn = engineAnn;
    }

    @Override
    public String toString() {
        return "engine type " + engineAnn.getName() + "  car   " + getName();
    }
}
