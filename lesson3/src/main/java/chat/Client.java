package chat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
/**
 * This class describe clients work.
 */
public class Client {
    /**
     * @param socket - connection.
     */
    private Socket socket;
    private ClientServer clientServer;

    /**
     * Konstructor for init Client.
     * @param port - of server.
     * @param intetAdress - adress of server.
     */
    public Client(int port, String intetAdress,String file) {
        clientServer = new ClientServer(file);
        InetAddress inetAddress = null;
        try {
            inetAddress = InetAddress.getByName(intetAdress);
            System.out.println("подключаемся к серву " + port);
            socket = new Socket(inetAddress, port);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * method for start work with logic chat.
     */
    public void startWork() {
        try {
            //clientServer = new ClientServer();
            LogicClient logicClient = new LogicClient(clientServer);

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inputStream);
            DataOutputStream out = new DataOutputStream(outputStream);

            String text = null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                text = reader.readLine();
                out.writeUTF(text);
                out.flush();
                logicClient.logicUI(socket, in, text);
                logicClient.saveLog(text);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   public ClientServer getClientServer() {
        return clientServer;
    }
}

