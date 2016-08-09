package ru.makarov.application.logicui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * This class for creat or write in logFile.
 */
public class FileLog {
    private String fileName;

    public FileLog(String fileName,String nameApp){
        try {
            if (fileName.equals("")) {
                fileName = System.getProperty("user.home") + "\\temp";
                File file = new File(fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                System.out.println(fileName);
                file = new File(fileName, nameApp);
                if (!file.exists()) {
                    file.createNewFile();
                }
            }
            fileName = fileName + "\\" + nameApp;
            System.out.println(fileName);
        }catch (IOException e){
            e.printStackTrace();
        }
        this.fileName = fileName;
    }

    public void saveLog(String text){
        try {
            System.out.println(text + "-------->");
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
