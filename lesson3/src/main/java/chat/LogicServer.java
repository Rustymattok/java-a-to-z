package chat;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * This class describe logic of ComputerServer.
 */
public class LogicServer {
    /**
     * @param computerServer - parameter of ComputerServer.
     * @param files - String parameter way to the folder of logfile.
     * @param text - String parameter random text for chat.
     */
    private ComputerServer computerServer;
    private String file;
    private String text;

    public LogicServer(ComputerServer computerServer,String file) {
        this.file = file;
        this.computerServer = computerServer;
    }

    public void serverShow(){
            System.out.println(enterText());
    }

    /**
     * This method save to log files random text.
     * @return text which was added to logfile.
     */
    public String enterText() {
            try {
                FileWriter fileClient = new FileWriter(file,true);
                text = computerServer.getChooseText()[randomIndex()];
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
        int maxSize = computerServer.getSize();
        random.nextInt(maxSize);
        return random.nextInt(maxSize);
    }

    public void setFile(String file) {
        this.file = file;
    }

    public ComputerServer getComputerServer() {
        return computerServer;
    }

    public void setComputerServer(ComputerServer computerServer) {
        this.computerServer = computerServer;
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
