package models;
import javax.persistence.*;
/**
 * Entity EngineAnnotation -  for annotation realise.
 */
@Entity(name = "engine")
public class EngineAnnotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    public EngineAnnotation() {
    }

    public EngineAnnotation(int id) {
        this.id = id;
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
}
