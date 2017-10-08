package learn_thread_synhronize_search_file;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
/**
 * This Test for checking Thread of Appication. You can check Application researching your created log.txt file.
 */
public class ThreadTestProgramm {
    /**
     * For checking, you should creat your directories with files. And use path for this way.
     * Key word for parsing . In this case this is "hello".
     */
    @Test
    public void whenShouldCheckAppl(){
        Deque deque = new Deque();
        LogicLog logicLog = new LogicLog(deque,"hello");
        MyFileVisitor myFileVisitor = new MyFileVisitor(deque);
        Path path = Paths.get("F:\\JAVA\\testDir");
        ThreadTextSearch threadSearchFile = new ThreadTextSearch(logicLog);
        ThreadFileSearch threadSearchText = new ThreadFileSearch(myFileVisitor,path);
        Thread threadF = new Thread(threadSearchFile);
        Thread threadT = new Thread(threadSearchText);
        threadT.start();
        try {
            Thread.sleep(2000);
            threadT.join();
            threadF.start();
            threadF.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish the program");
    }
}
