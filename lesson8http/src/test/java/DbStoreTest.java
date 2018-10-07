import logic.User;
import logic.ValidateService;
import org.junit.Test;
import persistent.DbStore;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class DbStoreTest {
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Test
    public void add() {
        work.getLogic().add(new User("fff","sss","kkk"));
    }

    @Test
    public void findById(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.findById("8").getId());
    }

    @Test
    public void deleteTest(){
        DbStore dbStore =  DbStore.getInstance();
        dbStore.delete("7");
    }

    @Test
    public void sizeTest(){
        System.out.println(work.getLogic().size());
    }
}