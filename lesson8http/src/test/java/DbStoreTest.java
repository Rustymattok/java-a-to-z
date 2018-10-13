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
    /*
     <dependency>
            <groupId>postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>9.1-901-1.jdbc4</version>
        </dependency>
     */

    @Test
    public void findById(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.findById("6").getName());
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