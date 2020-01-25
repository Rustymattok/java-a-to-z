package models;
/**
 * Entity Car -  for XML realise.
 */
public class Car {
    private int id;
    private Engine engine;
    private String name;

    public Car() {
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

    @Override
    public String toString() {
        return "engine type " + engine.getName() + "  car   " + getName();
    }
}
