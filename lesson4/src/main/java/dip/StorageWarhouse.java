package dip;

import java.util.ArrayList;
/**
 * Class for test of Storage application.
 */
public class StorageWarhouse implements Storage {
    CompareInt compareInt;
    /**
     * @param liatUser - list of User .
     */
    private ArrayList<User> listUser = new ArrayList<User>();

    public StorageWarhouse(CompareInt compareInt) {
        this.compareInt = compareInt;
    }
    /**
     * Add to the list of User new User.
     * @param user
     */
    public void creat(User user) {
        listUser.add(user);
    }

    public void edit(User user,String name,int age,int id ) {
        if(compareInt.compare(user.getName(),user.getAge(),user.getId())){
            user.setName(name);
            user.setAge(age);
            user.setId(id);
        }
    }

    public void delete(User user) {

    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void showTest() {
        for(User user : listUser){
            System.out.println(user.getName() + "   " + user.getAge() + "   " +  user.getId());
        }
    }
}
