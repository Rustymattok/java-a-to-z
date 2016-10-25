package part2.generic.example;
/**
 * Class describe Roles.
 */
public class Role extends Base {
    public Role(String id) {
        super(id);
    }

    @Override
    String getId() {
        return super.id;
    }

    @Override
    void seID(String id) {
        super.id = id;
    }
}