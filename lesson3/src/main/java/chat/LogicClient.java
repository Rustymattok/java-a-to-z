package chat;

import java.io.*;
import java.net.Socket;

/**
 * This class describe logic of ClientServer.
 */
public class LogicClient {
    /**
     * @param clientServer - ClientServer parameter.
     * @param text - Strint text wich entered.
     */
    private ClientServer clientServer;
    private String text;
    private boolean flagClient = true;

    public LogicClient(ClientServer clientServer) {
        this.clientServer = clientServer;
    }

    /**
     * This method for enter text and save in logfile.
     */
    public void enterText() {
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileWriter fileClient = new FileWriter(clientServer.getFile(), true);
            System.out.println("Введите текст: ");
            text = bufferedReader.readLine();
            String index = "Клиент: " + text;
            fileClient.write(index);
            fileClient.append("\r\n");
            fileClient.flush();
            fileClient.close();
            flag = false;
        } catch (IOException e) {
        }
    }
    /**
     * Method for save logs.
     * @param text - from chat.
     */
    public void saveLog(String text) {
        try {
            FileWriter fileClient = new FileWriter(clientServer.getFile(), true);
            String index = "Клиент: " + text;
            fileClient.write(index);
            fileClient.append("\r\n");
            fileClient.flush();
            fileClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method describe logic UI.
     * @param socket
     * @param in
     * @param text
     */
    public void logicUI(Socket socket, DataInputStream in,String text) {
        try {
            if (text.equals("finish")) {
                socket.close();
            } else if (text.equals("stop")) {
                flagClient = false;
                System.out.println("Сервер: ");
            } else if (text.equals("resume") && !flagClient) {
                flagClient = true;
                text = in.readUTF();
                System.out.println("Сервер: " + text);
            } else if (flagClient) {
                text = in.readUTF();
                System.out.println("Сервер: " + text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ClientServer getClientServer() {
        return clientServer;
    }

    public void setClientServer(ClientServer clientServer) {
        this.clientServer = clientServer;
    }
}
