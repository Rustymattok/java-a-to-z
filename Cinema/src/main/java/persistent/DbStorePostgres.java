package persistent;
import logic.Halls;
import logic.User;
import org.apache.commons.dbcp.BasicDataSource;
import java.sql.*;
import java.util.List;
/**
 * Class for work with dataBase - postrgesql.
 * Before work of activities we should init Halls by method initPlaces.
 * We add to accountDB users wich transaction for buy tickets was successful.
 */
public class DbStorePostgres implements Store {
    private static final BasicDataSource SOURCE = new BasicDataSource();
    private static DbStorePostgres INSTANCE = new DbStorePostgres();
    private final static double USERBALANCE = 500;
    private Connection connection = null;

    public DbStorePostgres() {
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

    public static DbStorePostgres getINSTANCE() {
        return INSTANCE;
    }
    /**
     * Method to init dataBase if it not exists.
     */
    public void initTable() {
        String taskCreatHalls = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("hallDB").append("(hall_no integer PRIMARY KEY, row text,place text,status text,price DOUBLE PRECISION);").toString();
        String taskCreatUser = new StringBuilder().append("CREATE TABLE IF NOT EXISTS").append(" ")
                .append("accountDB").append("(hall_no integer REFERENCES hallDB, name text,phone text,balance DOUBLE PRECISION);").toString();
        try {
            connection = SOURCE.getConnection();
            /*
            Operation to creation the table of Halls if not exists.
             */
            Statement stHalls = connection.prepareStatement(taskCreatHalls);
            ((PreparedStatement) stHalls).executeUpdate();
            stHalls.close();
                   /*
            Operation to creation the table of Accounts if not exists.
             */
            Statement stUser = connection.prepareStatement(taskCreatUser);
            ((PreparedStatement) stUser).executeUpdate();
            stUser.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to form halls data.
     *
     * @param rows   - value of rows.
     * @param places - value of places.
     * @param price  - value of cost ticket.
     */
    public void initPlaces(int rows, int places, double price) {
        try {
            String task = new StringBuilder().append("INSERT INTO ").append("hallDB ").append("VALUES(?,?,?,?,?)").toString();
            int num = 0;
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= places; j++) {
                    connection = SOURCE.getConnection();
                    PreparedStatement st = connection.prepareStatement(task);
                    st.setInt(1, ++num);
                    st.setString(2, String.valueOf(i));
                    st.setString(3, String.valueOf(j));
                    st.setString(4, "free");
                    st.setDouble(5, price);
                    st.executeUpdate();
                    connection.close();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method to update status of Hall.
     * @param row    -  horisantal position.
     * @param place  - current place to update.
     * @param status - block or free.
     */
    public void updatePlace(String row, String place, String status) {
        String updateHall = new StringBuilder().append("UPDATE halldb SET status='").append(status).append("' WHERE row='")
                .append(row).append("' and place='").append(place).append("'").toString();
        try {
            PreparedStatement st = connection.prepareStatement(updateHall);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * THis method responsoble for check status of hall - free(true) or block(false).
     * @param row   - value of role.
     * @param place - value of place.
     * @return - true or false.
     */
    public boolean checkTransactionHall(String row, String place) {
        boolean flag = false;
        String result = "";
        String selectIDHall = new StringBuilder().append("SELECT status FROM halldb WHERE ").append("row='").append(row).append("' and place='")
                .append(place).append("'").toString();
        try {
            Statement stReq = connection.createStatement();
            ResultSet res = stReq.executeQuery(selectIDHall);
            while (res.next()) {
                result = res.getString(1);
            }
            res.close();
            if (result.equals("free")) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * Method add new user if he start order ticket or update status after ordered.
     * @param user  - which you want to add.
     * @param list  - list of halls.
     */
    public void addUser(User user, List<Integer> list) {
        try {
            connection.setAutoCommit(false);
            if(selectUSER(user)){
                user.setBalance(selectBalance(user));
            } else {
                /*
                    In real life we don't use this condition. All info should be take from Bank data.
                 */
                user.setBalance(USERBALANCE);
            }
            double commonPrice = 0 ;
            for (Integer k : list) {
                commonPrice = commonPrice + selectByIDHalls(k).getPrice();
            }
            if(user.getBalance() >= commonPrice) {
                for (int i = 0; i < list.size(); i++) {
                    Integer id = Integer.valueOf(list.get(i));
                    updateStatus(user, selectByIDHalls(id).getRow(), selectByIDHalls(id).getPlace());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * THis method for update data for users as for halls.
     * @param user - user to update.
     * @param row - row to update.
     * @param place - place to update.
     */
    public void updateStatus(User user,String row,String place){
        Integer id = null;
        String selectIDHall = new StringBuilder().append("SELECT hall_no FROM halldb WHERE ").append("row='").append(row).append("' and place='")
                .append(place).append("'").toString();
        String task = new StringBuilder().append("INSERT INTO ").append("accountDB ").append("VALUES(?,?,?,?)").toString();
        try {
        PreparedStatement st = connection.prepareStatement(task);
        Statement stReq = null;
            stReq = connection.createStatement();
        ResultSet res = stReq.executeQuery(selectIDHall);
        while (res.next()) {
            id = res.getInt(1);
        }
        res.close();
            /*
                By this operation we take price of ticket from database of Halls.
             */
        Double cost = takePriceTicket(String.valueOf(row), String.valueOf(place));
            /*
                By this operation first we check transaction -  free or block choosed place and balance of user.
             */
        if (checkTransactionHall(String.valueOf(row), String.valueOf(place)) && checkTransactionUser(user, cost)) {
            updatePlace(String.valueOf(row), String.valueOf(place), "block");
            st.setInt(1, id);
            st.setString(2, user.getName());
            st.setString(3, user.getPhone());
            st.setDouble(4, user.getBalance());
            st.executeUpdate();
            connection.commit();
        } else {
                /*
                    If not regarding our condition all activities for database droped.
                 */
            connection.rollback();
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /**
     * Method allow to check in data new user or the same.
     * @param user -  parameter of user.
     * @return true or false.
     */
    public boolean selectUSER(User user){
        boolean flag = false;
        String selectUser ="SELECT hall_no FROM accountdb WHERE name='" + user.getName() + "'and phone='" + user.getPhone() + "'";
        try {
            PreparedStatement st = connection.prepareStatement(selectUser);
            Statement stReq = connection.createStatement();
            ResultSet res = stReq.executeQuery(selectUser);
            while (res.next()) {
                flag = true;
                //Integer id = res.getInt(1);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  flag;
    }
    /**
     * Method for take current balance of user.
     * @param user - which we want to take balance.
     * @return balance - value from user.
     */
    public double selectBalance(User user) {
        Double id = null;
        String selectUser ="SELECT balance FROM accountdb WHERE name='" + user.getName() + "'and phone='" + user.getPhone() + "'";
        try {
            PreparedStatement st = connection.prepareStatement(selectUser);
            Statement stReq = connection.createStatement();
            ResultSet res = stReq.executeQuery(selectUser);
            while (res.next()) {
                id = res.getDouble(1);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
    /**
     * Method for  check balance of users.
     * @param user -  user which we want to update.
     * @param cost - price of ticket.
     * @return - true of false.
     */
    public boolean checkTransactionUser(User user, Double cost) {
        boolean flag = false;
        try {
            if (connection.isClosed()) {
                connection = SOURCE.getConnection();
            }
            Double balance = user.getBalance();
            if (balance != null) {
                if (cost <= balance) {
                    balance = balance - cost;
                    String updateBalance = new StringBuilder().append("UPDATE accountdb SET balance='").append(balance).append("' WHERE name='")
                            .append(user.getName()).append("' and phone='").append(user.getPhone()).append("'").toString();
                    PreparedStatement stBalance = connection.prepareStatement(updateBalance);
                    user.setBalance(balance);
                    stBalance.executeUpdate();
                    stBalance.close();
                    flag = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
    /**
     * Method to take from DB halls cost of place.
     * @param row   - value of choosed row.
     * @param place - value of choosed place.
     * @return price of ticket.
     */
    public double takePriceTicket(String row, String place) {
        Double price = null;
        String selectPriceHall = new StringBuilder().append("SELECT price FROM halldb WHERE ").append("row='").append(row).append("' and place='")
                .append(place).append("'").toString();
        try {
            Statement stReq = connection.createStatement();
            ResultSet res = stReq.executeQuery(selectPriceHall);
            while (res.next()) {
                price = res.getDouble(1);
            }
            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return price;
    }
    /**
     * This method calculate common size of data .
     * @return - size of data.
     */
    public int sizeData() {
        Integer i = null;
        String task = new StringBuilder().append("select count(*) from halldb;").toString();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(task);
            while (res.next()){
                i = Integer.valueOf(res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return i;
    }
    /**
     * This method select Hall by ID .
     * @return - value of Hall.
     */
    public Halls selectByIDHalls(Integer id) {
        Halls hall = null;
        String selectHall = new StringBuilder().append("select * from halldb where hall_no='").append(id).append("'").toString();
        try {
            Statement st = connection.createStatement();
            ResultSet res = st.executeQuery(selectHall);
            while (res.next()){
                String row = res.getString(2);
                String place = res.getString(3);
                String status = res.getString(4);
                Double price = res.getDouble(5);
                hall = new Halls(id,row,place,status,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hall;
    }
}