package sqltask.jdbc;
import org.junit.Test;

public class DataBaseTest {
    @Test
    public void whenShouldCheckAction() throws InterruptedException {
        DataBase dataBase = new DataBase("jdbc:postgresql://localhost:5432","nametest2","postgres","admin");
        dataBase.connectToDataBase();
        dataBase.initTable();
        dataBase.readTest();
        dataBase.closeData();
        // assertThat(simpleAction.isFlag(), is(true));
    }
}