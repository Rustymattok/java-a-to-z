package learn_thread_synhronize_search_file;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 * This Thread looking for files in Directory.
 */
public class ThreadFileSearch implements Runnable {
    /**
     * @param myVisitor - init type of standart parsing.
     * @param path - way of directory which we should start to parse.
     */
    private MyFileVisitor myVisitor;
    private Path path ;

    public ThreadFileSearch(MyFileVisitor myVisitor, Path path) {
        this.myVisitor = myVisitor;
        this.path = path;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(100*i);
            }
            Files.walkFileTree(path,myVisitor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
