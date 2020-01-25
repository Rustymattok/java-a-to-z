package models;
import javax.persistence.*;
/**
 * Entity CarAnn -  for annotation realise.
 */
@Entity(name = "car")
public class CarAnn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "engine_id", foreignKey = @ForeignKey(name = "ENGINE_ID_FK") )
    private EngineAnn engineAnn;
    @Column(name = "name")
    private String name;

    public CarAnn() {
    }

    public CarAnn(EngineAnn engineAnn, String name) {
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

    public EngineAnn getEngineAnn() {
        return engineAnn;
    }

    public void setEngineAnn(EngineAnn engineAnn) {
        this.engineAnn = engineAnn;
    }

    @Override
    public String toString() {
        return "engine type " + engineAnn.getName() + "  car   " + getName();
    }
}
