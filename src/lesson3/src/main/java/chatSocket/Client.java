package chatSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * For init Client
 */
public class Client {
    /**
     * @param socket - socket for connecting to server.
     * @param name - init of name user.
     */
    private  Socket socket;
    private String name;

    /**
     * Konstructor for connection with server.
     * @param adress - adress of server.
     */
    public Client(String adress){
        try {
            socket = new Socket(adress,Server.PORT);//todo указать адресс через InetAddress
            ShowInterface.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start work wiht
     * @param clientLog - way for log.
     */
    public void startWork(String clientLog){
        try {
            String text;
            String textFromServer;
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileLog fileLog = new FileLog(clientLog);
            ShowInterface.showMassagefromServer(in.readLine());
            name = ShowInterface.enterName();
            out.println(name);
            ShowInterface.welcomeToChat();
            while (true){
                text = reader.readLine();
                if (text.equals("finish")){
                    out.println(text);
                    break;
                }
                 out.println(text);
                 text = ShowInterface.forClientLog("Вы",text);
                 fileLog.saveLog(text);
                 textFromServer = in.readLine();
                 fileLog.saveLog(textFromServer);
                 ShowInterface.showText(textFromServer);
                 out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
