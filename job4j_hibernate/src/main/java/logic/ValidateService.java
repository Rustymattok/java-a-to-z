package logic;
import persistent.DAOToDoHibernate;
import persistent.StoreTask;
/**
 * This class describe logic of Type Memory.
 * It uses singletone pattern for safety threadpul.
 */
public class ValidateService {
    private final StoreTask logic = DAOToDoHibernate.getINSTANCE();
    private final static ValidateService instance = new ValidateService();

    private ValidateService(){
    }
    public static ValidateService getInstance(){
        return instance;
    }

    public StoreTask getLogic() {
        return logic;
    }

}
