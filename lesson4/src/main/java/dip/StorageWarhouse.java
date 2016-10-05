package dip;

import java.util.ArrayList;
/**
 * Class for test of Storage application.
 */
public class StorageWarhouse implements Storage {
    /**
     * @param compareInt - parameter of interface to choose different logic for validation.
     * @param listUser - list of items (Users).
     */
    ValidateImp compareInt;
    private ArrayList<User> listUser = new ArrayList<User>();

    public StorageWarhouse(ValidateImp compareInt) {
        this.compareInt = compareInt;
    }


    public void creat(User user) {
        if(!compareInt.validate(user,listUser)){
            listUser.add(user);
        }
    }

    public void edit(User user, String name, int age,int id) {
        if(compareInt.validate(user, listUser)){
            user.setName(name);
            user.setAge(age);
            user.setId(id);
        }
    }

    public void delete(User user) {
        int index = 0;
        for(User userDelete: listUser){
            if (compareInt.validate(user,userDelete)){
                listUser.remove(index);
                break;
            }
            index++;
        }
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void showTest() {
        for(User user : listUser){
            System.out.println(user.getName() + "   " + user.getAge() + "   " +  user.getId());
        }
        System.out.println();
    }
}
