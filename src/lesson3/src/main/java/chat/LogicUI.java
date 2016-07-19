package chat;
/**
 * This class describe logic of UI.
 */
public class LogicUI {
    /**
     * @param logicClient - logic of Client.
     *  @param logicServer - logic of Server.
     */
    private LogicClient logicClient;
    private LogicServer logicServer;

    public LogicUI(LogicClient logicClient, LogicServer logicServer) {
        this.logicClient = logicClient;
        this.logicServer = logicServer;
    }
    /**
     * Logic of UI.
     */
    public void init() {
        logicServer.getServer().init();
        logicClient.enterText();
        while (!logicClient.getText().equals("finish")) {
            logicServer.serverShow();
            logicClient.enterText();
            if (logicClient.getText().equals("stop")) {
                while (!logicClient.getText().equals("resume") && !logicClient.getText().equals("finish")) {
                    logicClient.enterText();
                }
            }
        }
    }
}

