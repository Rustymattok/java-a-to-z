package dip;

import java.util.ArrayList;
/**
 * This class describe logic for check.
 */
public class Validate implements ValidateImp {
    /**
     * This method use to check user in this list.
     * @param userCheck
     * @param listUser
     * @return
     */
    public boolean validate(User userCheck,ArrayList<User> listUser ) {
        boolean flag = false;
        if(listUser != null) {
            for (User user : listUser) {
                if (user.getName().equals(userCheck.getName()) && user.getAge() == userCheck.getAge() &&
                        user.getId() == userCheck.getId()){
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
    /**
     * This method ocmpare two objects of User.
     * @param user
     * @param userItem
     * @return
     */
    public boolean validate(User user, User userItem) {
        boolean flag = false;
        if (user.getName().equals(userItem.getName()) && user.getAge() == userItem.getAge() &&
                user.getId() == userItem.getId()){
            flag = true;
        }
        return flag;
    }
}
