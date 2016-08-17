package chatsocket;

import java.io.*;
import java.util.Random;
/**
 * Class for Server Logic
 */
public class ServerLogic {
    /**
     * @param fileServer - way for file Server Bot.
     * @param list - list of vriables word wich were taken from Server Bot.
     */
    private String fileServer;
    private String[] list;
    private ShowInterface showInterface = new ShowInterface();

    /**
     * init Logic.
     * @param fileServer - - way for file Server Bot.
     */
    public ServerLogic(String fileServer) {
        if (fileServer.equals("")){
            fileServer = System.getProperty("user.home") + "\\temp\\server.txt";
        }
        this.fileServer = fileServer;
        File file = new File(fileServer);
        if(!file.exists()){
            try {
                file.createNewFile();
                FileWriter fileWriter = new FileWriter(file);
                for (int i = 0; i < DataBot.getList().length; i++) {
                    fileWriter.write(DataBot.getList()[i]);
                    fileWriter.append(("\r\n"));
                }
                fileWriter.flush();
                fileWriter.close();
                showInterface.fileCreted();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        init();
    }

    public void init(){
        try {
            int count = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileServer));
            list = new String[getSize() + 1];
            String text = "";
            while ((text != null)){
                text = bufferedReader.readLine();
                list[count] = text;
                count++;
            }
            for (int i = 0; i < getSize() ; i++) {
                System.out.println(list[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Method for size of massive of list varabiles.
     * @return size of massive.
     */
    public int getSize() {
        int count = 0;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(fileServer));
            while ((fileReader.readLine()) != null) {
                count++;
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public String[] getList() {
        return list;
    }

    public int randomIndex(){
        Random random = new Random();
        int maxSize = getSize();
        random.nextInt(maxSize);
        return random.nextInt(maxSize);
    }
}
