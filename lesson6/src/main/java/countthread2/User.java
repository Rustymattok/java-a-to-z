package countthread2;
/**
 * Class Describe parmeters of Users and its methods.
 */
public class User {

    private String name;
    private Integer id;
    private Integer amount;

    public User(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public User(String name) {
        this.name = name;
        amount = 0;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
