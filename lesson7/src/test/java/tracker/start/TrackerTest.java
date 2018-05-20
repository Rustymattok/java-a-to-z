package tracker.start;

import org.junit.Test;

public class TrackerTest {
    @Test
    public void whenShouldCheckAdd() throws InterruptedException{
        WorkBase workBase = new WorkBase("jdbc:postgresql://localhost:5432","tracker","postgres","admin");
        DataBase dataBase = new DataBase(workBase);
        dataBase.connectToDataBase();
        dataBase.deleteItem("159");
        //dataBase.addItem(new Item("111","vova2","about me",new Date()));
    }

}