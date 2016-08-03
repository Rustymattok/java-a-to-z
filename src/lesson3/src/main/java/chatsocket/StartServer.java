package chatsocket;
/**
 * Class for init Server.
 */
public class StartServer {
    public static void main(String[] args) {
        //"C:\\java-a-to-z-master\\src\\lesson3\\src\\main\\java\\chatsocket\\files\\logServer.txt"
//        "C:\\java-a-to-z-master\\src\\lesson3\\src\\main\\java\\chatsocket\\files\\server.txt"
//        makarov-note/192.168.203.86
        ShowInterface showInterface = new ShowInterface();
        args = new String[5];
        if (args[0] == null && args[1] == null){
            args[0] = showInterface.enterServerBotLog("log");
            args[1] = showInterface.enterServerBotLog("bot");
        }
        Server server = new Server();
        server.startWork(args[0],args[1]);
    }
}
