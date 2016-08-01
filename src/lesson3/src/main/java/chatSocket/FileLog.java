package chatSocket;

import java.io.FileWriter;
import java.io.IOException;
/**
 * Class for save file.
 */
public class FileLog{
    private String fileName;

    public FileLog(String fileName){
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
