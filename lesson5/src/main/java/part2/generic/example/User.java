package part2.generic.example;
/**
 * Class for Users.
 */
public class User extends Base {
    public User(String id) {
        super(id);
    }

    @Override
    String getId() {
        return super.id;
    }

    @Override
    void setID(String id) {
        super.id = id;
    }
}
