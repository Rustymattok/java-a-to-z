package sqltask.jdbc;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ParserDataXML implements AutoCloseable {
    private String url;
    private String nameData;
    private String user;
    private String password;
    private String parserFileWay;

    public ParserDataXML(String parserFileWay) {
        this.parserFileWay = parserFileWay;
    }
    /**
     * This method make parsing for all document line by line.
     * @throws IOException
     */
    public void parser() throws Exception {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(parserFileWay))) {
            bufferedReader.read();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("<entry url=")) {
                    url = line.replaceAll("<entry url=", "");
                    url = url.substring(0, url.length() - 2);
                    System.out.println(url);
                }
                if ((line.startsWith("<entry namedata="))) {
                    nameData = line.replaceAll("<entry namedata=", "");
                    nameData = nameData.substring(0, nameData.length() - 2);
                    System.out.println(nameData);
                }
                if ((line.startsWith("<entry user="))) {
                    user = line.replaceAll("<entry user=", "");
                    user = user.substring(0, user.length() - 2);
                    System.out.println(user);
                }
                if ((line.startsWith("<entry password="))) {
                    password = line.replaceAll("<entry password=", "");
                    password = password.substring(0, password.length() - 2);
                    System.out.println(password);
                }
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getNameData() {
        return nameData;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void close() throws Exception {
        System.out.println("yahoo");
    }
}
