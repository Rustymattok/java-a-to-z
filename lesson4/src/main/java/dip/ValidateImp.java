package dip;

import java.util.ArrayList;
/**
 * Interface for validation.
 */
public interface ValidateImp {
    boolean validate(User user,ArrayList<User> listUser);
    boolean validate(User user,User userItem);

}
