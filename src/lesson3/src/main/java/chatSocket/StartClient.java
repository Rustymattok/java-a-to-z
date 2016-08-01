package chatSocket;
/**
 * Class for init Client.
 */
public class StartClient {
    public static void main(String[] args) {
        //"C:\\java-a-to-z-master\\src\\lesson3\\src\\main\\java\\chatSocket\\files\\logClient.txt"
        args = new String[5];
        if (args[1] == null && args[2] == null){
            args[1] = ShowInterface.enterServerBotLog("log");
            args[2] = ShowInterface.enterServerBotLog("adress");
        }
        Client client = new Client(args[2]);
        client.startWork(args[1]);
    }
}
