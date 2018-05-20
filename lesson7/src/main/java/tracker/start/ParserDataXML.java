package tracker.start;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ParserDataXML implements AutoCloseable {
    private String url;
    private String nameData;
    private String user;
    private String password;
    private String parserFileWay;
    private BufferedReader bufferedReader;

    public ParserDataXML(String parserFileWay) {
        this.parserFileWay = parserFileWay;
    }
    /**
     * This method make parsing for all document line by line.
     * @throws IOException
     */
    public void parser() throws IOException {
            bufferedReader = new BufferedReader(new FileReader(parserFileWay));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("<entry url=")) {
                    url = line.replaceAll("<entry url=","");
                    url = url.substring(0, url.length() - 2);
                }
                if ((line.startsWith("<entry namedata="))) {
                    nameData = line.replaceAll("<entry namedata=", "");
                    nameData = nameData.substring(0, nameData.length() - 2);
                }
                if ((line.startsWith("<entry user="))) {
                    user = line.replaceAll("<entry user=", "");
                    user = user.substring(0, user.length() - 2);
                }
                if ((line.startsWith("<entry password="))) {
                    password = line.replaceAll("<entry password=","");
                    password = password.substring(0, password.length() - 2);
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

    @Override
    public void close() throws Exception {
        bufferedReader.close();
    }
}
