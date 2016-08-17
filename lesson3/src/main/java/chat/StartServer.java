package chat;
/**
 * Class for init Server.
 */
public class StartServer {
    private final static int SERVERPORT = 5555;

    public static void main(String[] args) {
        Server server = new Server(SERVERPORT,args[1],args[0]);
        server.startWork();
    }
}
