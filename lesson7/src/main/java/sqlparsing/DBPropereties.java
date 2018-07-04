package sqlparsing;
import java.io.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Logger;
/**
 * Class responsoble for propereties of jdbc .
 */
public class DBPropereties {
    private String url;
    private String nameTable;
    private String username;
    private String password;
    private String lastDate;
    private String weblink;
    private String corExp;
    private String fileWay;
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public DBPropereties(String fileWay) {
        this.fileWay = fileWay;
    }
    /**
     * Parsing of app.propeeties file for indicate data.
     */
    public void initData(){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream(fileWay);
            property.load(fis);
            url = property.getProperty("jdbc.url");
            nameTable = property.getProperty("jdbc.nameTable");
            username = property.getProperty("jdbc.username");
            password = property.getProperty("jdbc.password");
            weblink = property.getProperty("jdbc.weblink");
            corExp = property.getProperty("jdbc.corExp");
            lastDate = property.getProperty("jdbc.lastDate");
        } catch (Exception e) {
            LOGGER.info("not found FILE :");
        }
    }
    /**
     * Update app,properties file
     * @param date -  add last date which we add to sql.
     */
    public void setNewDate(String date){
        ArrayList<String> list = new ArrayList<>();
        File file = new File(fileWay);
        FileWriter fr = null;
        BufferedWriter br = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileWay));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                if((line.startsWith("jdbc.lastDate"))){
                    line = "jdbc.lastDate = " + date;
                }
                list.add(line);
            }
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            fr.write("");
            for (int i = 0; i < list.size() ; i++) {
                br.write(list.get(i));
                br.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getUrl() {
        return url;
    }

    public String getNameTable() {
        return nameTable;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getWeblink() {
        return weblink;
    }

    public String getLastDate() {
        return lastDate;
    }

    public String getFileWay() {
        return fileWay;
    }

    public String getCorExp() {
        return corExp;
    }
}
