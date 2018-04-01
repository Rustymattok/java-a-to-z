package learn_thread_synhronize_search_file;

import java.io.*;

/**
 * This class for creat or write in logFile. By default the name of files log.txt.
 */
final class FileLog {
    private String nameApp;
    /**
     * Init Log files. Constructor ( if it absent) create directory user/temp.
     * This is the way where log files will be locate.
     */
      FileLog() {
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
     * @param text - text for saving in log files.
     */
    final  void saveLog(String text) {
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


