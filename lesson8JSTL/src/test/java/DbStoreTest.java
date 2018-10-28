import logic.User;
import logic.ValidateService;
import org.junit.Test;
import persistent.DbStore;

public class DbStoreTest {
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Test
    public void add() {
        //work.getLogic().add(new User("fff","sss","kkk"));
        DbStore db = DbStore.getInstance();
        db.add(new User("fff","sss","kkk"));
    }

    @Test
    public void position() {
        //work.getLogic().add(new User("fff","sss","kkk"));
        DbStore db = DbStore.getInstance();
        System.out.println(db.position());
    }

    @Test
    public void findById(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.findById("52").getName());
    }

    @Test
    public void deleteTest(){
        DbStore dbStore =  DbStore.getInstance();
        dbStore.delete("7");
    }

    @Test
    public void sizeTest(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.IndicateID(1));
    }
}