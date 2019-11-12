package logic;
import persistent.DbStorePostgres;
import persistent.Store;
/**
 * This class describe logic of Type Memory.
 * It uses singletone pattern for safety threadpul.
 */
public class ValidateService {
    private final  Store logic = DbStorePostgres.getINSTANCE();
    private final static ValidateService instance = new ValidateService();

    private ValidateService(){

    }

    public static ValidateService getInstance(){
        return instance;
    }

    public Store getLogic() {
        return logic;
    }

}
