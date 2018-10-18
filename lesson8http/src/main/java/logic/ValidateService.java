package logic;
import persistent.Store;
/**
 * This class describe logic of Type Memory.
 * It uses singletone pattern for safety threadpul.
 */
public class ValidateService {
    private final Store logic;
    private  static ValidateService instance;
    private  int ID = 0 ;

    private ValidateService(Store logic){
        this.logic = logic;
    }

    public static ValidateService getInstance(Store logic){
        if(instance ==null){
            instance = new ValidateService(logic);
        }
        return instance;
    }

    public Store getLogic() {
        return logic;
    }

    public  int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }


}
