package chat;

/**
 * Class for init application.
 */
public class StartUI {

    public static void main(String[] args) throws InterruptedException {
        ClientServer clientServer = new ClientServer(args[0]);
        ComputerServer computerServer = new ComputerServer(args[1]);
        LogicServer logicServer = new LogicServer(computerServer,args[1]);
        LogicClient logicClient = new LogicClient(clientServer);
        LogicUI logicUI = new LogicUI(logicClient,logicServer);
        logicUI.init();
    }
}


