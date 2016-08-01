package chat;

/**
 * Class for init Client.
 */
public class StartClient {
    private static final int SERVERPORT = 5555;
    private static final String ADRESS = "127.0.0.1";

    public static void main(String[] args) {
        Client client = new Client(SERVERPORT, ADRESS, args[0]);
        client.startWork();
    }
}
