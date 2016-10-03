package dip;
/**
 * Class describe logic of compare.
 */
public class Compare implements  CompareInt{

    public Compare( ) {
    }
    /**
     *
     * @param name - parameter of User.
     * @param age - parameter of User.
     * @param id - parameter of User.
     * @return true or false.
     */
    public boolean compare(String name, int age, int id) {
        boolean flag = false;
        User user = new User(name,age,id);
        if (user.getName().equals(name) && user.getAge() == age && user.getId() == id){
            flag = true;
        }
        return flag;
    }
}
