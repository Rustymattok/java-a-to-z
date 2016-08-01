package chatSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
/**
 * Class for show in consoles.
 */
public class ShowInterface {

    public static void waitConnect(){
        System.out.println("ожидаем подключния клиента.....");
    }

    public static void connection(){
        System.out.println("подключено");
    }

    public static void nameText(String name,String text){
        System.out.printf("%s : %s",name,text);
        System.out.println();
    }

    public static String enterServerBotLog(String kindOfFile) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = null;
        try {
            if(kindOfFile.equals("log")) {
                System.out.println("Введите путь к файлу log - а");
            }else if (kindOfFile.equals("bot")){
                System.out.println("Введите путь к файлу Bot - а");
            }else if(kindOfFile.equals("adress")){
                System.out.println("Введите адресс сервера; ");
            }
            else {
                return null;
            }
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String enterName(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = null;
        try {
            result = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void showMassagefromServer(String text){
        System.out.println(text);
    }

    public static String yourName() {
        return "Введите ваше имя ";
    }

    public static void welcomeToChat(){
        for (int i = 0; i <20 ; i++) {
            System.out.println();
        }
        System.out.println("добро пожаловать в чат");
    }

    public static String forClientLog(String name,String text){
        return name + ": " + text;
    }

    public static void showText(String text){
        System.out.println(text);
    }

    public static void fileCreted(){
        System.out.println("новый файл создан");
    }

    public static void showAdressServer(InetAddress inetAddress){
        System.out.println("адресс для подключения: "+ inetAddress);
    }
    public static void showMenuChat(){
        System.out.println("Добро пожаловать");
        System.out.println("Введите server  -  если хотите запустить текущее приложение как сервер");
        System.out.println("Введите client  - если хотите запустить текущее приложение как клиент");
    }
}
