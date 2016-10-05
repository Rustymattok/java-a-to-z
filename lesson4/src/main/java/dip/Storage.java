package dip;
/**
 * Interface for Storage.
 */
public interface Storage extends Show {
    void creat(User user);
    void edit(User user, String name, int age,int id);
    void delete(User user);
}
