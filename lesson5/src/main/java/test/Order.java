package test;

public class Order {
    private String name;
    private String operation;
    private String price;
    private Integer id;
    private String volume;

    public Order(String name, String operation, String price,String volume,Integer id) {
        this.name = name;
        this.operation = operation;
        this.price = price;
        this.id = id;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", operation='" + operation + '\'' +
                ", price='" + price + '\'' +
                ", id='" + id + '\'' +
                ", volume='" + volume + '\'' +
                '}';
    }
}

