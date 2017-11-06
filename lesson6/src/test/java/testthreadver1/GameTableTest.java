package testthreadver1;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class GameTableTest {

    @Test
    public void whenShouldCheckinit() throws InterruptedException {
        GameTable gameTable = new GameTable(10,10);
        Logic logic = new LogicBot(gameTable);
        Person person = new Person("Vladimir",logic);
        person.getLogic().initPerson();
        person.getLogic().movePerson();
        int result = gameTable.checkBorder();
        assertThat(result, is(1));
    }

    @Test
    public  void whenShouldCheckWithThreads() throws  InterruptedException{
        GameTable gameTable = new GameTable(10,10);
        int sum = 0;
        final int[] result = {0,0};
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Logic logicBot = new LogicBot(gameTable);
                Person person = new Person("Vladimir1", logicBot);
                person.getLogic().initPerson();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                        person.getLogic().movePerson();
                        result[0] = gameTable.checkBorder();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 =new Thread(new Runnable() {
            @Override
            public void run() {
                Logic logicBot = new LogicBot(gameTable);
                Person person = new Person("Vladimir2", logicBot);
                person.getLogic().initPerson();
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                        person.getLogic().movePerson();
                        result[1] = gameTable.checkBorder();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        if(result[0] == result[1]){
            sum = result[0];
        }
        assertThat(sum, is(2));
    }
}
