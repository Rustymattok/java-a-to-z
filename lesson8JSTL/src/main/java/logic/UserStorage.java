package logic;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * Class discribe data base of users.
 */
//todo Сделать привязка к таблице Postgresql пользователей.
//todo Распредилить роли
public class UserStorage {
    private static final UserStorage instance = new UserStorage();
    private List<UserLogin> users = new CopyOnWriteArrayList<UserLogin>();

    private UserStorage(){
        users.add(new UserLogin("root","root","root"));
    }
    /**
     * Method to check user availeble or not.
     * @param login - login off user.
     * @param password -  password off user.
     * @return true/false.
     */
    public boolean isCredentional(String login, String password){
        boolean flag = false;
        for(UserLogin userLogin : users){
            if(userLogin.getLogin().equals(login) && userLogin.getPassword().equals(password)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static UserStorage getInstance() {
        return instance;
    }

    public List<UserLogin> getUsers() {
        return users;
    }
}
