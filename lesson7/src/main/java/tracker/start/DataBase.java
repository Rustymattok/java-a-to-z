package tracker.start;

import java.sql.*;
import java.util.List;
/**
 * Class allow to connect to dataBase. and make some injections and operations.
 */
public class DataBase {
    private Connection con;
    private WorkBase workBase;

    public DataBase(WorkBase workBase) {
        this.workBase = workBase;
    }
    /**
     * Method for connection to dataBase.
     */
    public void connectToDataBase(){
        String fullWayToData = new StringBuilder().append(workBase.getUrl()).append("/").append(workBase.getNameData()).toString();
        try {
            con = DriverManager.getConnection(fullWayToData, workBase.getUser(), workBase.getPassword());
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
            Statement st = con.createStatement();
            String taskSQL = new StringBuilder().append("SELECT * FROM").append(" ").append(workBase.getNameTable()).toString();
            ResultSet rs = st.executeQuery(taskSQL);
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
            Statement st = con.createStatement();
            String taksCreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ").append(workBase.getNameTable()).append(" (n INTEGER)").toString();
            st.execute(taksCreateTable);
            String taksDeleteTable = new StringBuilder().append("DELETE FROM").append(" ").append(workBase.getNameTable()).toString();
            st.execute(taksDeleteTable);
//            for (int i = 0; i < workBase.getNumbersAdd(); i++) {
//                String taksInsertIntoTable = new StringBuilder().append("INSERT INTO").append(" ").append(workBase.getNameTable()).append("(n) VALUES (?);").toString();
//                PreparedStatement ps = con.prepareStatement(taksInsertIntoTable);
//                ps.setInt(1, i)
//                ps.executeUpdate();
//            }
            //todo необходимо пониание о корректности методики раставления коммитов для базы данных.
//            con.commit();
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
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432", workBase.getUser(), workBase.getPassword());
                Statement st =  con.createStatement();
                String hrappSQL = new StringBuilder().append("CREATE DATABASE").append(" ").append(workBase.getNameTable()).toString();
                st.executeUpdate(hrappSQL);
                String taksInsertIntoTable = new StringBuilder().append("CREATE TABLE tasks (id integer,name char(10),description  char(10), date date);").toString();
                st.executeUpdate(taksInsertIntoTable);
            }
            catch (SQLException e) {
              //  e.printStackTrace();
            }
        }
    }
    /**
     * Method for import dataBase to XML format.
     * @param list - crteated nodes from data.
     */
    public void importToXML(List<Entry> list){
        try {
            Statement st = con.createStatement();
            String taskSQL = new StringBuilder().append("SELECT * FROM").append(" ").append(workBase.getNameTable()).toString();
            ResultSet rs = st.executeQuery(taskSQL);
            while (rs.next())
            {
                //list.add(new Entry(new StringBuilder().append("mean of pole").append(" ").append(rs.getString(1)).toString()));
                list.add(new Entry(rs.getString(1).toString()));
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method for close all operations.
     */
    public void closeData(){
        Statement st = null;
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


    public WorkBase getWorkBase() {
        return workBase;
    }
}