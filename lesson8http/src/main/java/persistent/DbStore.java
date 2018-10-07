package persistent;

import logic.User;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbStore implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private final List<User> list= Collections.synchronizedList(new ArrayList());
    private static DbStore INSTANCE = new DbStore();
    static int ID = 0;

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
    @Override
    public void add(User user){
       String taskInsertIntoTable = new StringBuilder().append("INSERT INTO ").append("tableJSP")
                .append(" VALUES (?,?,?,?)").toString();
       String taksCreateTable = new StringBuilder()
                .append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("tableJSP").append("(id text,name text,login text,email text);").toString();
        String countId = new StringBuilder().append("SELECT count(*) FROM tablejsp;").toString();
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
            while (res.next()){
                resultID = res.getString(1);
            }
            user.setId(String.valueOf(Integer.valueOf(resultID)+1));
            /*
            Statment to add user to Data.
             */
            PreparedStatement sta = connection.prepareStatement(taskInsertIntoTable);
            sta.setString(1,user.getId());
            sta.setString(2,user.getName());
            sta.setString(3,user.getLogin());
            sta.setObject(4,user.getEmail());
            sta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String name, String login, String email) {
        //todo обновить согласно запросу.
        /*
        UPDATE tablejsp SET name = 'vova',login = 'vova',email = 'vova' WHERE id = '6';
         */
    }

    @Override
    public void delete(String id) {
        String task = new StringBuilder().append("DELETE FROM tablejsp WHERE id = '").append(id).append("';").toString();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            st.executeUpdate(task);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        String task = new StringBuilder().append("select * from tablejsp;").toString();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                list.add(new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.size();
    }
//todo спросить Петра про такой способ реализации.
    @Override
    public User findById(String id) {
        String task = new StringBuilder().append("select * from tablejsp;").toString();
        System.out.println("ahtuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuung");
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                list.add(new User(res.getString(1),res.getString(2),res.getString(3),res.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list.get(Integer.valueOf(id)-1);
    }

    @Override
    public List<User> getList() {
        return list;
    }
}
