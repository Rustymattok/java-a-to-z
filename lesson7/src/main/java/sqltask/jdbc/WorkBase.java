package sqltask.jdbc;
/**
 * Class for describe parameters of work database.
 */
public class WorkBase {

    private  String url;
    private  String nameData;
    private  String user;
    private  String password;
    private  String nameTable;
    private int numbersAdd;

    public WorkBase(String url, String nameData, String user, String password,int numbersAdd ) {
        this.url = url;
        this.nameData = nameData;
        this.user = user;
        this.password = password;
        this.numbersAdd = numbersAdd;
        nameTable = "numbers";
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNameData() {
        return nameData;
    }

    public void setNameData(String nameData) {
        this.nameData = nameData;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameTable() {
        return nameTable;
    }

    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    public int getNumbersAdd() {
        return numbersAdd;
    }

    public void setNumbersAdd(int numbersAdd) {
        this.numbersAdd = numbersAdd;
    }
}
