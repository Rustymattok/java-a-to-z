package tracker.start;

import tracker.models.Item;
import java.text.DateFormat;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
            System.out.println("server found");
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
    Method for tests Describe syntax how to add elements
     */
    public void addItem(Item item){
        try{
            Statement st = con.createStatement();
            String taksCreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ")
                    .append(workBase.getNameTable()).append("(id text,name text,description text,data date);").toString();
            st.execute(taksCreateTable);
            String taskInsertIntoTable = new StringBuilder().append("INSERT INTO")
                   .append(" ")
                   .append(workBase.getNameTable())
                   .append(" (id,name,description,data) VALUES ('"+item.getID()+"','"+item.getName()+"','"+item.getDescription()+"','"+item.getDate()+"');").toString();
            st.execute(taskInsertIntoTable);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method for create new DataBase if it's absent.
     */
    public void creatNewDataBase(){
        if(con == null) {
            try {
                con = DriverManager.getConnection("jdbc:postgresql://localhost:5432", workBase.getUser(), workBase.getPassword());
                Statement st =  con.createStatement();
                String hrappSQL = new StringBuilder().append("CREATE DATABASE").append(" ").append(workBase.getNameTable()).toString();
                st.executeUpdate(hrappSQL);
            }
            catch (SQLException e) {
            }
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
    /**
     *
     * @param id
     * @return item -  found by ID.
     */
    public Item searchById(String id){
        Item result = new Item();
        String selectTableSQL = "SELECT id,name,description,data FROM itemtrack WHERE id = '"+id+"'";
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectTableSQL);
            if (rs != null){
                while (rs.next()) {
                    result.setID(rs.getString("id"));
                    result.setName(rs.getString("name"));
                    result.setDescription(rs.getString("description"));
                    Date date = convertToDate(rs.getString("data"));
                    result.setCurrentDate(date);
                }
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    /**
     *
     * @param item - item for edit data.
     */
    public void editItem(Item item){
        item.setDate();
        String selectTableSQL = "UPDATE itemtrack SET name='"+item.getName()+"',description='"+item.getDescription()+"',data = '"+item.getDate()+"' WHERE id = '"+item.getID()+"'";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(selectTableSQL);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param id - find item by this id and remove.
     */
    public void deleteItem(String id){
        String selectTableSQL = "DELETE FROM itemtrack WHERE id = '"+id+"';";
        try{
            Statement st = con.createStatement();
            st.executeUpdate(selectTableSQL);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     *
     * @param dateString - data in String type for convert.
     * @return data.
     */
    private Date convertToDate(String dateString){
        Date date = new Date();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}