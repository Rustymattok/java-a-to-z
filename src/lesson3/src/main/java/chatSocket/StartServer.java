package chatSocket;
/**
 * Class for init Server.
 */
public class StartServer {
    public static void main(String[] args) {
        //"C:\\java-a-to-z-master\\src\\lesson3\\src\\main\\java\\chatSocket\\files\\logServer.txt"
//        "C:\\java-a-to-z-master\\src\\lesson3\\src\\main\\java\\chatSocket\\files\\server.txt"
//        makarov-note/192.168.203.86
        args = new String[5];
        if (args[0] == null && args[1] == null){
            args[0] = ShowInterface.enterServerBotLog("log");
            args[1] = ShowInterface.enterServerBotLog("bot");
        }
        Server server = new Server();
        server.startWork(args[0],args[1]);
    }
}
