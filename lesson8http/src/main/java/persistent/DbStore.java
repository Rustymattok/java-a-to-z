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
    private List<User> list = Collections.synchronizedList(new ArrayList());
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
        parser();
    }

    public void parser() {
        String task = new StringBuilder().append("select * from tablejsp;").toString();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            if (list.size() > 0) {
                list.clear();
            }
            while (res.next()) {
                list.add(new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4)));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DbStore getInstance() {
        return INSTANCE;
    }
//todo НАдо ращобраться с индексом -  все беды от него только.
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
            parser();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(String id, String name, String login, String email) {
        //todo обновить согласно запросу.
        String task = new StringBuilder().append(" UPDATE tablejsp SET name = '").append(name).append("',login = '").
                append(login).append("',email = '").append(email).append("' WHERE id = '").append(id).append("';").toString();
       doTask(task);
    }

    @Override
    public void delete(String id) {
        String task = new StringBuilder().append("DELETE FROM tablejsp WHERE id = '").append(id).append("';").toString();
        doTask(task);
    }

    public void doTask(String task){
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            st.executeUpdate(task);
           // connection.close();
            parser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int size() {
        parser();
        return list.size();
    }

    //todo спросить Петра про такой способ реализации.
    @Override
    public User findById(String id) {
        return list.get(Integer.valueOf(id));
    }
}

