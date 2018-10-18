import logic.User;
import logic.ValidateService;
import org.junit.Test;
import persistent.DbStore;

public class DbStoreTest {
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Test
    public void add() {
        work.getLogic().add(new User("fff","sss","kkk"));
    }

    @Test
    public void findById(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.findById("5").getName());
    }

    @Test
    public void deleteTest(){
        DbStore dbStore =  DbStore.getInstance();
        dbStore.delete("7");
    }

    @Test
    public void sizeTest(){
       // System.out.println(work.getLogic().size());
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.IndicateID(1));
    }
}