package logic;
import persistent.MemoryStore;
import persistent.Store;
/**
 * This class describe logic of Type Memory.
 * It uses singletone pattern for safety threadpul.
 */
public class ValidateService {
    private final Store logic = MemoryStore.getInstance();
    private  static ValidateService instance;

    private ValidateService(){

    }

    public static ValidateService getInstance(){
        if(instance ==null){
            instance = new ValidateService();
        }
        return instance;
    }

    public void add(User user){
        logic.add(user);
    }
    public void update(String id){
        logic.update(id);
    }
    public void delete(String id){
        logic.delete(id);
    }
    boolean findAll(User user){
        boolean flag = false;
        if(logic.findAll(user)){
            flag = true;
        }
        return flag;
    }
    public User findById(String id){
        return logic.findById(id);
    }
}
