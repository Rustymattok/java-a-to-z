package ru.makarov.application.logicui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class for creat or write in logFile.
 */
public class FileLog {
    private String fileName;
    /**
     * Check files log,if it absents new files will be created.
     * @param fileName - way for log files.
     * @param nameApp - name of log files.
     */
    public FileLog(String fileName,String nameApp){
        try {
            if (fileName.equals("")) {
                fileName = new StringBuilder().append(System.getProperty("user.home")).append("\\temp").toString();
                File file = new File(fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(fileName, nameApp);
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            fileName = new StringBuilder().append(fileName).append("\\").append(nameApp).toString();
        }catch (IOException e){
            e.printStackTrace();
        }
        this.fileName = fileName;
    }
    /**
     * Method for saving result.
     * @param text - text for saving in log files.
     */
    public void saveLog(String text){
        try {
            System.out.println(text);//todo in realize delet this line.
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(text);
            fileWriter.append(("\r\n"));
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
