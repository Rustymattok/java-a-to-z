package learn_thread_synhronize_search_file;

import java.io.*;

/**
 * This class for creat or write in logFile. By default the name of file log.txt.
 */
public class FileLog {
    private String nameApp;
    /**
     * Init Log file. Constructor ( if it absent) create directory user/temp.
     * This is the way where log file will be locate.
     */
    public FileLog() {
        try {
                nameApp = "log.txt";
                File file = new File(new StringBuilder().append(System.getProperty("user.home")).append("\\temp").toString(),nameApp);
                if (!file.exists()) {
                    file.createNewFile();
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method for saving result.
     *
     * @param text - text for saving in log file.
     */
    public void saveLog(String text) {
        try {
            String  wayFile = new StringBuilder().append(System.getProperty("user.home")).append("\\temp\\").append(nameApp).toString();
            FileWriter fileWriter = new FileWriter(wayFile, true);
            fileWriter.write(text);
            fileWriter.append(("\r\n"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


