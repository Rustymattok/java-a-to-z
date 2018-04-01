package chatsocket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Class for save files.
 */
public class FileLog{
    private String fileName;

    public FileLog(String fileName,String nameApp){
        try {
            if (fileName.equals("")) {
                fileName = System.getProperty("user.home") + "\\temp";
                System.out.println(fileName);
                File file = new File(fileName);
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(fileName, nameApp);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileName = fileName + "\\" + nameApp;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //todo ���������� ����� ������
        this.fileName = fileName;
    }

    public void saveLog(String text){
        try {

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
