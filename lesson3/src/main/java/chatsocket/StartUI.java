package chatsocket;
/**
 * Class for start application .
 */
public class StartUI {
    public static void main(String[] args) {
        String comand;
        ShowInterface showInterface = new ShowInterface();
        showInterface.showMenuChat();
        comand = showInterface.enterName();
        if ( comand.equals("server")){
            StartServer start = new StartServer();
            start.main(args);
        }else if(comand.equals("client")){
            StartClient client = new StartClient();
            client.main(args);
        }
    }
}
