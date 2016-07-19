package chat;
/**
 * Class for init application.
 */
public class StartUI {

    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Server server = new Server();
        LogicServer logicServer = new LogicServer(server);
        LogicClient logicClient = new LogicClient(client);
        LogicUI logicUI = new LogicUI(logicClient,logicServer);
        logicUI.init();
    }
}


