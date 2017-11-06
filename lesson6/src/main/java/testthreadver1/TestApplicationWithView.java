package testthreadver1;

public class TestApplicationWithView {

    public static void main(String[] args) {
        GameTable gameTable = new GameTable(10,10);
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
                        gameTable.showBorder();
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
                        gameTable.showBorder();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
       thread1.start();
       thread2.start();
       if (thread1.isInterrupted() && thread2.isInterrupted()){
           Thread.interrupted();
       }
    }
}
