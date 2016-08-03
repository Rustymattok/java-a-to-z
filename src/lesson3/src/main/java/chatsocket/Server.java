package chatsocket;


import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * For init Server.
 */
public class Server {
    /**
     * @param PORT - port name for socket.
     * @param nameServer - name of server.
     * @param socket - socket server.
     */
    static final int PORT = 5555;
    private final String nameServer = "Сервер";
    private Socket socket;
    private ShowInterface showInterface= new ShowInterface();
    /**
     * init Server.
     */
    public Server() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            InetAddress inetAddress = InetAddress.getLocalHost();
            showInterface.showAdressServer(inetAddress);
            showInterface.waitConnect();
            socket = serverSocket.accept();
            showInterface.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for start Server.
     * @param serverLog - way to file for Logs.
     * @param serverBot - way to file for serverBot.
     */
    public void startWork(String serverLog,String serverBot) {
        try {
            String text;
            String messageServer = "";
            boolean flag = true;
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ServerLogic logic = new ServerLogic(serverBot);//todo сделать ввот пути файла сервер бота
            out.println(showInterface.yourName());
            out.flush();
            String name = in.readLine();
            FileLog fileLog = new FileLog(serverLog,"serverLog.txt");
            while ((text = in.readLine()) != null) {
                if (text.equals("finish")) {
                    socket.close();
                    break;
                }
                flag = logicUI(text, flag);
                showInterface.nameText(name, text);
                text = name + ": " + text;
                fileLog.saveLog(text);
                if (flag) {
                    messageServer = logic.getList()[logic.randomIndex()];
                    showInterface.nameText(nameServer, messageServer);
                    messageServer = nameServer + ": " + messageServer;
                    out.println(messageServer);
                    fileLog.saveLog(messageServer);
                    out.flush();
                }else{
                    out.println("Сервер: ");
                }
                out.flush();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean logicUI(String text, boolean flag) {
        if (text.equals("stop")) {
            //todo сделать так чтобы ничего не отправлялось в лог и клиенту
            flag = false;
        } else if (text.equals("resume")) {
            //todo сделать так чтобы вновь все отправлялось
            flag = true;
        }
        return flag;
    }
}
