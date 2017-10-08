package learn_thread_synhronize_search_file;
import java.io.*;
/**
 * Class describe loggic of searching needed file by text.
 */
final  class SeachLogic {
    private String text;

     SeachLogic(String text) {
        this.text = text;
    }
    /**
     * Method for activate searching.
     * @param fileName - way of file which should be parse.
     * @return true/false.
     */
    final boolean searchText(String fileName) {
        boolean flag = false;
        BufferedReader bufferedReader = null;
        try {
            if (fileName.contains(".txt")) {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (line.contains(text)) {
                        flag = true;
                    }
                }
                return flag;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public String getText() {
        return text;
    }
}



