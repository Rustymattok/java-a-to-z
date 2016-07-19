package chat;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * This class describe logic of Client.
 */
public class LogicClient {
    /**
     * @param client - Client parameter.
     * @param text - Strint text wich entered.
     */
    private Client client;
    private String text;

    public LogicClient(Client client) {
        this.client = client;
    }
    /**
     * This method for enter text and save in logfile.
     */
    public void enterText() {
        boolean flag = false;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            try {
                FileWriter fileClient = new FileWriter(client.getFile(), true);
                System.out.println("Введите текст: ");
                text = bufferedReader.readLine();
                String index = "Клиент: " + text;
                fileClient.write(index);
                fileClient.append("\r\n");
                fileClient.flush();
                fileClient.close();
                flag = false;
              } catch (IOException e) {
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
