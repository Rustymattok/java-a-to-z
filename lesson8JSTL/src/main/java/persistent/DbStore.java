package persistent;
import logic.User;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;
public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStore INSTANCE = new DbStore();
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

    public void add(User user) {
        String taskInsertIntoTable = new StringBuilder().append("INSERT INTO ").append("tableJSP")
                .append(" VALUES (?,?,?,?)").toString();

        String create_seq = "CREATE SEQUENCE IF NOT EXISTS id_seq_a INCREMENT BY 1 NO MAXVALUE NO MINVALUE CACHE 1;";

        String taksCreateTable = new StringBuilder().append(create_seq)
                .append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("tableJSP").append("(id integer DEFAULT nextval ('id_seq_a') NOT NULL, name text,login text,email text);").toString();

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

            PreparedStatement sta = connection.prepareStatement(taskInsertIntoTable);
            sta.setInt(1, position());
            sta.setString(2, user.getName());
            sta.setString(3, user.getLogin());
            sta.setObject(4, user.getEmail());
            sta.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Integer position(){
       Integer position =  null;
        try {
            Connection connection = SOURCE.getConnection();
            String  result = "SELECT nextval('id_seq_a'::regclass); ";
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(result);
            while (res.next()){
                position = Integer.valueOf(res.getString(1));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
    /**
     * This method update element of data by ID.
     * @param id - id user.
     * @param name - name user.
     * @param login - login user.
     * @param email - email user.
     */
    public void update(String id, String name, String login, String email) {
        String task = new StringBuilder().append(" UPDATE tablejsp SET name = '").append(name).append("',login = '").
                append(login).append("',email = '").append(email).append("' WHERE id = '").append(id).append("';").toString();
        doTask(task);
    }
    /**
     *This method delete element from data by ID.
     * @param id - of use which we want to delete.
     */
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
    public User findById(String id) {
        id = IndicateID(Integer.valueOf(id));
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
