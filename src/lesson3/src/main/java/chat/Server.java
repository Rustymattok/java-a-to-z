package chat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * This class server clients work.
 */
public class Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private ClientServer clientServer;
    private ComputerServer computerServer;
    private String fileServer;
    /**
     * Konsturctor for init server.
     * @param port
     */
    public Server(int port,String fileLog, String fileServer){
        this.fileServer = fileServer;
        clientServer = new ClientServer(fileServer);
        computerServer = new ComputerServer(fileLog);
            try {
            serverSocket = new ServerSocket(port);
            System.out.println("ждем подключения");
            socket = serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("подключение состоялось");
    }

    /**
     *  method for start work with logic chat.
     */
    public void startWork(){
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);
            String text = null;
            while (true){
                text = in.readUTF();
                System.out.println("Клиент: " + text);
                LogicServer logicServer = new LogicServer(computerServer,fileServer);
                LogicClient logicClient = new LogicClient(clientServer);
                text = logicServer.enterText();
                System.out.println("Сервер :" + text);
                out.writeUTF(text);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ComputerServer getComputerServer() {
        return computerServer;
    }

    public void setComputerServer(ComputerServer computerServer) {
        this.computerServer = computerServer;
    }

    public ClientServer getClientServer() {
        return clientServer;
    }

    public void setClientServer(ClientServer clientServer) {
        this.clientServer = clientServer;
    }
}
