package chatsocket;

import java.io.*;
import java.net.Socket;

/**
 * For init Client
 */
public class Client {
    /**
     * @param socket - socket for connecting to server.
     * @param name - init of name user.
     * @param resureceFile - files's way for take insert adress in local mashine."127.0.0.1"
     */
    private Socket socket;
    private String name;
    private String resureceFile;
    private ShowInterface showInterface = new ShowInterface();

    /**
     * Konstructor for connection with server.
     *
     * @param adress - adress of server.
     */
    public Client(String adress) {
        try {
            if (adress.equals("")) {
                String resureceFile = System.getProperty("user.home") + "\\resurce";
                System.out.println(resureceFile);
                File file = new File(resureceFile);
                if (!file.exists()) {
                    file.mkdir();
                }
                file = new File(resureceFile, "resurce.txt");
                if (!file.exists()) {
                    file.createNewFile();
                }
                resureceFile = resureceFile + "\\" + "resurce.txt";
                this.resureceFile = resureceFile;
                FileWriter fileWriter = new FileWriter(resureceFile);
                fileWriter.write("127.0.0.1");
                fileWriter.close();
            }
            BufferedReader bufferedReader = new BufferedReader(new FileReader(resureceFile));
            adress = bufferedReader.readLine();
            socket = new Socket(adress, Server.PORT);//todo указать адресс через InetAddress
            showInterface.connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Start work wiht
     *
     * @param clientLog - way for log.
     */
    public void startWork(String clientLog) {
        try {
            String text;
            String textFromServer;
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            FileLog fileLog = new FileLog(clientLog, "clientLog.txt");
            showInterface.showMassagefromServer(in.readLine());
            name = showInterface.enterName();
            out.println(name);
            showInterface.welcomeToChat();
            while (true) {
                text = reader.readLine();
                if (text.equals("finish")) {
                    out.println(text);
                    break;
                }
                out.println(text);
                text = showInterface.forClientLog("Вы", text);
                fileLog.saveLog(text);
                textFromServer = in.readLine();
                fileLog.saveLog(textFromServer);
                showInterface.showText(textFromServer);
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
