package logic;
import persistent.Store;
/**
 * This class describe logic of Type Memory.
 * It uses singletone pattern for safety threadpul.
 */
public class ValidateService {
    private final Store logic;
    private  static ValidateService instance;

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
}
