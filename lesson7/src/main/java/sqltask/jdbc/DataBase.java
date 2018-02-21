package sqltask.jdbc;
import java.sql.*;
/**
 * Class allow to connect to dataBase. and make some injections and operations.
 */
public class DataBase {
    private Connection con;
    private Statement st;
    private String url;
    private String nameData;
    private String user;
    private String password;
    private ResultSet rs;
    private String fullWayToData;
    private String nameTable;
    private int n;

    public DataBase(String url, String nameData, String user, String password) {
        con = null;
        st = null;
        rs = null;
        this.url = url;
        this.nameData = nameData;
        this.user = user;
        this.password = password;
        fullWayToData = new StringBuilder().append(url).append("/").append(nameData).toString();
        nameTable = "numbers";
    }
    /**
     * Method for connection to dataBase.
     */
    public void connectToDataBase(){
        try {
            con = DriverManager.getConnection(fullWayToData, user, password);
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("created dataBase");
            creatNewDataBase();
        }
    }
    /**
     * Method for read dataBase.
     */
    public void readTest(){
        try {
            st = con.createStatement();
            String taskSQL = new StringBuilder().append("SELECT * FROM").append(" ").append(nameTable).toString();
            rs = st.executeQuery(taskSQL);
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method for init table depends of N - numbers.
     */
    public void initTable(){
        try {
            st = con.createStatement();
            String taksCreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ").append(nameTable).append(" (n INTEGER)").toString();
            st.execute(taksCreateTable);
            String taksDeleteTable = new StringBuilder().append("DELETE FROM").append(" ").append(nameTable).toString();
            st.execute(taksDeleteTable);
            for (int i = 0; i < n; i++) {
                String taksInsertIntoTable = new StringBuilder().append("INSERT INTO").append(" ").append(nameTable).append("(n) VALUES (?);").toString();
                PreparedStatement ps = con.prepareStatement(taksInsertIntoTable);
                ps.setInt(1, i);
                ps.executeUpdate();
            }
            //todo необходимо пониание о корректности методики раставления коммитов для базы данных.
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
    /**
     * Method for create new DataBase if it absent.
     */
    public void creatNewDataBase(){
        if(con == null) {
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432", user, password);
                st =  con.createStatement();
                String hrappSQL = new StringBuilder().append("CREATE DATABASE").append(" ").append(nameData).toString();
                st.executeUpdate(hrappSQL);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Method for close all operations.
     */
    public void closeData(){
        try {
            if (con!=null) {
                con.close();
            }
            if (st != null){
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public Statement getSt() {
        return st;
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

    public void setN(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    public String getNameTable() {
        return nameTable;
    }
}