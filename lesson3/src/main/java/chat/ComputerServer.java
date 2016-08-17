package chat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class describe server parametres.
 */
public class ComputerServer {
    /**
     * @param server - String parametre way for server's doc.
     * @param text - text in the doc server file.
     * @param fileReader - thread for reading file.
     * @param chooseText - massive for keeping parametrs of text in buffer.
     */
    private String serverFile;
    private String text;
    private BufferedReader fileReader;
    private String[] chooseText;

    public ComputerServer(String fileLog) {
        serverFile = fileLog;
        chooseText = new String[getSize()];
        init();
    }
    /**
     * This method use for init in buffer from file.
     */
    public void init(){
        try {
            System.out.println(serverFile);
            fileReader = new BufferedReader(new FileReader(serverFile));
            int count = 0;
            while ((text=fileReader.readLine()) != null){
                chooseText[count] = text;
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            File filecreat = new File(serverFile);
            try {
                filecreat.createNewFile();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    /**
     * This method for reciveing counts of lines in doc file for server.
     * @return count - size of massive String.
     */
    public int getSize() {
        int count = 0;
        try {
            fileReader = new BufferedReader(new FileReader(serverFile));
            while ((text = fileReader.readLine()) != null) {
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public void setServerFile(String serverFile) {
        this.serverFile = serverFile;
    }

    public String[] getChooseText() {
        return chooseText;
    }

    public void setChooseText(String[] chooseText) {
        this.chooseText = chooseText;
    }
}
