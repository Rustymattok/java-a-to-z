package persistent;

import logic.IdGenerator;
import logic.User;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStore INSTANCE = new DbStore();
    private IdGenerator idGenerator = IdGenerator.getInstance();

    public DbStore() {
        String url = "jdbc:postgresql://localhost:5432";
        String userName = "postgres";
        String admin = "admin";
        SOURCE.setUrl(url);
        SOURCE.setUsername(userName);
        SOURCE.setPassword(admin);
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }
    /**
     * This Method add to database additional item.
     * @param user - added element to data.
     */
    @Override
    public void add(User user) {
        String taskInsertIntoTable = new StringBuilder().append("INSERT INTO ").append("tableJSP")
                .append(" VALUES (?,?,?,?)").toString();
        String taksCreateTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("tableJSP").append("(id text,name text,login text,email text);").toString();
        String countId = new StringBuilder().append("SELECT id FROM tablejsp;").toString();
        try {
            Connection connection = SOURCE.getConnection();
            /*
            Operation to creation the table if not exists.
             */
            Statement st = connection.prepareStatement(taksCreateTable);
            ((PreparedStatement) st).executeUpdate();
            /*
            Operation to calculate id for user. Id =  common size of table + 1.
             */
            String resultID = null;
            Statement st1 = connection.createStatement();
            ResultSet res = st1.executeQuery(countId);
            int num = 0;
            while (res.next()) {
                resultID = res.getString(1);
                if(Integer.valueOf(resultID) > num){
                    num = Integer.valueOf(resultID);
                }
            }
            idGenerator.setLastId(Long.valueOf(num));
            user.setId(String.valueOf(idGenerator.getNextId()));
            PreparedStatement sta = connection.prepareStatement(taskInsertIntoTable);
            sta.setString(1, user.getId());
            sta.setString(2, user.getName());
            sta.setString(3, user.getLogin());
            sta.setObject(4, user.getEmail());
            sta.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method update element of data by ID.
     * @param id - id user.
     * @param name - name user.
     * @param login - login user.
     * @param email - email user.
     */
    @Override
    public void update(String id, String name, String login, String email) {
        String task = new StringBuilder().append(" UPDATE tablejsp SET name = '").append(name).append("',login = '").
                append(login).append("',email = '").append(email).append("' WHERE id = '").append(id).append("';").toString();
       doTask(task);
    }
    /**
     *This method delete element from data by ID.
     * @param id - of use which we want to delete.
     */
    @Override
    public void delete(String id) {
        String task = new StringBuilder().append("DELETE FROM tablejsp WHERE id = '").append(id).append("';").toString();
        doTask(task);
    }
    /**
     * Method for working with different tasks for database.
     * @param task
     */
    public void doTask(String task){
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            st.executeUpdate(task);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method calculate common size of data .
     * @return - size of data.
     */
    @Override
    public int size() {
        Integer i = null;
        String task = new StringBuilder().append("select count(*) from tablejsp;").toString();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
              i = Integer.valueOf(res.getString(1));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    /**
     * THis method select user from the database by id.
     * @param id -  element which we want to find in data.
     * @return - user.
     */
    @Override
    public User findById(String id) {
        String task = new StringBuilder().append("select * from tablejsp where id = '").append(id).append("';").toString();
        User user = null;
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                user = new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    /**
     * This method make common parsing and indicate all id .
     * @param i - number during parser.
     * @return id of user.
     */
    public String IndicateID(int i){
        String task = new StringBuilder().append("select * from tablejsp;").toString();
        String id = null;
        int flag = 0;
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                if(flag == i) {
                    id = res.getString(1);
                }
                flag++;
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}

