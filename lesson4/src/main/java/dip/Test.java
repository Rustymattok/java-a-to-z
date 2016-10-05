package dip;
/**
 * Class for Tests.
 */
public class Test {
    public static void main(String[] args) {
        ValidateImp compareInt = new Validate();
        Storage storageWarhouse = new StorageWarhouse(compareInt);
        User user =  new User("Petia3",12,4);
        storageWarhouse.creat(new User("Petia1",12,2));
        storageWarhouse.creat(new User("Petia2",12,3));
        storageWarhouse.creat(user);
        storageWarhouse.showTest();
        storageWarhouse.edit(user, "Petia3", 3, 2);
        storageWarhouse.showTest();
        storageWarhouse.delete(user);
        storageWarhouse.showTest();
    }
}