package learn_thread_synhronize_search_file;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
/**
 * Class allow to make search dir by dir. Standart library.
 */
public class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        find(file);
        return FileVisitResult.CONTINUE;
    }
    /**
     *Method for add files in List which loicated throw all directory.
     * @param path - way of file which taken from visitFile.
     */
    public void find(Path path){
        String way = new StringBuilder().append(path.getParent().toString()).append("\\").append(path.getFileName().toString()).toString();
        TakeFile.addFile(way);
    }

}
