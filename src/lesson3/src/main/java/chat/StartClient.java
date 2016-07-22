package chat;

/**
 * Class for init Client.
 */
public class StartClient {
    private final static int SERVERPORT = 5555;
    private final static String ADRESS = "127.0.0.1";

    public static void main(String[] args) {
        Client client = new Client(SERVERPORT, ADRESS, args[0]);
        client.startWork();
    }
}
