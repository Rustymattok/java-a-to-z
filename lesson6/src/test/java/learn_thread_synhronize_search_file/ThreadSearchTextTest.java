package learn_thread_synhronize_search_file;
import org.junit.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * This Test for checking Thread of SearchTExt.(it allow to find files in Directories.
 */
public class ThreadSearchTextTest {
    /**
     * For checking, use should creat your directories with files. And use path for this way.
     */
    @Test
    public void whenShouldCheckSearchText(){
        MyFileVisitor myFileVisitor = new MyFileVisitor();
        Path path =  Paths.get("F:\\JAVA\\testDir");
        try {
            Files.walkFileTree(path,myFileVisitor);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertThat(TakeFile.getList().size(),is(7));
    }
}