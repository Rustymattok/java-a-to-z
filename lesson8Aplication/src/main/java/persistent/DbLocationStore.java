package persistent;
import logic.CityType;
import logic.ClientType;
import logic.CountryType;
import logic.User;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;

public class DbLocationStore implements Store{
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbLocationStore INSTANCE = new DbLocationStore();

    public DbLocationStore () {
        String url = "jdbc:postgresql://localhost:5432";
        String userName = "postgres";
        String admin = "admin";
        SOURCE.setUrl(url);
        SOURCE.setUsername(userName);
        SOURCE.setPassword(admin);
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        initTable();
    }
    public static DbLocationStore getInstance() {
        return INSTANCE;
    }
    /**
     * This method init database with tables and Administrator.
     */
    public void initTable(){
        String create_seq = "CREATE SEQUENCE IF NOT EXISTS id_seq_a INCREMENT BY 1 NO MAXVALUE NO MINVALUE CACHE 1;";
        String taksCreateTable = new StringBuilder().append(create_seq)
                .append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("tableDB").append("(id integer DEFAULT nextval ('id_seq_a') NOT NULL, name text,login text,email text,role text,country text,city text);").toString();
        String createUser = new StringBuilder().append("INSERT INTO tableDB VALUES (").append(position()).append(",'root','root','root','")
                .append(String.valueOf(ClientType.ADMINISTRATOR)).append("','").append(String.valueOf(CountryType.RUSSIA)).append("','")
                .append(String.valueOf(CityType.MOSCOW)).append("')").toString();
        String task = new StringBuilder().append("SELECT * from tableDB WHERE login = 'root';").toString();
        try {
            Connection connection = SOURCE.getConnection();
            /*
            Operation to creation the table if not exists.
             */
            Statement st = connection.prepareStatement(taksCreateTable);
            ((PreparedStatement) st).executeUpdate();
            st.close();
            /*
            Operation to administrator if he absent
             */
            Statement sta = connection.createStatement();
            ResultSet res = sta.executeQuery(task);
            if(res.next() == false) {
                Statement stUser = connection.prepareStatement(createUser);
                ((PreparedStatement) stUser).executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * This Method add to database additional item.
     * @param user - added element to data.
     */
    public void add(User user) {
        String taskInsertIntoTable = new StringBuilder().append("INSERT INTO ").append("tableDB")
                .append(" VALUES (?,?,?,?,?,?,?)").toString();
        /*
          add auto role. By default it is user.
         */
       // user.setRole(String.valueOf(ClientType.USER));
     /*   user.setCountry(String.valueOf(CountryType.RUSSIA));
        user.setCity(String.valueOf(CityType.KOLN));*/
        try {
            Connection connection = SOURCE.getConnection();
            PreparedStatement sta = connection.prepareStatement(taskInsertIntoTable);
            sta.setInt(1, position());
            sta.setString(2,user.getName());
            sta.setString(3,user.getLogin());
            sta.setObject(4,user.getEmail());
            sta.setObject(5,user.getRole().toUpperCase());
            sta.setObject(6,user.getCountry());
            sta.setObject(7,user.getCity());
            sta.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String id, User user) {
        Integer idc = Integer.valueOf(id);
        String task = new StringBuilder().append(" UPDATE tableDB SET name = '").append(user.getName()).append("',login = '").
                append(user.getLogin()).append("',email = '").append(user.getEmail()).append("',role = '").append(user.getRole()).
                append("',country = '").append(user.getCountry()).append("',city = '").
                append(user.getCity()).append("' WHERE id = '").append(idc).append("';").toString();
        doTask(task);
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
        Integer idc = Integer.valueOf(id);
        String task = new StringBuilder().append(" UPDATE tableDB SET name = '").append(name).append("',login = '").
                append(login).append("',email = '").append(email).append("' WHERE id = '").append(idc).append("';").toString();
        doTask(task);
    }
    /**
     *This method delete element from data by ID.
     * @param id - of use which we want to delete.
     */
    public void delete(String id) {
        String task = new StringBuilder().append("DELETE FROM tableDB WHERE id = '").append(id).append("';").toString();
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
        String task = new StringBuilder().append("select count(*) from tableDB;").toString();
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
    //todo тут стоп
    public User findById(String id) {
        id = IndicateID(Integer.valueOf(id));
        String task = new StringBuilder().append("select * from tableDB where id = '").append(id).append("';").toString();
        User user = new User();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                user = new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5),res.getString(6),res.getString(7));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User findByIdAlternative(String id) {
        System.out.println();
        Integer index = Integer.valueOf(id);
        String task = new StringBuilder().append("select * from tableDB where id = '").append(index).append("';").toString();
        User user = new User();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                user = new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5),res.getString(6),res.getString(7));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * THis method select user from the database by login and name.
     * @param login- parameter in data sql login.
     * @param password- parameter in data sql name.
     * @return user from data sql.
     */
    public User findById(String login,String password) {
        String task = new StringBuilder().append("select * from tableDB where login = '").append(login).
                append("' and name ='").append(password).append("'").toString();
        User user = null;
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                user = new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
    /**
     * Find in data login with password.
     * @param login - login parameter from sql.
     * @param password - name parameter from sql.
     * @return true/false .
     */
    public boolean isCredentional(String login,String password){
        boolean flag = false;
        User user = null;
        String task = new StringBuilder().append("select * from tableDB where login = '").append(login).
                append("' and name ='").append(password).append("'").toString();
        try {
            Connection connection = SOURCE.getConnection();
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                user = new User(res.getString(1), res.getString(2), res.getString(3), res.getString(4),res.getString(5));
                if(user.getLogin().equals(login) && user.getName().equals(password)){
                    flag = true;
                }
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * This method select user from the database by id and update role.
     * @param id -  element which we want to find in data.
     * @param role- element which we should update.
     */
    public void alterFindById(String id, String role) {
        String task = new StringBuilder().append(" UPDATE tableDB SET role = '").append(role).
                append("' WHERE id = '").append(id).append("';").toString();
        doTask(task);
    }
    /**
     * This method make common parsing and indicate all id .
     * @param i - number during parser.
     * @return id of user.
     */
    public String IndicateID(int i){
        String task = new StringBuilder().append("select * from tableDB;").toString();
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
