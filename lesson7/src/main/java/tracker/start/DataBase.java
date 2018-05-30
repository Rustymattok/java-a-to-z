package tracker.start;

import tracker.models.Item;
import java.text.DateFormat;
import java.util.Date;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;


/**
 * Class allow to connect to dataBase. and make some injections and operations.
 */
public class DataBase {
    private Connection con;
    private WorkBase workBase;
    private String fullWayToData;
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public DataBase(WorkBase workBase) {
        this.workBase = workBase;
        this.fullWayToData = new StringBuilder().append(workBase.getUrl()).append("/").append(workBase.getNameData()).toString();
        System.out.println(fullWayToData);
    }
    /**
     * Method for connection to dataBase.
     */
    public void connectToDataBase(){
        try {
            con = DriverManager.getConnection(fullWayToData, workBase.getUser(), workBase.getPassword());
            con.setAutoCommit(false);
            System.out.println("server found");
        } catch (SQLException e) {
            LOGGER.info("connect to DATA :");
            creatNewDataBase();
        }
    }
    /**
    Method for tests Describe syntax how to add elements
     */
    public void addItem(Item item){
            String taksCreateTable = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ")
                    .append(workBase.getNameTable()).append("(id text,name text,description text,data date);").toString();
             String taskInsertIntoTable = new StringBuilder().append("INSERT INTO ").append(workBase.getNameTable())
                  .append(" VALUES (?,?,?,?)").toString();
            try {
                PreparedStatement st = con.prepareStatement(taksCreateTable);
                st.execute();
                st = con.prepareStatement(taskInsertIntoTable);
                st.setString(1,item.getID());
                st.setString(2,item.getName());
                st.setString(3,item.getDescription());
                st.setObject(4,java.sql.Date.valueOf(java.time.LocalDate.now()));
                st.executeUpdate();
            } catch (SQLException e) {
                LOGGER.info("add Item: :");
                e.printStackTrace();
            }
    }
    /**
     * Method for create new DataBase if it's absent.
     */
    public void creatNewDataBase(){
        if(con == null) {
            try {
                String hrappSQL = new StringBuilder().append("CREATE DATABASE").append(" ").append(workBase.getNameTable()).toString();
                con = DriverManager.getConnection(fullWayToData, workBase.getUser(), workBase.getPassword());
                PreparedStatement st = con.prepareStatement(hrappSQL);
                st.execute();
            }
            catch (SQLException e) {
                LOGGER.info("create new  DATA :");
                e.printStackTrace();
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
            LOGGER.info("close DATA :");
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
            con = DriverManager.getConnection(fullWayToData, workBase.getUser(), workBase.getPassword());
            PreparedStatement st = con.prepareStatement(selectTableSQL);
            ResultSet rs = st.executeQuery();
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
            LOGGER.info("search by id in DATA :");
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
            PreparedStatement st = con.prepareStatement(selectTableSQL);
            st.executeUpdate();
        }catch (SQLException e) {
            LOGGER.info("edit Item in DATA :");
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
            PreparedStatement st = con.prepareStatement(selectTableSQL);
            st.executeUpdate();
        }catch (SQLException e) {
            LOGGER.info("delete Item in DATA :");
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
            LOGGER.info("covert Date :");
            e.printStackTrace();
        }
        return date;
    }
}