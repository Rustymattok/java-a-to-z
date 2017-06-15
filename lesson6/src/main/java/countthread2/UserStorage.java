package countthread2;
import java.util.HashMap;
import java.util.Map;
/**
 * Class of User Storage. It consists from HashMap data base and its method.
 */
public class UserStorage implements BaseFunctions{

    private HashMap<Integer,User> list = new HashMap<Integer,User>();
    private int id = 0 ;
    /**
     *
     * @param user - user which we need to add to our list.
     */
    @Override
    public void add(User user) {
        if(!checkList(user)){
            user.setId(getID());
            list.put(user.getId(),user);
        }
        else {
            System.out.println("Error, this user in the list. ");
        }
    }
    /**
     *
     * @param user - user which we need to edit in our list.
     */
    @Override
    public void edit(User user) {
        if(checkList(user)){
            for (Map.Entry<Integer,User> userList : list.entrySet()) {
                if (userList.getKey() == user.getId() && userList.getValue().getName().equals(user.getName())) {
                    userList.getValue().setName("VladimirEdited");
                }
            }
        }
    }
    /**
     * This method allow us to read our list.
     */
    @Override
    public void read() {
        if(list.size() > 0) {
            for (Map.Entry<Integer, User> userList : list.entrySet()) {
                System.out.println("The id : " + userList.getKey() + " name : " + userList.getValue().getName() + " amount : " + userList.getValue().getAmount());
            }
        }
    }
    /**
     *
     * @param user - user which we need to delete in our list.
     */
    @Override
    public void delete(User user) {
        if(checkList(user)){
            list.remove(user.getId());
        }
    }
    /**
     *
     * @param user - user which we checked to contain in our list.
     * @return true if this method contain in list.
     */
    public boolean checkList(User user){
        boolean flag = false;
        for (Map.Entry<Integer,User> userList : list.entrySet()) {
            if(userList.getKey() == user.getId() && userList.getValue().getName().equals(user.getName())){
                flag = true;
            }
        }
        return flag;
    }
    /**
     * Method wich allow to transfer money.
     * @param user1 -  balance where we take money.
     * @param user2 - balance where we transfer money.
     * @param sum -  amount of money for transfer.
     */
    public  synchronized void  amount(User user1, User user2, int sum){

        if ( user1.getAmount() > sum) {
            int amount = (int) (user2.getAmount() + sum);
            user2.setAmount((int) (amount));
            user1.setAmount((int) (user1.getAmount() - sum));
        }
    }
    /**
     *
     * @return id number of user in our list.
     */
    public Integer getID(){
        id++;
        return id;
    }
    /**
     *
     * @return list - whole list.
     */
    public HashMap<Integer, User> getList() {
        return list;
    }
}
