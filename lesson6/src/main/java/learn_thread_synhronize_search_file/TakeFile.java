package learn_thread_synhronize_search_file;
import java.util.ArrayList;
/**
 * This class contain List of files after searching directory.
 * The List update online during work of program.
 */
public class TakeFile {

    static int count = 0;

    private static ArrayList<String> list = new ArrayList<String>();

    public static synchronized void addFile(String fileName){
        list.add(fileName);
        count++;
    }

    public static synchronized ArrayList<String> getList() {
        return list;
    }

    public static int getCount() {
        return count;
    }
}
