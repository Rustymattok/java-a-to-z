package chat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
/**
 * This class describe logic of Server.
 */
public class LogicServer {
    /**
     * @param server - parameter of Server.
     * @param file - String parameter way to the folder of logfile.
     * @param text - String parameter random text for chat.
     */
    private Server server;
    private final String file = "D:\\Учеба\\Java-учеба\\java-a-to-z\\src\\lesson3\\src\\main\\java\\chat\\file\\text.txt";
    private String text;

    public LogicServer(Server server) {
        this.server = server;
    }

    public void serverShow(){
            System.out.println(enterText());
    }

    /**
     * This method save to log file random text.
     * @return text which was added to logfile.
     */
    public String enterText() {
            try {
                FileWriter fileClient = new FileWriter(file,true);
                text = server.getChooseText()[randomIndex()];
                String index = "Сервер: " + text;
                fileClient.write(index);
                fileClient.append("\r\n");
                fileClient.flush();
                fileClient.close();
            } catch (IOException e) {
        }
        return text;
    }
    /**
     * Method chooce random index.
     * @return index.
     */
    public int randomIndex(){
        Random random = new Random();
        int maxSize = server.getSize();
        random.nextInt(maxSize);
        return random.nextInt(maxSize);
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public String getFile() {
        return file;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
