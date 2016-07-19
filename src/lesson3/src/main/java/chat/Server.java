package chat;

import java.io.*;
/**
 * This class describe server parametres.
 */
public class Server {
    /**
     * @param server - String parametre way for server's doc.
     * @param text - text in the doc server file.
     * @param fileReader - thread for reading file.
     * @param chooseText - massive for keeping parametrs of text in buffer.
     */
    final String server = "D:\\Учеба\\Java-учеба\\java-a-to-z\\src\\lesson3\\src\\main\\java\\chat\\file\\server.txt";
    private String text;
    private BufferedReader fileReader;
    private String[] chooseText = new String[getSize()];

    public Server() {
    }
    /**
     * This method use for init in buffer from file.
     */
    public void init(){
        try {
            fileReader = new BufferedReader(new FileReader(server));
            int count = 0;
            while ((text=fileReader.readLine()) != null){
                chooseText[count] = text;
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            File filecreat = new File(server);
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
            fileReader = new BufferedReader(new FileReader(server));
            while ((text = fileReader.readLine()) != null) {
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String[] getChooseText() {
        return chooseText;
    }

    public void setChooseText(String[] chooseText) {
        this.chooseText = chooseText;
    }
}
